package src.com.BS_Opdracht2_MariekeBeke_MartheSpriet;

public class Instruction {
    private static int processID;
    private static OperationProcess operation;
    private static int address;

    public Instruction(int processID, String operation, int address) {
        Instruction.processID = processID;
        Instruction.operation = OperationProcess.valueOf(operation);
        Instruction.address = address;
    }




    @Override
    public String toString() {
        return "Instruction{" +
                "processID=" + processID +
                ", operation=" + operation +
                ", address=" + address +
                '}' + "\n";
    }
    public static int getProcessID() {
        return processID;
    }
    public static void setProcessID(int processID) {
        Instruction.processID = processID;
    }
    public static OperationProcess getOperation() {
        return operation;
    }
    public static void setOperation(OperationProcess operation) {
        Instruction.operation = operation;
    }
    public static int getAddress() {
        return address;
    }
    public static void setAddress(int address) {
        Instruction.address = address;
    }
}
