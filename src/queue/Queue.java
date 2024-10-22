package queue;

public class Queue<E> {
    private final int maxSize;
    private int size;
    private int front;
    private int rear;
    private final E[] items;

    public Queue(int maxSize) {
        this.maxSize = maxSize;
        size = 0;
        front = 0;
        rear = 0;
        items = (E[]) new Object[maxSize];

    }

    public void enqueue(E item){
        if(isFull())
            throw new RuntimeException("Queue is Full.");
        items[rear] = item;
        size++;
        rear = (rear +1) % maxSize;
    }
    public E dequeue(){
        if(isEmpty())
            throw new RuntimeException("Queue is Empty.");
        E item = items[front];
        items[front] = null;
        size--;
        front = (front +1) % maxSize;
        return item;
    }
    public E peek(){
        if(isEmpty())
            throw new RuntimeException("Queue is Empty.");
        return items[front];
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size==maxSize;
    }

    public int size() {
        return size;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            items[(front + i) % maxSize] = null; // Clear each reference in the queue
        }
        front = 0;
        rear = 0;
        size = 0; // Reset size to 0
    }

}
