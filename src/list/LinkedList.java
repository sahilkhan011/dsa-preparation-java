package list;

public class LinkedList<T> {
    private Node headNode;
    private Node topNode;
    private int size; // Track the size of the list

    public LinkedList() {
        headNode = new Node(); // Placeholder node
        topNode = headNode; // Initially, topNode is the placeholder
        size = 0; // Initial size is 0
    }

    public void addLast(T data) {
        Node newNode = new Node(data);
        topNode.setNext(newNode);
        topNode = newNode;
        size++;
    }

    public void addFirst(T data) {
        Node newNode = new Node(data);
        newNode.setNext(headNode.getNext());
        if (headNode.getNext() == null) {
            topNode = newNode;
        }
        headNode.setNext(newNode);
        size++;
    }

    public void removeLast() {
        if (size == 0) {
            System.out.println("List is empty, cannot remove last element.");
            return;
        }

        Node current = headNode;
        while (current.getNext() != null && current.getNext() != topNode) {
            current = current.getNext();
        }

        current.setNext(null);
        topNode = current;
        size--;
    }

    public void removeFirst() {
        if (size == 0) {
            System.out.println("List is empty, cannot remove first element.");
            return;
        }

        headNode.setNext(headNode.getNext().getNext());
        if (headNode.getNext() == null) { // If the list is now empty
            topNode = headNode; // Reset topNode to the placeholder
        }
        size--;
    }

    public void print() {
        Node current = headNode.getNext(); // Skip the placeholder node
        while (current != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }
    }

    public int size() {
        return size;
    }

    private class Node {
        private T data;
        private Node next = null;

        Node(T data) {
            this.data = data;
        }

        Node() {
            this.data = null;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
