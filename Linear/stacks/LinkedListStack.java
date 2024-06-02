package Linear.stacks;

public class LinkedListStack {
    private Node top;
    private int size;

    private static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public LinkedListStack() {
        top = null;
        size = 0;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(int item) {
        Node node = new Node(item);
        node.next = top;
        top = node;
        size++;
    }

    public int pop() {
        if (isEmpty())
            throw new IllegalStateException("Stack is empty");
        int value = top.value;
        top = top.next;
        size--;
        return value;
    }

    public int peek() {
        if (isEmpty())
            throw new IllegalStateException("Stack is empty");
        return top.value;
    }

    public int size() {
        return size;
    }

    public void printList() {
        Node current = top;
        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        System.err.println("out");
    }
}