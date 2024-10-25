import list.ArrayList;

public class Test {
    public static void main(String[] args) {
        // Create an ArrayList of Integer type
        ArrayList<Integer> list = new ArrayList<>(10);

        // Test adding elements to the list
        list.push(1);
        list.push(2);
        list.push(3);

        // Print the list
        list.print(); // Expected output: [1, 2, 3]

        // Test removing an element
        list.remove(1); // Removes the element at index 1 (value 2)

        // Print the list again
        list.print(); // Expected output: [1, 3]

        // Test finding an index
        int index = list.indexOf(3);
        System.out.println("Index of 3: " + index); // Expected output: Index of 3: 1

        // Test pulling (removing the last element)
        list.pull();

        // Print the list after pulling
        list.print(); // Expected output: [1]

        // Test pulling again
        list.pull();

        // Print the list after another pull
        list.print(); // Expected output: []
    }
}
