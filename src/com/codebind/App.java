package src.com.codebind;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

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

    private static int welkeXMLFile=1;
    private static List<Process> process_list;
    private static int timer;

    public static void main(String[] argv) {
        Scanner sc = new Scanner(System.in);

        initialiseren();

        displayJFrame();

        System.out.println(process_list);

        sc.close();
    }

    private static void initialiseren() {
        process_list = new ArrayList<>();
    }

    private static void displayJFrame() {
        JFrame frame= new JFrame("App");
        frame.setContentPane(new App().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(new Dimension(1200, 700));
    }

    public enum OperationProcess {
        Start,
        Write,
        Read,
        Terminate
    }

    public static class PageTable {
        private final int presentbit;
        private final int modifybit;
        private final int lastAccesTime;
        private final int correspondingframeNumber;       //[0,11]


        public PageTable(int presentbit, int modifybit, int lastAccesTime, int correspondingframeNumber) {
            this.presentbit = presentbit;
            this.modifybit = modifybit;
            this.lastAccesTime = lastAccesTime;
            this.correspondingframeNumber = correspondingframeNumber;
        }

        @Override
        public String toString() {
            return "PageTable{" +
                    "presentbit=" + presentbit +
                    ", modifybit=" + modifybit +
                    ", lastAccesTime=" + lastAccesTime +
                    ", correspondingframeNumber=" + correspondingframeNumber +
                    '}';
        }
    }

    public static class Process {
        private final int processID;
        private final OperationProcess operation;
        private final int address;
        private PageTable pageTable;

        public Process(int processID, String operation, int address) {
            this.processID = processID;
            this.operation = OperationProcess.valueOf(operation);
            this.address = address;
        }

        @Override
        public String toString() {
            return "Process{" +
                    "processID=" + processID +
                    ", operation=" + operation +
                    ", address=" + address +
                    ", pageTable=" + pageTable +
                    '}' + "\n";
        }
    }

    public static class ReadXMLFile {
        public static void readingWholeXMLFile(int welkXMLFile){
            int p = 0;
            File file = null;
            try {
                switch (welkXMLFile) {
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
                        p++;
                        String operation = eElement.getElementsByTagName("operation").item(0).getTextContent();
                        if (Objects.equals(operation, "Start")){
                            Process process = new Process(
                                    Integer.parseInt(eElement.getElementsByTagName("processID").item(0).getTextContent()),
                                    operation,
                                    Integer.parseInt(eElement.getElementsByTagName("address").item(0).getTextContent())
                            );
                            process_list.add(process);
                            System.out.println(process);
                        }
                        else {
                            System.out.println(operation);
                        }
                    }
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    public App() {
        oneProcess.addActionListener(e -> {
            //JOptionPane.showMessageDialog(null, "Hello world");
            TimerValue.setText(String.valueOf(timer));
            TimerValue.setVisible(true);
        });
        allProcesses.addActionListener(e -> {
            ReadXMLFile.readingWholeXMLFile(welkeXMLFile);
            System.out.println(process_list);
        });
    }
}
