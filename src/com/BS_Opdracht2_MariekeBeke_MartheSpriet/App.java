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
    private JButton executeOneProcessButton;
    private JButton executeAllProcessesButton;
    private JPanel PanelPageNumber;
    private JPanel PanelPresentBit;
    private JLabel PN15_PB;
    private JLabel PN14_PB;
    private JLabel PN13_PB;
    private JLabel PN12_PB;
    private JLabel PN11_PB;
    private JLabel PN10_PB;
    private JLabel PN9_PB;
    private JLabel PN8_PB;
    private JLabel PN7_PB;
    private JLabel PN6_PB;
    private JLabel PN5_PB;
    private JLabel PN4_PB;
    private JLabel PN3_PB;
    private JLabel PN2_PB;
    private JLabel PN1_PB;
    private JLabel PN0_PB;
    private JPanel PanelModifyBit;
    private JLabel PN15_MB;
    private JLabel PN14_MB;
    private JLabel PN13_MB;
    private JLabel PN12_MB;
    private JLabel PN11_MB;
    private JLabel PN10_MB;
    private JLabel PN9_MB;
    private JLabel PN8_MB;
    private JLabel PN7_MB;
    private JLabel PN6_MB;
    private JLabel PN5_MB;
    private JLabel PN4_MB;
    private JLabel PN3_MB;
    private JLabel PN2_MB;
    private JLabel PN1_MB;
    private JLabel PN0_MB;
    private JPanel PanelLMT;
    private JLabel PN0_LMT;
    private JLabel PN1_LMT;
    private JLabel PN2_LMT;
    private JLabel PN3_LMT;
    private JLabel PN4_LMT;
    private JLabel PN5_LMT;
    private JLabel PN6_LMT;
    private JLabel PN7_LMT;
    private JLabel PN8_LMT;
    private JLabel PN9_LMT;
    private JLabel PN10_LMT;
    private JLabel PN11_LMT;
    private JLabel PN12_LMT;
    private JLabel PN13_LMT;
    private JLabel PN14_LMT;
    private JLabel PN15_LMT;
    private JPanel PanelFrameNumber;
    private JLabel PN0_FN;
    private JLabel PN1_FN;
    private JLabel PN2_FN;
    private JLabel PN3_FN;
    private JLabel PN4_FN;
    private JLabel PN5_FN;
    private JLabel PN6_FN;
    private JLabel PN7_FN;
    private JLabel PN_8FN;
    private JLabel PN9_FN;
    private JLabel PN10_FN;
    private JLabel PN11_FN;
    private JLabel PN12_FN;
    private JLabel PN13_FN;
    private JLabel PN14_FN;
    private JLabel PN15_FN;
    private JPanel PanelInstruction;
    private JLabel InstructionLabel;
    private JLabel InstrPIDLabel;
    private JLabel InstrPIDValue;
    private JLabel InstrOpLabel;
    private JLabel InstrOpValue;
    private JLabel InstrAddrLabel;
    private JLabel InstrAddrValue;
    private JLabel AddressLabel;
    private JLabel AddrVirtLAbel;
    private JLabel AddrVirtValue;
    private JLabel AddrRealLabel;
    private JLabel AddrRealValue;
    private JLabel PageTableLabel;
    private JPanel PanelInfoAndRam;
    private JPanel PTPanel;
    private JLabel RAMLabel;
    private JLabel FrameNumberLabel;
    private JLabel ProcessIDLabel;
    private JLabel PageNumberLabel;
    private JPanel FrameNumberPanel;
    private JPanel ProcessIDPanel;
    private JPanel PageNumberPanel;
    private JLabel FN0;
    private JLabel FN0_PID;
    private JLabel FN1;
    private JLabel FN1_PID;
    private JLabel FN1_PN;
    private JLabel FN2;
    private JLabel FN2_PID;
    private JLabel FN2_PN;
    private JLabel FN3;
    private JLabel FN3_PID;
    private JLabel FN3_PN;
    private JLabel FN4;
    private JLabel FN4_PID;
    private JLabel FN4_PN;
    private JLabel FN5;
    private JLabel FN5_PID;
    private JLabel FN5_PN;
    private JLabel FN6;
    private JLabel FN6_PID;
    private JLabel FN6_PN;
    private JLabel FN7;
    private JLabel FN7_PID;
    private JLabel FN7_PN;
    private JLabel FN8;
    private JLabel FN8_PID;
    private JLabel FN8_PN;
    private JLabel FN9;
    private JLabel FN9_PID;
    private JLabel FN9_PN;
    private JLabel FN10;
    private JLabel FN10_PID;
    private JLabel FN10_PN;
    private JLabel FN11;
    private JLabel FN11_PN;
    private JLabel FN11_PID;
    private JLabel FN0_PN;
    private JPanel ButtonPanel;
    private JPanel AddressPanel;
    private JLabel TimerValue;
    private JLabel TimerLabel;
    private JPanel TimerPanel;
    private JButton allProcesses;
    private JButton oneProcess;

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
//        JFrame frame= new JFrame("App");
//        frame.setContentPane(new App().panelMain);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();
//        frame.setVisible(true);
//        frame.setSize(new Dimension(1200, 700));

        JFrame frame = new JFrame("App2");
        frame.setContentPane(new App().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(new Dimension(1200, 700));
        frame.getContentPane().setBackground(Color.white);
        frame.getContentPane().getComponent(0).setBackground(Color.gray);
        frame.getContentPane().getComponent(1).setBackground(Color.gray);

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
        System.out.println(present_process_list);
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
        // controle of process al in de RAM zit
        boolean processIsInRAM = false;
        for (int i=0; i<present_process_list.size(); i++) {
            if (instruction.getProcessID() == present_process_list.get(i).getProcessID()) processIsInRAM=true;
        }

        // indien niet in RAM, toevoegen
        if (!processIsInRAM) {
            addProcessToRAM();      // gebruik hier methode die jij gemaakt heb, ben niet zeker of mijn gebruik juist is
        }

        // controleren of page al in RAM zit
        boolean pageIsInRAM = false;
        Page newPage = new Page(instruction.getAddress()/4096, 0, 0, 0, -1);
        for (Frame f : ram.getList_frames()) {
            if ((f.getPid() == instruction.getProcessID() && (f.getPagenummer() == instruction.getAddress() / 4096)))
                pageIsInRAM = true;
        }

        // indien niet in RAM, toevoegen
        int frameNumberOfChange = -1;
        if (!pageIsInRAM) {
            // zoek least recently used
            Page lru = leastRecentlyUsed();
            // eventueel wegschrijven, wordt in functie gecontroleerd als nodig
            frameNumberOfChange = removePageFromRAM(lru);
            // page toevoegen
            addPageToRAM(newPage, frameNumberOfChange, instruction);
        }
        newPage.setLastAccessTime(timer);
        newPage.setModifyBit(1);

        timer++;
    }

    private void operationRead(Instruction instruction) {
        // controle of process al in de RAM zit
        boolean processIsInRAM = false;
        for (int i=0; i<present_process_list.size(); i++) {
            if (instruction.getProcessID() == present_process_list.get(i).getProcessID()) processIsInRAM=true;
        }

        // indien niet in RAM, toevoegen
        if (!processIsInRAM) {
            addProcessToRAM();      // gebruik hier methode die jij gemaakt heb, ben niet zeker of mijn gebruik juist is
        }

        // controleren of page al in RAM zit
        boolean pageIsInRAM = false;
        Page newPage = new Page(instruction.getAddress()/4096, 0, 0, 0, -1);
        for (Frame f : ram.getList_frames()) {
            if ((f.getPid() == instruction.getProcessID() && (f.getPagenummer() == instruction.getAddress() / 4096)))
                pageIsInRAM = true;
        }

        // indien niet in RAM, toevoegen
        int frameNumberOfChange = -1;
        if (!pageIsInRAM) {
            // zoek least recently used
            Page lru = leastRecentlyUsed();
            // eventueel wegschrijven, wordt in functie gecontroleerd als nodig
            frameNumberOfChange = removePageFromRAM(lru);
            // page toevoegen
            addPageToRAM(newPage, frameNumberOfChange, instruction);
        }
        newPage.setLastAccessTime(timer);

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
        addProcessToRAM(process);
        System.out.print("c");

    }


    private void removeProcessFromRAM() {
        int numberOfProcessesPresent = present_process_list.size();
        int numberOfFramesPerProcess = numberOfFrames/numberOfProcessesPresent;
        List<Frame> old_list_frames = ram.getList_frames();

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

    private void addProcessToRAM(Process process) {
        int numberOfProcessesPresent = present_process_list.size();
        int numberOfFramesPerProcess = numberOfFrames/numberOfProcessesPresent;

        if(numberOfProcessesPresent == 1){
            for(int i=0; i<numberOfFramesPerProcess; i++){
                ram.getList_frames().get(i).setPid(present_process_list.get(0).getProcessID());
                ram.getList_frames().get(i).setPagenummer(i);
            }
        }
        System.out.println("\nRam herverdeeld: " + ram);
        System.out.println("numberOfProcessesPresent: " + numberOfProcessesPresent);
        System.out.println("numberOfFramesPerProcess: " + numberOfFramesPerProcess);
    }

    private Page leastRecentlyUsed() {
        int min = timer;
        Page lru = new Page();
        Process p = new Process();
        for (Frame f: ram.getList_frames()) {
            // process vinden om aan de pagetable te kunnen
            for (int i=0; i<present_process_list.size(); i++) {
                if (present_process_list.get(i).getProcessID() == f.getPid()) {
                    p = present_process_list.get(i);
                }
            }
            // kleinste acces time zoeken
            for (Page page : p.getPageTable().getList_pages()) {
                if (page.getLastAccessTime() < min) {
                    min = page.getLastAccessTime();
                    lru = page;
                }
            }
        }
        return lru;
    }

    private int removePageFromRAM(Page lru) {
        int frameNumberWithChange = lru.getCorrespondingFrameNumber();
        if (lru.getModifyBit() == 1) {
            lru.setPresentBit(0);
            lru.setModifyBit(0);
            lru.setCorrespondingFrameNumber(-1);
            amountOfWrites++;
        }
        ram.getList_frames().get(lru.getCorrespondingFrameNumber()).setPid(-1);
        ram.getList_frames().get(lru.getCorrespondingFrameNumber()).setPagenummer(-1);

        return frameNumberWithChange;
    }

    private void addPageToRAM(Page newPage, int numberOfFrame, Instruction instruction) {

        for (int i=0; i<ram.getList_frames().size(); i++) {
            if (numberOfFrame == ram.getList_frames().get(i).getFramenummer()) {
                ram.getList_frames().get(i).setPid(instruction.getProcessID());
                ram.getList_frames().get(i).setPagenummer(instruction.getAddress()/4096);
                newPage.setPageNumber(instruction.getAddress()/44096);
                newPage.setCorrespondingFrameNumber(numberOfFrame);
                newPage.setPresentBit(1);
            }
        }
    }

    public App() {
//        oneProcess.addActionListener(e -> {
//            if (!instructions.isEmpty()){
//                executeOneInstruction();
//            }
//            else
//                System.out.println("All instructions are executed!");
//
////            //JOptionPane.showMessageDialog(null, "Hello world");
////            TimerValue.setText(String.valueOf(timer));              // voorbeeld
////            TimerValue.setVisible(true);
//        });
//        allProcesses.addActionListener(e -> {
//            while(!instructions.isEmpty()){
//                executeOneInstruction();
//            }
//        });
        executeOneProcessButton.addActionListener(e -> {
            if (!instructions.isEmpty()){
                executeOneInstruction();
            }
            else
                System.out.println("All instructions are executed!");
        });
    }
}
