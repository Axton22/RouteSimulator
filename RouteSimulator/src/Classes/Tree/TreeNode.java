package Classes.Tree;

/**
 * Represents a node within a general (n-ary) tree structure.
 * <p>
 * This implementation follows the First-Child / Next-Sibling representation,
 * which allows each node to have an arbitrary number of children while
 * maintaining a simple linked structure.
 *
 * Each node contains:
 * <ul>
 *     <li>Data stored as a generic {@code Object}</li>
 *     <li>A reference to its first child</li>
 *     <li>A reference to its next sibling</li>
 * </ul>
 *
 * This class is used as the fundamental building block of the
 * organizational hierarchy within the campus management simulation system.
 */
public class TreeNode {

    /**
     * The data stored in this node.
     */
    private Object data;

    /**
     * Reference to the first child of this node.
     */
    private TreeNode firstChild;

    /**
     * Reference to the next sibling of this node.
     */
    private TreeNode nextSibling;

    /**
     * Constructs a TreeNode with the specified data.
     * Child and sibling references are initialized to {@code null}.
     *
     * @param data the data to be stored in this node
     */
    public TreeNode(Object data) {
        this.data = data;
        this.firstChild = null;
        this.nextSibling = null;
    }

    /**
     * Returns the data stored in this node.
     *
     * @return the node's data
     */
    public Object getData() {
        return data;
    }

    /**
     * Returns the first child of this node.
     *
     * @return the first child node, or {@code null} if none exists
     */
    public TreeNode getFirstChild() {
        return firstChild;
    }

    /**
     * Returns the next sibling of this node.
     *
     * @return the next sibling node, or {@code null} if none exists
     */
    public TreeNode getNextSibling() {
        return nextSibling;
    }

    /**
     * Sets the first child of this node.
     *
     * @param firstChild the node to be assigned as the first child
     */
    public void setFirstChild(TreeNode firstChild) {
        this.firstChild = firstChild;
    }

    /**
     * Sets the next sibling of this node.
     *
     * @param nextSibling the node to be assigned as the next sibling
     */
    public void setNextSibling(TreeNode nextSibling) {
        this.nextSibling = nextSibling;
    }
}
