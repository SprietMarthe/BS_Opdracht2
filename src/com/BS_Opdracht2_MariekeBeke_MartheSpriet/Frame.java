package src.com.BS_Opdracht2_MariekeBeke_MartheSpriet;

public class Frame {
    private int framenummer;
    private int pid;
    private int pagenummer;




    public Frame(int i) {
        this.pid = -1;
        this.pagenummer = -1;
        this.framenummer = i;
    }
    public Frame() {
    }


    @Override
    public String toString() {
        return "Frame{" +
                "framenummer=" + framenummer +
                '}';
    }
    public int getPid() {
        return pid;
    }
    public void setPid(int pid) {
        this.pid = pid;
    }
    public int getPagenummer() {
        return pagenummer;
    }
    public void setPagenummer(int pagenummer) {
        this.pagenummer = pagenummer;
    }
    public int getFramenummer() {
        return framenummer;
    }
    public void setFramenummer(int framenummer) {
        this.framenummer = framenummer;
    }
}
