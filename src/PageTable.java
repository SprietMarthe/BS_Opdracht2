package src;

public class PageTable {
    private int presentbit;
    private int modifybit;
    private int lastAccesTime;
    private int correspondingframeNumber;       //[0,11]


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
