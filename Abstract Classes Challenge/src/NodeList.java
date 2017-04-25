
/**
 * Created by Sloan on 4/20/2017.
 */
public interface NodeList {
    ListItem getRoot();
    boolean addItem(ListItem listItem);
    boolean removeItem(ListItem listItem);
    void traverse(ListItem root);
}
