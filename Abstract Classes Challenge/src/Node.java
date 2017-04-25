/**
 * Created by Sloan on 4/20/2017.
 */
public class Node extends ListItem {

    public Node(Object value) {
        super(value);
    }

    @Override
    public ListItem setNext(ListItem listItem) {
        this.next = listItem;
        return this.next;
    }

    @Override
    public ListItem next() {
        return this.next;
    }

    @Override
    public ListItem setPrevious(ListItem listItem) {
        this.previous = listItem;
        return this.previous;
    }

    @Override
    public ListItem previous() {
        return this.previous;
    }

    @Override
    public int compareTo(ListItem listItem) {
        if(listItem != null) {
            return ((String) super.getValue()).compareTo((String) listItem.getValue());
        } else {
            return -1;
        }
    }

}
