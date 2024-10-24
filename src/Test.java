import list.LinkedList;

public class Test {
    public static void main(String[] args) {
        // Create a LinkedList of Integer type
        LinkedList<Integer> list = new LinkedList<>();

        // Add elements at the last
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        System.out.println("After adding elements at the end:");
        list.print(); // Output: 10, 20, 30

        // Add elements at the first
        list.addFirst(5);
        System.out.println("\nAfter adding an element at the start:");
        list.print(); // Output: 5, 10, 20, 30

        // Remove the first element
        list.removeFirst();
        System.out.println("\nAfter removing the first element:");
        list.print(); // Output: 10, 20, 30

        // Remove the last element
        list.removeLast();
        System.out.println("\nAfter removing the last element:");
        list.print(); // Output: 10, 20

        // Display the size of the list
        System.out.println("\nSize of the list: " + list.size()); // Output: 2
    }
}
