package list;

import java.util.EmptyStackException;

public class StackWithArray <E> {
    private int maxSize;
    E[] items;
    private int top;

    @SuppressWarnings("unchecked") // Suppress unchecked cast warning
    public StackWithArray(int size) {
        maxSize = size;
        top = -1;
        items = (E[]) new Object[size];
    }

    public void setSize(int size) {
        maxSize = size;
    }

    public void push(E item){
        if (isFull()) {
            System.out.println("Stack is full. Cannot push element.");
            return;
        }
        items[++top] = item;
    }

    public E pop(){
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        E oldTop = items[top];
        items[top--] = null;
        return oldTop;
    }

    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return items[top];
    }

    public boolean isFull(){
        return top == maxSize -1;
    }
    public boolean isEmpty(){
        return top == -1;
    }



}
