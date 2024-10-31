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

    public void inOrder() {
        inOrderRec(root);
    }

    private void inOrderRec(Node<E> node) {
        if (node != null) {
            inOrderRec(node.left);   // Visit left subtree
            System.out.println(node.data); // Visit data
            inOrderRec(node.right);  // Visit right subtree
        }
    }

    public void preOrder() {
        preOrderRec(root);
    }

    private void preOrderRec(Node<E> node) {
        if (node != null) {
            System.out.println(node.data); // Visit data
            preOrderRec(node.left);   // Visit left subtree
            preOrderRec(node.right);  // Visit right subtree
        }
    }

    public void postOrder() {
        postOrderRec(root);
    }

    private void postOrderRec(Node<E> node) {
        if (node != null) {
            postOrderRec(node.left);   // Visit left subtree
            postOrderRec(node.right);  // Visit right subtree
            System.out.println(node.data); // Visit data
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