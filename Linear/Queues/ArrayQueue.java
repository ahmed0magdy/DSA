package Linear.Queues;

import java.util.Arrays;

//ArrayDeque //front&rear pointers

public class ArrayQueue {
    private int[] items;
    private int rear;
    private int front;
    private int count;

    ArrayQueue(int n) {
        items = new int[n];
    }

    public void enqueue(int item) {
        if (isFull())
            throw new IllegalStateException();
        items[rear] = item;
        rear = (rear + 1) % items.length;
        count++;
    }

    public int dequeue() {
        if (isEmpty())
            throw new IllegalStateException();
        int x = items[front];
        items[front] = 0;
        front = (front + 1) % items.length;
        count--;
        return x;

    }

    public int peek() {
        if (isEmpty())
            throw new IllegalStateException();
        return items[front];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == items.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
