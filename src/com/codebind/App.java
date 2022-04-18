package src.com.codebind;

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
    static List<Process> proces_lijst;
    static int timer;
    static Queue<Instruction> instructions;

    public static void main(String[] argv) {
        Scanner sc = new Scanner(System.in);

        initialiseren();
        readingWholeXMLFile();
        displayJFrame();

        //System.out.println(instructions);

        sc.close();
    }






    private static void initialiseren() {
        proces_lijst = new ArrayList<>();
        timer = 0;
        instructions = new Queue<Instruction>() {
            @Override
            public boolean add(Instruction instruction) {
                return false;
            }
            @Override
            public boolean offer(Instruction instruction) {
                return false;
            }

            @Override
            public Instruction remove() {
                return null;
            }

            @Override
            public Instruction poll() {
                return null;
            }

            @Override
            public Instruction element() {
                return null;
            }

            @Override
            public Instruction peek() {
                return null;
            }

            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Instruction> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Instruction> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }
        };
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
                    System.out.println(instruction);
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }



    public App() {
        oneProcess.addActionListener(e -> {
            //JOptionPane.showMessageDialog(null, "Hello world");
            TimerValue.setText(String.valueOf(timer));              // voorbeeld
            TimerValue.setVisible(true);
        });
        allProcesses.addActionListener(e -> {
            System.out.println(proces_lijst);
        });
    }
}
