import queue.Queue;

public class Test {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>(5);

        // Enqueue elements
        System.out.println("Enqueuing 1, 2, 3");
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        // Display size
        System.out.println("Current size: " + queue.size()); // Output: 3

        // Dequeue elements
        System.out.println("Dequeued: " + queue.dequeue()); // Output: 1
        System.out.println("Dequeued: " + queue.dequeue()); // Output: 2

        // Current size after dequeue
        System.out.println("Current size: " + queue.size()); // Output: 1

        // Enqueue more elements
        System.out.println("Enqueuing 4, 5, 6");
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        // queue.enqueue(8); // This will throw an exception since the queue is full



        // Clear the queue
        System.out.println("Clearing the queue");
        queue.clear();
        System.out.println("Current size after clearing: " + queue.size()); // Output: 0

    }
}