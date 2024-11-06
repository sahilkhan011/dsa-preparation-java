package tree;

public class BinaryTreeTest {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        // Test insertions
        System.out.println("Inserting values:");
        binaryTree.insert(50);
        binaryTree.insert(30);
        binaryTree.insert(70);
        binaryTree.insert(20);
        binaryTree.insert(40);
        binaryTree.insert(60);
        binaryTree.insert(80);

        // Display size of the tree
        System.out.println("Size of the tree: " + binaryTree.size());

        // Test in-order traversal
        System.out.println("In-order traversal:");
        binaryTree.inOrder(); // Should display: 20, 30, 40, 50, 60, 70, 80

        // Test pre-order traversal
        System.out.println("Pre-order traversal:");
        binaryTree.preOrder(); // Should display: 50, 30, 20, 40, 70, 60, 80

        // Test post-order traversal
        System.out.println("Post-order traversal:");
        binaryTree.postOrder(); // Should display: 20, 40, 30, 60, 80, 70, 50

        // Test searching for existing and non-existing values
        System.out.println("Searching for values:");
        System.out.println("Search 40: " + binaryTree.search(40)); // Should return true
        System.out.println("Search 100: " + binaryTree.search(100)); // Should return false

        // Test deletion of a leaf node
        System.out.println("Deleting leaf node 20:");
        binaryTree.delete(20);
        binaryTree.inOrder(); // Should display: 30, 40, 50, 60, 70, 80

        // Test deletion of a node with one child
        System.out.println("Deleting node with one child 30:");
        binaryTree.delete(30);
        binaryTree.inOrder(); // Should display: 40, 50, 60, 70, 80

        // Test deletion of a node with two children
        System.out.println("Deleting node with two children 50:");
        binaryTree.delete(50);
        binaryTree.inOrder(); // Should display: 40, 60, 70, 80

        // Check if the tree is a binary search tree
        System.out.println("Is the tree a BST? " + binaryTree.isBST()); // Should return true

        // Final size of the tree
        System.out.println("Final size of the tree: " + binaryTree.size());
    }
}

