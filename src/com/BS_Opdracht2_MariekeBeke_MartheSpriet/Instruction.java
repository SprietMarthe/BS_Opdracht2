package src.com.BS_Opdracht2_MariekeBeke_MartheSpriet;

public class Instruction {
    private int processID;
    private OperationProcess operation;
    private int address;

    public Instruction(int processID, String operation, int address) {
        this.processID = processID;
        this.operation = OperationProcess.valueOf(operation);
        this.address = address;
    }

    @Override
    public String toString() {
        return "Instruction{" +
                "processID=" + processID +
                ", operation=" + operation +
                ", address=" + address +
                '}' + "\n";
    }
    public int getProcessID() {
        return processID;
    }
    public void setProcessID(int processID) {
        this.processID = processID;
    }
    public OperationProcess getOperation() {
        return operation;
    }
    public void setOperation(OperationProcess operation) {
        this.operation = operation;
    }
    public int getAddress() {
        return address;
    }
    public void setAddress(int address) {
        this.address = address;
    }
}
