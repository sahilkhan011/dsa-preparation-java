package list;

import java.util.Arrays;

public class ArrayList<E> {
    private int used;       // Number of elements currently used
    private int length;     // Capacity of the underlying array
    private E[] items;      // Array to hold the items

    @SuppressWarnings("unchecked") // Suppress unchecked cast warning
    public ArrayList(int initialLength) {
        // Create a generic array
        items = (E[]) new Object[initialLength];
        this.length = initialLength;
        this.used = 0; // Initialize used count
    }

    public void push(E item) {
        // Check if the array needs to be resized
        if (used == length) {
            length *= 2; // Double the size
            items = Arrays.copyOf(items, length); // Resize the array
        }
        // Add the new item and increment used count
        items[used++] = item;
    }

    public void pull() {
        // Decrement used count if there are elements
        if (used > 0) {
            used--;
            items[used] = null; // Optional: clear the last item
        }
    }

    public void remove(int index) {
        if (index < 0 || index >= used) {
            throw new IllegalArgumentException("Index out of bounds");
        }
        // Shift elements to the left to fill the gap
        for (int i = index; i < used - 1; i++) {
            items[i] = items[i + 1];
        }
        used--; // Decrement used count
        items[used] = null; // Optional: clear the last item
    }

    public int indexOf(E item) {
        for (int i = 0; i < used; i++) {
            if (items[i].equals(item)) { // Use equals for comparison
                return i; // Return the index if found
            }
        }
        return -1; // Return -1 if not found
    }

    public void print() {
        System.out.print("[");
        for (int i = 0; i < used; i++) {
            System.out.print(items[i]);
            if (i != used - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}

