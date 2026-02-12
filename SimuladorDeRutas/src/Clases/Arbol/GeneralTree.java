package Clases.Arbol;

/**
 * Represents a General Tree (n-ary tree) used to model the operational
 * organizational structure of the university campus system.
 * <p>
 * This tree structure allows representing hierarchies such as:
 * <ul>
 *     <li>Operations Center (root node)</li>
 *     <li>Brigades (intermediate nodes)</li>
 *     <li>Operational teams or assigned resources (leaf nodes)</li>
 * </ul>
 *
 * The implementation follows the First-Child / Next-Sibling representation,
 * which allows each node to have an arbitrary number of children.
 *
 * Supported operations include:
 * <ul>
 *     <li>Node insertion</li>
 *     <li>Search by data</li>
 *     <li>Level-order traversal (BFS)</li>
 *     <li>Reassignment of nodes within the hierarchy</li>
 * </ul>
 *
 * Part of the project: Dynamic Simulation System for Campus Management and Routing.
 */
public class GeneralTree {

    /**
     * Root node of the tree.
     * Represents the highest level in the organizational hierarchy.
     */
    private TreeNode root;

    /**
     * Constructs a GeneralTree with the specified root data.
     *
     * @param rootData the data to be stored in the root node
     */
    public GeneralTree(Object rootData) {
        this.root = new TreeNode(rootData);
    }

    /**
     * Returns the root node of the tree.
     *
     * @return the root {@link TreeNode}
     */
    public TreeNode getRoot() {
        return root;
    }

    /**
     * Adds a new child node to the specified parent node.
     * <p>
     * If the parent has no children, the new node becomes its first child.
     * Otherwise, the new node is appended at the end of the sibling list.
     *
     * @param parent the parent node to which the child will be added
     * @param childData the data to be stored in the new child node
     */
    public void addChild(TreeNode parent, Object childData) {
        if (parent == null) {
            return;
        }

        TreeNode newChild = new TreeNode(childData);

        if (parent.getFirstChild() == null) {
            parent.setFirstChild(newChild);
        } else {
            TreeNode current = parent.getFirstChild();
            while (current.getNextSibling() != null) {
                current = current.getNextSibling();
            }
            current.setNextSibling(newChild);
        }
    }

    /**
     * Searches for a node containing the specified data,
     * starting from the root of the tree.
     *
     * @param data the data to search for
     * @return the {@link TreeNode} containing the specified data,
     *         or {@code null} if it is not found
     */
    public TreeNode search(Object data) {
        return searchRecursive(root, data);
    }

    /**
     * Recursive helper method that performs a depth-first search (DFS)
     * within the tree.
     *
     * @param current the current node being evaluated
     * @param data the data to search for
     * @return the node containing the specified data, or {@code null} if not found
     */
    private TreeNode searchRecursive(TreeNode current, Object data) {

        if (current == null) {
            return null;
        }

        if (current.getData().equals(data)) {
            return current;
        }

        TreeNode child = current.getFirstChild();
        while (child != null) {
            TreeNode found = searchRecursive(child, data);
            if (found != null) {
                return found;
            }
            child = child.getNextSibling();
        }

        return null;
    }

    /**
     * Performs a level-order traversal (Breadth-First Search).
     * <p>
     * Uses an internal array-based queue implementation,
     * without relying on external data structure libraries.
     * Prints each visited node's data to the console.
     */
    public void traverseByLevelsBFS() {

        if (root == null) {
            return;
        }

        TreeNode[] queue = new TreeNode[100];
        int front = 0;
        int rear = 0;

        queue[rear++] = root;

        while (front < rear) {

            TreeNode current = queue[front++];
            System.out.println(current.getData());

            TreeNode child = current.getFirstChild();
            while (child != null) {
                queue[rear++] = child;
                child = child.getNextSibling();
            }
        }
    }

    /**
     * Reassigns an existing node to a new parent within the tree.
     * <p>
     * The root node cannot be reassigned.
     * If either the target node or the new parent does not exist,
     * the operation is not executed.
     *
     * @param nodeData the data of the node to be reassigned
     * @param newParentData the data of the new parent node
     */
    public void reassignNode(Object nodeData, Object newParentData) {

        TreeNode node = search(nodeData);
        TreeNode newParent = search(newParentData);

        if (node == null || newParent == null || node == root) {
            return;
        }

        removeNode(root, node);
        addChild(newParent, node.getData());
    }

    /**
     * Helper method that removes a node from its current parent
     * by disconnecting it from the sibling chain.
     *
     * @param parent the parent node from which the search begins
     * @param target the node to be removed
     */
    private void removeNode(TreeNode parent, TreeNode target) {

        if (parent == null) {
            return;
        }

        TreeNode child = parent.getFirstChild();
        TreeNode previous = null;

        while (child != null) {

            if (child == target) {

                if (previous == null) {
                    parent.setFirstChild(child.getNextSibling());
                } else {
                    previous.setNextSibling(child.getNextSibling());
                }
                return;
            }

            removeNode(child, target);

            previous = child;
            child = child.getNextSibling();
        }
    }
}
