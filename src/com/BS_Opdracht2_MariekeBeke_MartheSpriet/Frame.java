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
    public Frame(int pid, int pagenummer, int framenummer) {
        this.pid = pid;
        this.pagenummer = pagenummer;
        this.framenummer = framenummer;
    }




    @Override
    public String toString() {
        return "Frame{" +
                "framenummer=" + framenummer +
                ", pid=" + pid +
                ", pagenummer=" + pagenummer +
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
