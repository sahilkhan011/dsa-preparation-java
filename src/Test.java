import tree.BinaryTree;

public class Test {
    public static void main(String[] args) {
        // Create a new BinaryTree instance
        BinaryTree<Integer> tree = new BinaryTree<>();

        // Insert some values
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);

        // Perform inorder traversal
        System.out.println("Inorder traversal of the binary tree:");
        tree.inorder();
    }
}

