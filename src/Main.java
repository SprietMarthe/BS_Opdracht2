package src;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Process> process_list;

    public static void main(String[] argv) {
        Scanner sc = new Scanner(System.in);

        ReadXMLFile.readingXMLFile(1);

        System.out.println(process_list);

        sc.close();
    }

}
