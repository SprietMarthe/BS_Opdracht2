package src.com.codebind;

public class PageTable {
    private static int presentbit;
    private static int modifybit;
    private static int lastAccesTime;
    private static int correspondingframeNumber;       //[0,11]



    public PageTable(int presentbit, int modifybit, int lastAccesTime, int correspondingframeNumber) {
        PageTable.presentbit = presentbit;
        PageTable.modifybit = modifybit;
        PageTable.lastAccesTime = lastAccesTime;
        PageTable.correspondingframeNumber = correspondingframeNumber;
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
    public static int getPresentbit() {
        return presentbit;
    }
    public static void setPresentbit(int presentbit) {
        PageTable.presentbit = presentbit;
    }
    public static int getModifybit() {
        return modifybit;
    }
    public static void setModifybit(int modifybit) {
        PageTable.modifybit = modifybit;
    }
    public static int getLastAccesTime() {
        return lastAccesTime;
    }
    public static void setLastAccesTime(int lastAccesTime) {
        PageTable.lastAccesTime = lastAccesTime;
    }
    public static int getCorrespondingframeNumber() {
        return correspondingframeNumber;
    }
    public static void setCorrespondingframeNumber(int correspondingframeNumber) {
        PageTable.correspondingframeNumber = correspondingframeNumber;
    }
}
