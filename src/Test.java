import stack.StackWithArray;

import java.util.EmptyStackException;

public class Test {
    public static void main(String[] args) {
        // Create a stack with a maximum size of 5
        StackWithArray<Integer> stack = new StackWithArray<>(5);

        // Test pushing elements onto the stack
        System.out.println("Pushing elements onto the stack:");
        for (int i = 1; i <= 5; i++) {
            stack.push(i);
            System.out.println("Pushed: " + i);
        }

        // Try pushing an element onto a full stack
        System.out.println("Attempting to push onto a full stack:");
        stack.push(6); // This should print a message indicating the stack is full.

        // Test peeking the top element
        System.out.println("Top element (peek): " + stack.peek());

        // Test popping elements from the stack
        System.out.println("Popping elements from the stack:");
        while (!stack.isEmpty()) {
            System.out.println("Popped: " + stack.pop());
        }

        // Try popping from an empty stack
        System.out.println("Attempting to pop from an empty stack:");
        try {
            stack.pop(); // This should throw an EmptyStackException.
        } catch (EmptyStackException e) {
            System.out.println("Caught exception: " + e);
        }
    }
}
