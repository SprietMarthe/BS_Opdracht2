package src.com.BS_Opdracht2_MariekeBeke_MartheSpriet;

import java.util.ArrayList;
import java.util.List;

public class PageTable {
    private List<Page> list_pages;      //[0,16]




    public PageTable(List<Page> list_pages) {
        this.list_pages = list_pages;
    }
    public PageTable(int timer, int numberOfPages) {
        list_pages = new ArrayList<>();
        for (int i = 0; i<numberOfPages; i++){
            list_pages.add(new Page(timer, i));
        }
    }



    @Override
    public String toString() {
        return "PageTable{" +
                "list_pages=" + list_pages +
                '}';
    }
    public List<Page> getList_pages() {
        return list_pages;
    }
    public void setList_pages(List<Page> list_pages) {
        this.list_pages = list_pages;
    }
}
