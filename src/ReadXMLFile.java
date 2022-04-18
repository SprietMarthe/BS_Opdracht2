package src;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.Objects;

public class ReadXMLFile {
    public static void readingXMLFile(int welkXMLFile){
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
                        Main.process_list.add(process);
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