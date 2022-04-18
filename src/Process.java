package src;

public class Process {
    private int processID;
    private OperationProcess operation;
    private int address;
    private PageTable pageTable;

    public Process(int processID, String operation, int address) {
        this.processID = processID;
        this.operation = OperationProcess.valueOf(operation);
        this.address = address;
    }

    public Process(int processID, OperationProcess operation, int address, PageTable pageTable) {
        this.processID = processID;
        this.operation = operation;
        this.address = address;
        this.pageTable = pageTable;
    }

    @Override
    public String toString() {
        return "Process{" +
                "processID=" + processID +
                ", operation=" + operation +
                ", address=" + address +
                ", pageTable=" + pageTable +
                '}';
    }
}
