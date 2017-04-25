import java.util.List;

/**
 * Created by Sloan on 4/20/2017.
 */
public abstract class ListItem {

    protected ListItem next = null;
    protected ListItem previous = null;
    protected Object value;

    public ListItem(Object value) {
        this.value = value;
    }

//    public void setNext() {
//        this.value = next.value;
//        this.next = next.next;
//        this.previous = this;
//    }
//
//    public void setPrevious() {
//        this.value = previous.value;
//        this.previous = previous.previous;
//        this.next = this;
//    }

    public abstract ListItem setNext(ListItem listItem);
    public abstract ListItem next();
    public abstract ListItem setPrevious(ListItem listItem);
    public abstract ListItem previous();
    public abstract int compareTo(ListItem listItem);

    public ListItem getNext() {
        return next;
    }

    public ListItem getPrevious() {
        return previous;
    }

    public Object getValue() {
        return value;
    }
}
