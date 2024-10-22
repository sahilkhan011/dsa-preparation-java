package tree;

public class BinaryTree<E extends Comparable<E>> {

    private int size;
    private Node<E> root;

    public BinaryTree() {
        this.size = 0;
        this.root = null;
    }

    public int size() {
        return size;
    }

    public void insert(E item) {
        root = insertRec(root, item); // always return root.
    }

    // new method to achieve recursion and create tree data structure
    private Node<E> insertRec(Node<E> node, E data) {
        if (node == null) {
            size++; // Increment size when a new node is added
            return new Node<>(data);
        }
        if (data.compareTo(node.data) < 0) {
            node.left = insertRec(node.left, data);
        } else if (data.compareTo(node.data) > 0) {
            node.right = insertRec(node.right, data);
        }
        return node; // Return the unchanged node pointer
    }

    public void inorder() {
        inorderRec(root);
    }

    private void inorderRec(Node<E> node) {
        if (node != null) {
            inorderRec(node.left);   // Visit left subtree
            System.out.println(node.data); // Visit data
            inorderRec(node.right);  // Visit right subtree
        }
    }


    private static class Node<E> {
        Node<E> left;
        Node<E> right;
        E data;

        public Node(E data) {
            this.data = data;
        }
    }
}
