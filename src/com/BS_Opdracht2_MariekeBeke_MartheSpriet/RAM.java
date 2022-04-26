package src.com.BS_Opdracht2_MariekeBeke_MartheSpriet;

import java.util.ArrayList;
import java.util.List;

public class RAM {
    private List<Frame> list_frames;

    public RAM(int numberOfFrames) {
        this.list_frames = new ArrayList<>();
        for (int i = 0; i<numberOfFrames; i++){
            list_frames.add(new Frame(i));
        }
    }

    public RAM(List<Frame> list_frames) {
        this.list_frames = list_frames;
    }

    @Override
    public String toString() {
        return "RAM{" +
                "list_frames=" + list_frames +
                '}';
    }
    public List<Frame> getList_frames() {
        return list_frames;
    }
    public void setList_frames(List<Frame> list_frames) {
        this.list_frames = list_frames;
    }
}
