package src.com.BS_Opdracht2_MariekeBeke_MartheSpriet;

public class Process {
    private int processID;
    private PageTable pageTable;

    public Process(int processID, PageTable pageTable) {
        this.processID = processID;
        this.pageTable = pageTable;
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
}
