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

import static java.lang.Math.floor;

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
    private JLabel PN8_FN;
    private JLabel PN9_FN;
    private JLabel PN10_FN;
    private JLabel PN11_FN;
    private JLabel PN12_FN;
    private JLabel PN13_FN;
    private JLabel PN14_FN;
    private JLabel PN15_FN;
    private JLabel InstrPIDValue;
    private JLabel InstrOpValue;
    private JLabel InstrAddrValue;
    private JLabel AddrVirtValue;
    private JLabel AddrRealValue;
    private JPanel PanelInfoAndRam;
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
    private JLabel TimerValue;
    private JLabel CurrentTimerLabel;
    private JLabel NumberOfSwappesValue;
    private JLabel CurrentProcessValue;
    private JLabel NextInstrPIDValue;
    private JLabel NextInstrOpValue;
    private JLabel NextInstrAddrValue;
    private JLabel OffsetValue;

    static final int welkeXMLFile=1;
    static List<Process> present_process_list;
    static List<Process> process_list;
    static int timer;
    static Queue<Instruction> instructions;
    static RAM ram;
    static final int numberOfFrames=12;
    static final int numberOfPages=16;
    static int amountOfWrites;
    static Queue<Process> waitingProcesses;

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
        amountOfWrites = 0;
        instructions = new LinkedList<>();
        ram = new RAM(numberOfFrames);
        waitingProcesses = new LinkedList<>();
    }
    private static void displayJFrame() {
        JFrame frame = new JFrame("Opdracht2_OperatingSystems2");
        frame.setContentPane(new App().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(new Dimension(1200, 700));
        frame.getContentPane().setBackground(Color.white);
        frame.getContentPane().getComponent(0).setBackground(Color.gray);
        frame.getContentPane().getComponent(2).setBackground(Color.gray);

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
        //System.out.print(instruction);
        assert instruction != null;
        if (instruction.getOperation() == OperationProcess.Start){
            operationStart(instruction);
            //System.out.println(present_process_list);
        }
        else if (instruction.getOperation() == OperationProcess.Read){
            operationRead(instruction);
        }
        else if (instruction.getOperation() == OperationProcess.Write){
            operationWrite(instruction);
        }
        else if (instruction.getOperation() == OperationProcess.Terminate){
            operationTerminate(instruction);
            //System.out.println(present_process_list);
        }
        timer++;
        changeGUIValuesOneProcess(instruction);
    }

    private void operationTerminate(Instruction instruction) {
        Process process = findProcess(instruction.getProcessID());
        //System.out.print("Process verwijderd: " + process.getProcessID());
        removeProcessFromRAM(process);
    }
    private void operationWrite(Instruction instruction) {
        // VARIABLES BELONGING TO INSTRUCTION
        // Current process id
        int pID = instruction.getProcessID();
        // Current virtual adress
        int vAdress = instruction.getAddress();
        // Current process
        Process process = findProcess(instruction.getProcessID());
        // Current page number
        int pageNumber = (int) floor(vAdress/4096);
        // Current Page
        assert process != null;
        Page page = findPage(pageNumber, process.getPageTable().getList_pages());

        // MAKE SURE PAGE IS IN RAM
        // Is current process in RAM?
        boolean processInRAM = isProcessInRAM(pID);
        if (!processInRAM) {
            addProcessToRAM(pID);
        }
        // Is current page in RAM?
        boolean pageInRAM = isPageInRAM(pID, page);
        if (!pageInRAM) {
            addPageToRAM(process, page);
        }

        // WRITE
        assert page != null;
        page.setModifyBit(1);
        page.setLastAccessTime(timer);
    }
    private void operationRead(Instruction instruction) {
        // VARIABLES BELONGING TO INSTRUCTION
        // Current process id
        int pID = instruction.getProcessID();
        // Current virtual adress
        int vAdress = instruction.getAddress();
        // Current process
        Process process = findProcess(instruction.getProcessID());
        // Current page number
        int pageNumber = (int) floor(vAdress/4096);
        // Current Page
        assert process != null;
        Page page = findPage(pageNumber, process.getPageTable().getList_pages());
        // MAKE SURE PAGE IS IN RAM
        // Is current process in RAM?
        boolean processInRAM = isProcessInRAM(pID);
        if (!processInRAM) {
            addProcessToRAM(pID);
        }
        // Is current page in RAM?
        boolean pageInRAM = isPageInRAM(pID, page);
        if (!pageInRAM) {
            addPageToRAM(process, page);
        }

        // READ
        assert page != null;
        page.setLastAccessTime(timer);
    }
    private void operationStart(Instruction instruction) {
        Process process = new Process(
                instruction.getProcessID(),
                new PageTable(timer, numberOfPages)
        );
        //System.out.print("Process toegevoegd: " + process.getProcessID());
        process_list.add(process);
        addProcessToRAM(process.getProcessID());
    }



    private void removeProcessFromRAM(Process process) {
        int aantalFramesToegevoegdAanAndereProcesses = checkHoeveelFramesPerProcessToevoegen();
        //System.out.println("\n# Frames per process toegevoegd: " + aantalFramesToegevoegdAanAndereProcesses);
        List<Frame> toegevoegdeFrames = null;
        toegevoegdeFrames = findAllFramesPerProcess(process);
        //System.out.println("toegevoegdeFrames aan andere processen: " + toegevoegdeFrames);
        if (toegevoegdeFrames != null){
            if (waitingProcesses.isEmpty()){
                if (toegevoegdeFrames.size() != 12){
                    removePagesFromRam(process, toegevoegdeFrames);
                    present_process_list.remove(process);
                    GivingFramesToOtherProcesses(toegevoegdeFrames, aantalFramesToegevoegdAanAndereProcesses);
                }
                else{
                    //System.out.println("Geen processen meer in RAM");
                    setAllAddedFramesToNull(toegevoegdeFrames);
                    //System.out.println(ram.getList_frames());
                }
            }
            else {
                Process p = waitingProcesses.remove();
                for (Frame f : toegevoegdeFrames){
                    f.setPid(p.getProcessID());
                    f.setPagenummer(-1);
                }
            }
        }
    }
    private void removePagesFromRam(Process p, List<Frame> toegevoegdeFrames) {
        List<Page> list_pages_verwijderdUitRam = p.getPageTable().getList_pages();
        for (Frame f : toegevoegdeFrames){
            if (f.getPagenummer() != -1) {
                list_pages_verwijderdUitRam.get(f.getPagenummer()).setPresentBit(0);
                list_pages_verwijderdUitRam.get(f.getPagenummer()).setLastAccessTime(timer);
                list_pages_verwijderdUitRam.get(f.getPagenummer()).setCorrespondingFrameNumber(-1);
            }
        }
    }
    private void setAllAddedFramesToNull(List<Frame> toegevoegdeFrames) {
        for (Frame f : toegevoegdeFrames){
            f.setPid(-1);
            f.setPagenummer(-1);
        }
    }
    private void GivingFramesToOtherProcesses(List<Frame> toegevoegdeFrames, int aantalFramesToegevoegdAanAndereProcesses) {
        for (int j=0; j<present_process_list.size(); j++){
            for (int i=0; i<aantalFramesToegevoegdAanAndereProcesses; i++){
                int index = i + j*aantalFramesToegevoegdAanAndereProcesses;
                toegevoegdeFrames.get(index).setPid(present_process_list.get(j).getProcessID());
                toegevoegdeFrames.get(index).setPagenummer(-1);
            }
        }
        //System.out.println(ram.getList_frames());
    }
    private int checkHoeveelFramesPerProcessToevoegen() {
        if (present_process_list.size() == 1){
            return 0;
        }
        else if(present_process_list.size() == 2){
            return 6;
        }
        else if(present_process_list.size() == 3){
            return 2;
        }
        else if(present_process_list.size() == 4){
            return 1;
        }
        //System.out.println("numberOfProcessesPresent: " + present_process_list.size());
        return 0;
    }


    private void addProcessToRAM(int processID) {
        Process process = findProcess(processID);
        if (present_process_list.size() <= 4){
            int aantalFramesVerwijderenVanHuidigeProcesses = checkHoeveelFramesPerProcessVerwijderen();
            //System.out.println("\n# Frames per process verwijderen: " + aantalFramesVerwijderenVanHuidigeProcesses);

            List<Frame> verwijderdeFrames = new ArrayList<>();
            List<Frame> huidigeFramesPerProcess = null;
            for (Process p : present_process_list){
                huidigeFramesPerProcess = findAllFramesPerProcess(p);
                //System.out.println("huidigeFramesPerProcess: " + huidigeFramesPerProcess);
                findLRUFrame(verwijderdeFrames, huidigeFramesPerProcess, aantalFramesVerwijderenVanHuidigeProcesses);
                //System.out.println("verwijderdeFrames: " + verwijderdeFrames);
            }
            for (Frame f : verwijderdeFrames){
                removeFramesFromCurrentProcesses(f);
                f.setPid(processID);
                f.setPagenummer(-1);
            }
            if (huidigeFramesPerProcess == null){
                for (Frame f : ram.getList_frames()){
                    f.setPid(processID);
                    f.setPagenummer(-1);
                }
            }
            present_process_list.add(process);
        }
        else
            waitingProcesses.add(process);
        //System.out.println("\nRam herverdeeld: " + ram);
    }
    private void findLRUFrame(List<Frame> verwijderdeFrames, List<Frame> huidigeFramesPerProcess, int aantalNogVerwijderen) {
        for (int i=0; i<aantalNogVerwijderen; i++){
            Frame LRUFrame = null;
            int LRUwaarde = -1;
            boolean found = false;
            for (Frame f : huidigeFramesPerProcess){
                if (!found){
                    if (f.getPagenummer() == -1){
                        LRUFrame = f;
                        found=true;
                    }
                    else if (getLRU(f)>=LRUwaarde){
                        LRUwaarde = getLRU(f);
                        LRUFrame = f;
                    }
                }
            }
            if (LRUFrame != null) {
                verwijderdeFrames.add(LRUFrame);
                huidigeFramesPerProcess.remove(LRUFrame);
            }
        }
    }
    private int getLRU(Frame f) {
        int LATwaarde = -1;
        for (Process p :process_list){
            if (p.getProcessID() == f.getPid()){
                if (f.getPagenummer() != -1 && findLAT(p, f.getPagenummer()) > LATwaarde){
                    LATwaarde = findLAT(p, f.getPagenummer());
                }
            }
        }
        return LATwaarde;
    }
    private int findLAT(Process p, int pagenummer) {
        if (pagenummer != -1)
            return p.getPageTable().getList_pages().get(pagenummer).getLastAccessTime();
        else
            return -1;
    }
    private List<Frame> findAllFramesPerProcess(Process p) {
        List<Frame> huidigeFramesPerProcess = new ArrayList<>();
        for (Frame f : ram.getList_frames()){
            if (f.getPid() == p.getProcessID()){
                huidigeFramesPerProcess.add(f);
            }
        }
        return huidigeFramesPerProcess;
    }
    private int checkHoeveelFramesPerProcessVerwijderen() {
        int numberOfProcessesPresent = present_process_list.size();
        if (numberOfProcessesPresent == 0){
            return 0;
        }
        else if (numberOfProcessesPresent == 1){
            return 6;
        }
        else if(numberOfProcessesPresent == 2){
            return 2;
        }
        else if(numberOfProcessesPresent == 3){
            return 1;
        }
//        else if(numberOfProcessesPresent == 4){
//            return numberOfFrames/4;                  //in wachtrij zetten
//        }
        //System.out.println("numberOfProcessesPresent: " + numberOfProcessesPresent);
        return 0;
    }
    private void removeFramesFromCurrentProcesses(Frame frameVerwijderd) {
        if (frameVerwijderd.getPagenummer() != -1){
            for (Process p :present_process_list){
                if (p.getProcessID() == frameVerwijderd.getPid()) {
                    Page page = p.getPageTable().getList_pages().get(frameVerwijderd.getPagenummer());
                    page.setPresentBit(0);
                    if (page.getModifyBit() == 1) {
                        amountOfWrites++;
                        page.setModifyBit(0);
                        //System.out.println(amountOfWrites);
                    }
                    page.setLastAccessTime(timer);
                    page.setCorrespondingFrameNumber(-1);
                }
            }
        }
    }

    private boolean isProcessInRAM(int processID) {
        boolean inRAM = false;
        for (Process p: present_process_list) {
            if (p.getProcessID() == processID) {
                inRAM = true;
                break;
            }
        }
        return inRAM;
    }
    private boolean isPageInRAM(int processID, Page page) {
        boolean inRAM = false;
        Process p = findProcess(processID);
        if (p != null) {
            if (page.getCorrespondingFrameNumber() != -1) {
                inRAM = true;
            }
        }
        return inRAM;
    }
    private Page leastRecentlyUsed(Process process) {
        int min = timer;
        Page lru = null;
        for (Frame f: ram.getList_frames()) {
            if (f.getPid() == process.getProcessID() && process.getPageTable().getList_pages().get(f.getPagenummer()).getLastAccessTime() < min) {
                min = process.getPageTable().getList_pages().get(f.getPagenummer()).getLastAccessTime();
                lru = process.getPageTable().getList_pages().get(f.getPagenummer());
            }
        }
        return lru;
    }

    private void addPageToRAM(Process process, Page page) {
        // Look for empty frame
        int frameNumber = -1;
        boolean found = false;
        for (Frame f: ram.getList_frames()) {
            if (f.getPid() == process.getProcessID()) {
                if (f.getPagenummer() == -1){
                    found = true;
                    frameNumber = f.getFramenummer();
                }
            }
        }

        if (!found) {
            frameNumber = removeOnePageFromRAM(process);
        }

        // Connect page to frame
        page.setPresentBit(1);
        page.setLastAccessTime(timer);
        page.setCorrespondingFrameNumber(frameNumber);

        ram.getList_frames().get(frameNumber).setPagenummer(page.getPageNumber());
        amountOfWrites++;
    }

    private int removeOnePageFromRAM(Process process) {
        Page lru = leastRecentlyUsed(process);
        int frameNumber = lru.getCorrespondingFrameNumber();
        lru.setCorrespondingFrameNumber(-1);
        lru.setPresentBit(0);
        if (lru.getModifyBit() == 1) {
            amountOfWrites++;
            //System.out.println(amountOfWrites);
            lru.setModifyBit(0);
        }
        return frameNumber;
    }


    private Process findProcess(int processID) {
        for (Process p: process_list){
            if (p.getProcessID() == processID)
                return p;
        }
        return null;
    }
    private Page findPage(int pageNumber, List<Page> list_pages) {
        for (Page p: list_pages) {
            if (p.getPageNumber() == pageNumber)
                return p;
        }
        return null;
    }


    private void changeGUIValuesOneProcess(Instruction instruction) {
        TimerValue.setText(String.valueOf(timer));

        setInstructiesGUI(instruction);
        setAddressenGUI(instruction);

        NumberOfSwappesValue.setText(String.valueOf(amountOfWrites));

        changeGUIRAM();
        changeGUIPT(instruction);
    }
    private void setInstructiesGUI(Instruction instruction) {
        InstrPIDValue.setText(String.valueOf(instruction.getProcessID()));
        InstrOpValue.setText(String.valueOf(instruction.getOperation()));
        InstrAddrValue.setText(String.valueOf(instruction.getAddress()));

        if (!instructions.isEmpty()){
            Instruction instr = instructions.peek();
            NextInstrPIDValue.setText(String.valueOf(instr.getProcessID()));
            NextInstrOpValue.setText(String.valueOf(instr.getOperation()));
            NextInstrAddrValue.setText(String.valueOf(instr.getAddress()));
        }
        else{
            NextInstrPIDValue.setText("Null");
            NextInstrOpValue.setText("Null");
            NextInstrAddrValue.setText("Null");
        }
    }
    private void setAddressenGUI(Instruction instruction) {
        //virtual address
        int virtual = instruction.getAddress();
        AddrVirtValue.setText(String.valueOf(virtual));
        // real address
        int pageNumber = (int) floor(virtual/4096);
        int offset = virtual-pageNumber*4096;
        int frameNumber = 0;
        for (Frame f: ram.getList_frames()) {
            if (f.getPagenummer() == pageNumber) {
                frameNumber = f.getFramenummer();
            }
        }
        int real = frameNumber*4096 + offset;
        AddrRealValue.setText(String.valueOf(real));
        // offset
        OffsetValue.setText(String.valueOf(offset));
    }
    private void changeGUIPT(Instruction instruction) {
        Process process = null;
        for (Process p: process_list){
            if (p.getProcessID() == instruction.getProcessID()){
                process = p;
            }
        }
        if (process != null && instruction.getOperation() != OperationProcess.Terminate) {
            CurrentProcessValue.setText(String.valueOf(process.getProcessID()));

            PN0_PB.setText(String.valueOf(process.getPageTable().getList_pages().get(0).getPresentBit()));
            PN0_MB.setText(String.valueOf(process.getPageTable().getList_pages().get(0).getModifyBit()));
            PN0_LMT.setText(String.valueOf(process.getPageTable().getList_pages().get(0).getLastAccessTime()));
            PN0_FN.setText(getStringValue(process.getPageTable().getList_pages().get(0).getCorrespondingFrameNumber()));

            PN1_PB.setText(String.valueOf(process.getPageTable().getList_pages().get(1).getPresentBit()));
            PN1_MB.setText(String.valueOf(process.getPageTable().getList_pages().get(1).getModifyBit()));
            PN1_LMT.setText(String.valueOf(process.getPageTable().getList_pages().get(1).getLastAccessTime()));
            PN1_FN.setText(getStringValue(process.getPageTable().getList_pages().get(1).getCorrespondingFrameNumber()));

            PN2_PB.setText(String.valueOf(process.getPageTable().getList_pages().get(2).getPresentBit()));
            PN2_MB.setText(String.valueOf(process.getPageTable().getList_pages().get(2).getModifyBit()));
            PN2_LMT.setText(String.valueOf(process.getPageTable().getList_pages().get(2).getLastAccessTime()));
            PN2_FN.setText(getStringValue(process.getPageTable().getList_pages().get(2).getCorrespondingFrameNumber()));

            PN3_PB.setText(String.valueOf(process.getPageTable().getList_pages().get(3).getPresentBit()));
            PN3_MB.setText(String.valueOf(process.getPageTable().getList_pages().get(3).getModifyBit()));
            PN3_LMT.setText(String.valueOf(process.getPageTable().getList_pages().get(3).getLastAccessTime()));
            PN3_FN.setText(getStringValue(process.getPageTable().getList_pages().get(3).getCorrespondingFrameNumber()));

            PN4_PB.setText(String.valueOf(process.getPageTable().getList_pages().get(4).getPresentBit()));
            PN4_MB.setText(String.valueOf(process.getPageTable().getList_pages().get(4).getModifyBit()));
            PN4_LMT.setText(String.valueOf(process.getPageTable().getList_pages().get(4).getLastAccessTime()));
            PN4_FN.setText(getStringValue(process.getPageTable().getList_pages().get(4).getCorrespondingFrameNumber()));

            PN5_PB.setText(String.valueOf(process.getPageTable().getList_pages().get(5).getPresentBit()));
            PN5_MB.setText(String.valueOf(process.getPageTable().getList_pages().get(5).getModifyBit()));
            PN5_LMT.setText(String.valueOf(process.getPageTable().getList_pages().get(5).getLastAccessTime()));
            PN5_FN.setText(getStringValue(process.getPageTable().getList_pages().get(5).getCorrespondingFrameNumber()));

            PN6_PB.setText(String.valueOf(process.getPageTable().getList_pages().get(6).getPresentBit()));
            PN6_MB.setText(String.valueOf(process.getPageTable().getList_pages().get(6).getModifyBit()));
            PN6_LMT.setText(String.valueOf(process.getPageTable().getList_pages().get(6).getLastAccessTime()));
            PN6_FN.setText(getStringValue(process.getPageTable().getList_pages().get(6).getCorrespondingFrameNumber()));

            PN7_PB.setText(String.valueOf(process.getPageTable().getList_pages().get(7).getPresentBit()));
            PN7_MB.setText(String.valueOf(process.getPageTable().getList_pages().get(7).getModifyBit()));
            PN7_LMT.setText(String.valueOf(process.getPageTable().getList_pages().get(7).getLastAccessTime()));
            PN7_FN.setText(getStringValue(process.getPageTable().getList_pages().get(7).getCorrespondingFrameNumber()));

            PN8_PB.setText(String.valueOf(process.getPageTable().getList_pages().get(8).getPresentBit()));
            PN8_MB.setText(String.valueOf(process.getPageTable().getList_pages().get(8).getModifyBit()));
            PN8_LMT.setText(String.valueOf(process.getPageTable().getList_pages().get(8).getLastAccessTime()));
            PN8_FN.setText(getStringValue(process.getPageTable().getList_pages().get(8).getCorrespondingFrameNumber()));

            PN9_PB.setText(String.valueOf(process.getPageTable().getList_pages().get(9).getPresentBit()));
            PN9_MB.setText(String.valueOf(process.getPageTable().getList_pages().get(9).getModifyBit()));
            PN9_LMT.setText(String.valueOf(process.getPageTable().getList_pages().get(9).getLastAccessTime()));
            PN9_FN.setText(getStringValue(process.getPageTable().getList_pages().get(9).getCorrespondingFrameNumber()));

            PN10_PB.setText(String.valueOf(process.getPageTable().getList_pages().get(10).getPresentBit()));
            PN10_MB.setText(String.valueOf(process.getPageTable().getList_pages().get(10).getModifyBit()));
            PN10_LMT.setText(String.valueOf(process.getPageTable().getList_pages().get(10).getLastAccessTime()));
            PN10_FN.setText(getStringValue(process.getPageTable().getList_pages().get(10).getCorrespondingFrameNumber()));

            PN11_PB.setText(String.valueOf(process.getPageTable().getList_pages().get(11).getPresentBit()));
            PN11_MB.setText(String.valueOf(process.getPageTable().getList_pages().get(11).getModifyBit()));
            PN11_LMT.setText(String.valueOf(process.getPageTable().getList_pages().get(11).getLastAccessTime()));
            PN11_FN.setText(getStringValue(process.getPageTable().getList_pages().get(11).getCorrespondingFrameNumber()));

            PN12_PB.setText(String.valueOf(process.getPageTable().getList_pages().get(12).getPresentBit()));
            PN12_MB.setText(String.valueOf(process.getPageTable().getList_pages().get(12).getModifyBit()));
            PN12_LMT.setText(String.valueOf(process.getPageTable().getList_pages().get(12).getLastAccessTime()));
            PN12_FN.setText(getStringValue(process.getPageTable().getList_pages().get(12).getCorrespondingFrameNumber()));

            PN13_PB.setText(String.valueOf(process.getPageTable().getList_pages().get(13).getPresentBit()));
            PN13_MB.setText(String.valueOf(process.getPageTable().getList_pages().get(13).getModifyBit()));
            PN13_LMT.setText(String.valueOf(process.getPageTable().getList_pages().get(13).getLastAccessTime()));
            PN13_FN.setText(getStringValue(process.getPageTable().getList_pages().get(13).getCorrespondingFrameNumber()));

            PN14_PB.setText(String.valueOf(process.getPageTable().getList_pages().get(14).getPresentBit()));
            PN14_MB.setText(String.valueOf(process.getPageTable().getList_pages().get(14).getModifyBit()));
            PN14_LMT.setText(String.valueOf(process.getPageTable().getList_pages().get(14).getLastAccessTime()));
            PN14_FN.setText(getStringValue(process.getPageTable().getList_pages().get(14).getCorrespondingFrameNumber()));

            PN15_PB.setText(String.valueOf(process.getPageTable().getList_pages().get(15).getPresentBit()));
            PN15_MB.setText(String.valueOf(process.getPageTable().getList_pages().get(15).getModifyBit()));
            PN15_LMT.setText(String.valueOf(process.getPageTable().getList_pages().get(15).getLastAccessTime()));
            PN15_FN.setText(getStringValue(process.getPageTable().getList_pages().get(15).getCorrespondingFrameNumber()));
        }
        else{
            CurrentProcessValue.setText("None");

            PN0_PB.setText(String.valueOf(0));
            PN0_MB.setText(String.valueOf(0));
            PN0_LMT.setText(String.valueOf(0));
            PN0_FN.setText(getStringValue(-1));

            PN1_PB.setText(String.valueOf(0));
            PN1_MB.setText(String.valueOf(0));
            PN1_LMT.setText(String.valueOf(0));
            PN1_FN.setText(getStringValue(-1));

            PN2_PB.setText(String.valueOf(0));
            PN2_MB.setText(String.valueOf(0));
            PN2_LMT.setText(String.valueOf(0));
            PN2_FN.setText(getStringValue(-1));

            PN3_PB.setText(String.valueOf(0));
            PN3_MB.setText(String.valueOf(0));
            PN3_LMT.setText(String.valueOf(0));
            PN3_FN.setText(getStringValue(-1));

            PN4_PB.setText(String.valueOf(0));
            PN4_MB.setText(String.valueOf(0));
            PN4_LMT.setText(String.valueOf(0));
            PN4_FN.setText(getStringValue(-1));

            PN5_PB.setText(String.valueOf(0));
            PN5_MB.setText(String.valueOf(0));
            PN5_LMT.setText(String.valueOf(0));
            PN5_FN.setText(getStringValue(-1));

            PN6_PB.setText(String.valueOf(0));
            PN6_MB.setText(String.valueOf(0));
            PN6_LMT.setText(String.valueOf(0));
            PN6_FN.setText(getStringValue(-1));

            PN7_PB.setText(String.valueOf(0));
            PN7_MB.setText(String.valueOf(0));
            PN7_LMT.setText(String.valueOf(0));
            PN7_FN.setText(getStringValue(-1));

            PN8_PB.setText(String.valueOf(0));
            PN8_MB.setText(String.valueOf(0));
            PN8_LMT.setText(String.valueOf(0));
            PN8_FN.setText(getStringValue(-1));

            PN9_PB.setText(String.valueOf(0));
            PN9_MB.setText(String.valueOf(0));
            PN9_LMT.setText(String.valueOf(0));
            PN9_FN.setText(getStringValue(-1));

            PN10_PB.setText(String.valueOf(0));
            PN10_MB.setText(String.valueOf(0));
            PN10_LMT.setText(String.valueOf(0));
            PN10_FN.setText(getStringValue(-1));

            PN11_PB.setText(String.valueOf(0));
            PN11_MB.setText(String.valueOf(0));
            PN11_LMT.setText(String.valueOf(0));
            PN11_FN.setText(getStringValue(-1));

            PN12_PB.setText(String.valueOf(0));
            PN12_MB.setText(String.valueOf(0));
            PN12_LMT.setText(String.valueOf(0));
            PN12_FN.setText(getStringValue(-1));

            PN13_PB.setText(String.valueOf(0));
            PN13_MB.setText(String.valueOf(0));
            PN13_LMT.setText(String.valueOf(0));
            PN13_FN.setText(getStringValue(-1));

            PN14_PB.setText(String.valueOf(0));
            PN14_MB.setText(String.valueOf(0));
            PN14_LMT.setText(String.valueOf(0));
            PN14_FN.setText(getStringValue(-1));

            PN15_PB.setText(String.valueOf(0));
            PN15_MB.setText(String.valueOf(0));
            PN15_LMT.setText(String.valueOf(0));
            PN15_FN.setText(getStringValue(-1));
        }
    }
    private void changeGUIRAM() {
        for(int i=0; i<numberOfFrames; i++){
            setFrameInGUIRAM(ram.getList_frames().get(i));
        }
    }
    private void setFrameInGUIRAM(Frame f) {
        switch (f.getFramenummer()){
            case 0: {
                FN0_PID.setText(getStringValue(f.getPid()));
                FN0_PN.setText(getStringValue(f.getPagenummer()));
            }
            case 1: {
                FN1_PID.setText(getStringValue(f.getPid()));
                FN1_PN.setText(getStringValue(f.getPagenummer()));
            }
            case 2: {
                FN2_PID.setText(getStringValue(f.getPid()));
                FN2_PN.setText(getStringValue(f.getPagenummer()));
            }
            case 3: {
                FN3_PID.setText(getStringValue(f.getPid()));
                FN3_PN.setText(getStringValue(f.getPagenummer()));
            }
            case 4: {
                FN4_PID.setText(getStringValue(f.getPid()));
                FN4_PN.setText(getStringValue(f.getPagenummer()));
            }
            case 5: {
                FN5_PID.setText(getStringValue(f.getPid()));
                FN5_PN.setText(getStringValue(f.getPagenummer()));
            }
            case 6: {
                FN6_PID.setText(getStringValue(f.getPid()));
                FN6_PN.setText(getStringValue(f.getPagenummer()));
            }
            case 7: {
                FN7_PID.setText(getStringValue(f.getPid()));
                FN7_PN.setText(getStringValue(f.getPagenummer()));
            }
            case 8: {
                FN8_PID.setText(getStringValue(f.getPid()));
                FN8_PN.setText(getStringValue(f.getPagenummer()));
            }case 9: {
                FN9_PID.setText(getStringValue(f.getPid()));
                FN9_PN.setText(getStringValue(f.getPagenummer()));
            }case 10: {
                FN10_PID.setText(getStringValue(f.getPid()));
                FN10_PN.setText(getStringValue(f.getPagenummer()));
            }
            case 11: {
                FN11_PID.setText(getStringValue(f.getPid()));
                FN11_PN.setText(getStringValue(f.getPagenummer()));
            }
            default: break;
        }
    }

    private String getStringValue(int value) {
        if (value == -1){
            return "Null";
        }
        else
            return String.valueOf(value);
    }


    public App() {
        executeOneProcessButton.addActionListener(e -> {
            if (!instructions.isEmpty()){
                CurrentTimerLabel.setText("Current time:");
                executeOneInstruction();
            }
            else {
                CurrentTimerLabel.setText("Finished time:");
                restart();
            }
        });
        executeAllProcessesButton.addActionListener(e -> {
            while (!instructions.isEmpty()) {
                executeOneInstruction();
            }
            CurrentTimerLabel.setText("Finished time:");
            restart();
        });
    }

    private void restart() {
        System.out.println("All instructions are executed!");
        initialiseren();
        readingWholeXMLFile();
    }
}
