package tree;
public class BinaryTree {

    private int size;
    private Node root;

    public BinaryTree() {
        this.size = 0;
        this.root = null;
    }

    public int size() {
        return size;
    }

    public void insert(int item) {
        root = insertRec(root, item); // always return root.
    }

    // new method to achieve recursion and create tree data structure
    private Node insertRec(Node node, int data) {
        if (node == null) {
            size++; // Increment size when a new node is added
            return new Node(data);
        }
        if (data < node.data) {
            node.left = insertRec(node.left, data);
        } else if (data > node.data) {
            node.right = insertRec(node.right, data);
        }
        return node; // Return the unchanged node pointer
    }

    public void inOrder() {
        inOrderRec(root);
    }

    private void inOrderRec(Node node) {
        if (node != null) {
            inOrderRec(node.left);   // Visit left subtree
            System.out.println(node.data); // Visit data
            inOrderRec(node.right);  // Visit right subtree
        }
    }

    public void preOrder() {
        preOrderRec(root);
    }

    private void preOrderRec(Node node) {
        if (node != null) {
            System.out.println(node.data); // Visit data
            preOrderRec(node.left);   // Visit left subtree
            preOrderRec(node.right);  // Visit right subtree
        }
    }

    public void postOrder() {
        postOrderRec(root);
    }

    private void postOrderRec(Node node) {
        if (node != null) {
            postOrderRec(node.left);   // Visit left subtree
            postOrderRec(node.right);  // Visit right subtree
            System.out.println(node.data); // Visit data
        }
    }

    public boolean search(int item) {
        return searchRec(root, item);
    }

    private boolean searchRec(Node node, int data) {
        if (node == null) {
            return false; // Base case: not found
        }
        if (data == node.data) {
            return true; // Found the item
        }
        if (data < node.data) {
            return searchRec(node.left, data); // Search in left subtree
        } else {
            return searchRec(node.right, data); // Search in right subtree
        }
    }

    public void delete(int item) {
        root = deleteRec(root, item);
    }

    private Node deleteRec(Node node, int data) {
        if (node == null) {
            return null; // Base case: not found
        }

        // Recur down the tree
        if (data < node.data) {
            node.left = deleteRec(node.left, data); // Search in left subtree
        } else if (data > node.data) {
            node.right = deleteRec(node.right, data); // Search in right subtree
        } else {
            // Node with only one child or no child
            if (node.left == null) {
                return node.right; // Node with one child (right)
            } else if (node.right == null) {
                return node.left; // Node with one child (left)
            }

            // Node with two children: Get the inorder successor (smallest in the right subtree)
            node.data = minValue(node.right); // Replace with its inorder successor

            // Delete the inorder successor
            node.right = deleteRec(node.right, node.data);
        }
        return node; // Return the unchanged node pointer
    }

    private int minValue(Node node) {
        int minv = node.data;
        while (node.left != null) {
            minv = node.left.data;
            node = node.left;
        }
        return minv;
    }



    private static class Node {
        Node left;
        Node right;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }
}
