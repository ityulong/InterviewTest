package xaircraft.interviewtest.ContactImplement.model;

/**
 * Created by chenyulong on 2017/9/6.
 */

public class Contact {
    private  String name;
    private  String sortKey;

    public Contact() {
    }

    public Contact(String name, String sortKey) {
        this.name = name;
        this.sortKey = sortKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSortKey() {
        return sortKey;
    }

    public void setSortKey(String sortKey) {
        this.sortKey = sortKey;
    }
}
