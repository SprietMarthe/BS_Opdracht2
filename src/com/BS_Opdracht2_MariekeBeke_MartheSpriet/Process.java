package src.com.BS_Opdracht2_MariekeBeke_MartheSpriet;

public class Process {
    private int processID;
    private PageTable pageTable;
    private int numberOfWrites;


    public Process() {
    }



    public Process(int processID, PageTable pageTable, int numberOfWrites) {
        this.processID = processID;
        this.pageTable = pageTable;
        this.numberOfWrites = numberOfWrites;
    }




    @Override
    public String toString() {
        return "Process{" +
                "PID=" + processID +
                '}';
    }
    public int getProcessID() {
        return processID;
    }
    public void setProcessID(int processID) {
        this.processID = processID;
    }
    public PageTable getPageTable() {
        return pageTable;
    }
    public void setPageTable(PageTable pageTable) {
        this.pageTable = pageTable;
    }
    public int getNumberOfWrites() {
        return numberOfWrites;
    }
    public void setNumberOfWrites(int numberOfWrites) {
        this.numberOfWrites = numberOfWrites;
    }
}
