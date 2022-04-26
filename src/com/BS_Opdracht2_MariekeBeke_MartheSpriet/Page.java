package src.com.BS_Opdracht2_MariekeBeke_MartheSpriet;

public class Page {
    private int pageNumber;
    private int presentBit;
    private int modifyBit;
    private int lastAccessTime;
    private int correspondingFrameNumber;        //[0,11]

    public Page(int timer, int i) {
        this.pageNumber = i;
        this.presentBit = 0;
        this.modifyBit = 0;
        this.lastAccessTime = timer;
        this.correspondingFrameNumber = -1;
    }

    public Page(int pageNumber, int presentBit, int modifyBit, int lastAccessTime, int correspondingFrameNumber) {
        this.pageNumber = pageNumber;
        this.presentBit = presentBit;
        this.modifyBit = modifyBit;
        this.lastAccessTime = lastAccessTime;
        this.correspondingFrameNumber = correspondingFrameNumber;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNumber=" + pageNumber +
                ", presentBit=" + presentBit +
                ", modifyBit=" + modifyBit +
                ", lastAccessTime=" + lastAccessTime +
                ", correspondingFrameNumber=" + correspondingFrameNumber +
                "\n" +
                '}';
    }

    public int getPageNumber() {
        return pageNumber;
    }
    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }
    public int getPresentBit() {
        return presentBit;
    }
    public void setPresentBit(int presentBit) {
        this.presentBit = presentBit;
    }
    public int getModifyBit() {
        return modifyBit;
    }
    public void setModifyBit(int modifyBit) {
        this.modifyBit = modifyBit;
    }
    public int getLastAccessTime() {
        return lastAccessTime;
    }
    public void setLastAccessTime(int lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }
    public int getCorrespondingFrameNumber() {
        return correspondingFrameNumber;
    }
    public void setCorrespondingFrameNumber(int correspondingFrameNumber) {
        this.correspondingFrameNumber = correspondingFrameNumber;
    }
}
