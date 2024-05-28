package Queues;

import java.util.ArrayList;

public class LinkedlistQueue {
    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int count;

    public void enqueue(int item) {
        var node = new Node(item);
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        count++;
    }

    public int dequeue() {
        if (isEmpty())
            throw new IllegalStateException();
        int value;
        if (head == tail) {
            value = head.value;
            head = tail = null;
        } else {
            var second = head.next;
            value = head.value;
            head.next = null;
            head = second;

        }
        count--;
        return value;

    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        return head.value;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return head == null; // count==0
    }

    public String toString() {
        ArrayList<Integer> list = new ArrayList<>();
        var current = head;
        while (current != null) {
            list.add(current.value);
            current = current.next;
        }
        return list.toString();
    }

}
// Build a
// queue using
// a linked
// list from
// scratch.Implement the
// following operations
// and calculate
// their runtime complexities.-enqueue-dequeue-peek-size-
// isEmpty
// Solution:
// LinkedListQueue