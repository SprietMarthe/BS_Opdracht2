package src.com.BS_Opdracht2_MariekeBeke_MartheSpriet;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.*;
import java.io.File;
import java.util.*;
import java.util.List;

public class App {
    private JPanel panelMain;
    private JButton allProcesses;
    private JButton oneProcess;
    private JPanel ButtonPanel;
    private JPanel InfoPanel;
    private JTable PageTable;
    private JTable RamTable;
    private JLabel TimerLabel;
    private JLabel TimerValue;
    private JLabel InsturctieLabel;
    private JLabel InstructieValue;
    private JLabel AdresLabel;
    private JLabel AdresValue;
    private JLabel ScrijfopdrachtenLabel;
    private JLabel SchrijfopdrachtenValue;
    private JLabel RamLabel;
    private JLabel PageTableLabel;

    static final int welkeXMLFile=1;
    static List<Process> present_process_list;
    static List<Process> process_list;
    static int timer;
    static Queue<Instruction> instructions;
    static RAM ram;
    static final int numberOfFrames=12;
    static final int numberOfPages=16;
    static int amountOfWrites;

    public static void main(String[] argv) {
        Scanner sc = new Scanner(System.in);

        initialiseren();
        readingWholeXMLFile();
        displayJFrame();

        sc.close();
    }






    private static void initialiseren() {
        present_process_list = new ArrayList<>();
        process_list = new ArrayList<>();
        timer = 0;
        instructions = new LinkedList<>();
        ram = new RAM(numberOfFrames);
    }
    private static void displayJFrame() {
        JFrame frame= new JFrame("App");
        frame.setContentPane(new App().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(new Dimension(1200, 700));
    }
    public static void readingWholeXMLFile(){
        File file = null;
        try {
            switch (welkeXMLFile) {
                case 1 -> file = new File("Instructions_30_3.xml");
                case 2 -> file = new File("Instructions_20000_4.xml");
                case 3 -> file = new File("Instructions_20000_20.xml");
                default -> {
                }
            }
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("instruction");
            for (int itr = 0; itr < nodeList.getLength(); itr++) {
                Node node = nodeList.item(itr);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;
                    Instruction instruction = new Instruction(
                            Integer.parseInt(eElement.getElementsByTagName("processID").item(0).getTextContent()),
                            eElement.getElementsByTagName("operation").item(0).getTextContent(),
                            Integer.parseInt(eElement.getElementsByTagName("address").item(0).getTextContent())
                            );
                    instructions.add(instruction);
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }




    private void executeOneInstruction() {
        Instruction instruction = instructions.poll();
        System.out.print(instruction);
        assert instruction != null;
        if (instruction.getOperation() == OperationProcess.Start){
            operationStart(instruction);
        }
        else if (instruction.getOperation() == OperationProcess.Read){
            operationRead(instruction);
        }
        else if (instruction.getOperation() == OperationProcess.Write){
            operationWrite(instruction);
        }
        else if (instruction.getOperation() == OperationProcess.Terminate){
            operationTerminate(instruction);
        }
    }



    private void operationTerminate(Instruction instruction) {
        Process process = null;
        for (Process p: process_list){
            if (p.getProcessID() == instruction.getProcessID()){
                process = p;
            }
        }
        process_list.remove(process);
        present_process_list.remove(process);
        System.out.print("Process verwijderd: " + process);
        removeProcessFromRAM();
    }

    private void operationWrite(Instruction instruction) {
        timer++;
    }

    private void operationRead(Instruction instruction) {
        boolean processIsInRAM = false;
        for (int i=0; i<present_process_list.size(); i++) {
            if (instruction.getProcessID() == present_process_list.get(i).getProcessID()) processIsInRAM=true;
        }

        if (!processIsInRAM) {
            addProcessToRAM();      // gebruik hier methode die jij gemaakt heb, ben niet zeker of mijn gebruik juist is
        }
        else {
            boolean pageIsInRAM = false;
            for (Frame f : ram.getList_frames()) {
                if ((f.getPid() == instruction.getProcessID() && (f.getPagenummer() == instruction.getAddress() / 4096)))
                    pageIsInRAM = true;
            }
            if (!pageIsInRAM) {
                // schrijf lru uit ram als modify bit = 1
                Page lru = leastRecentlyUsed();
                removePageFromRAM(lru);
                // anders gewoon verwijderen
            }
        }

        // recently used variabele aanpassen

        timer++;
    }

    private void operationStart(Instruction instruction) {
        Process process = new Process(
                instruction.getProcessID(),
                new PageTable(timer, numberOfPages),
                0
        );
        System.out.print("Process toegevoegd: " + process);
        present_process_list.add(process);
        process_list.add(process);
        addProcessToRAM();
    }



    private void removeProcessFromRAM() {
        int numberOfProcessesPresent = present_process_list.size();
        int numberOfFramesPerProcess = numberOfFrames/numberOfProcessesPresent;
//        int[] frameNumbersOfProcess1 = new int[12];
//        int[] frameNumbersOfProcess2 = new int[12];
//        int[] frameNumbersOfProcess3 = new int[12];
//        int[] frameNumbersOfProcess4 = new int[12];
//
//        for (int i=0; i<present_process_list.size(); i++){
//            pidPresentProcesses[i] = present_process_list.get(i).getProcessID();
//        }
        List<Frame> old_list_frames = ram.getList_frames();
//        List<Frame> new_list_frames = new ArrayList<>();

        for (int i = 0; i<numberOfProcessesPresent; i++){
            for (int j=0; j<numberOfFramesPerProcess; j++){
                ram.getList_frames().get(i*numberOfFramesPerProcess + j)
                        .setPid(present_process_list.get(i).getProcessID());
                ram.getList_frames().get(i*numberOfFramesPerProcess + j)
                        .setPagenummer(old_list_frames.get(i*numberOfFramesPerProcess + j).getPagenummer());
            }
        }
        System.out.println("\nRam herverdeeld: " + ram);
        System.out.println("numberOfProcessesPresent: " + numberOfProcessesPresent);
        System.out.println("numberOfFramesPerProcess: " + numberOfFramesPerProcess);
    }

    private void addProcessToRAM() {
        int numberOfProcessesPresent = present_process_list.size();
        int numberOfFramesPerProcess = numberOfFrames/numberOfProcessesPresent;
        for (int i = 0; i<numberOfProcessesPresent; i++){
            for (int j=0; j<numberOfFramesPerProcess; j++){
                ram.getList_frames().get(i*numberOfFramesPerProcess + j)
                        .setPid(present_process_list.get(i).getProcessID());
            }
        }
        System.out.println("\nRam herverdeeld: " + ram);
        System.out.println("numberOfProcessesPresent: " + numberOfProcessesPresent);
        System.out.println("numberOfFramesPerProcess: " + numberOfFramesPerProcess);
    }

    private Page leastRecentlyUsed() {
        int min = timer;
        Process p = new Process();
        for (Frame f: ram.getList_frames()) {
            // process vinden om aan de pagetable te kunnen
            for (int i=0; i<present_process_list.size(); i++) {
                if (present_process_list.get(i).getProcessID() == f.getPid()) {
                    p = present_process_list.get(i);
                }
            }

            for (Page page : p.getPageTable().getList_pages()) {
                if (page.getLastAccessTime() < min) min = page.getLastAccessTime();
            }


        }
        Page tijdelijk = new Page();
        return tijdelijk;
    }

    private void removePageFromRAM(Page lru) {
        if (lru.getModifyBit() == 1) {
            lru.setPresentBit(0);
            lru.setModifyBit(0);
            lru.setCorrespondingFrameNumber(-1);
            amountOfWrites++;
        }
        ram.getList_frames().get(lru.getCorrespondingFrameNumber()).setPid(-1);
        ram.getList_frames().get(lru.getCorrespondingFrameNumber()).setPagenummer(-1);
    }


    public App() {
        oneProcess.addActionListener(e -> {
            if (!instructions.isEmpty()){
                executeOneInstruction();
            }
            else
                System.out.println("All instructions are executed!");

//            //JOptionPane.showMessageDialog(null, "Hello world");
//            TimerValue.setText(String.valueOf(timer));              // voorbeeld
//            TimerValue.setVisible(true);
        });
        allProcesses.addActionListener(e -> {
            while(!instructions.isEmpty()){
                executeOneInstruction();
            }
        });
    }
}
