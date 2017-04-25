import java.util.List;

/**
 * Created by Sloan on 4/20/2017.
 */
public class LinkedList implements NodeList {

    private ListItem root = null;

    public LinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem listItem) {
        if(this.root == null) {
            //the list was empty so the list item becomes the head
            this.root = listItem;
            return true;
        }

        ListItem currentItem = this.root;
        while(currentItem != null) {
            int comparison = currentItem.compareTo(listItem);
            if(comparison < 0) {
                //new item is greater move right if possible
                if(currentItem.next() != null) {
                    currentItem = currentItem.next();
                } else {
                    // there is no next so insert at end of the list
                    currentItem.setNext(listItem);
                    return true;
                }
            } else if(comparison > 0) {
                //new item is less, insert before
                if(currentItem.previous != null) {
                    currentItem.previous().setNext(currentItem.previous());
                    listItem.setPrevious(currentItem.previous());
                    listItem.setNext(currentItem);
                    currentItem.setPrevious(listItem);
                } else {
                    //the node with a previous is the root
                    listItem.setNext(this.root);
                    this.root.setPrevious(listItem);
                    this.root = listItem;
                }
            } else {
                System.out.println(listItem.getValue() + " is already present, not added.");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem listItem) {
        return false;
    }

    @Override
    public void traverse(ListItem root) {

    }
}
