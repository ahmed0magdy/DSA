package linkedlistsm;

public class linkedList {
    public class Node {
        private int value;
        private Node next;

        private Node(int data) {
            value = data;
            next = null;
        }
    }

    private Node head;
    private Node tail;

    public void addFirst(int item) {
        Node node = new Node(item);
        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    public void addLast(int item) {
        // O(1)
        Node node = new Node(item);
        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }

    }

    // public void addLast(int data) {
    // // O(n)
    // Node newNode = new Node(data);
    // if (head == null) {
    // // If the list is empty, then the new node is both the head and the tail
    // head = newNode;
    // } else {
    // // Otherwise, find the last node and append the new node
    // Node current = head;
    // while (current.next != null) {
    // current = current.next;
    // }
    // current.next = newNode;
    // }
    // }

    public void deleteFirst() {

    }

    public void deleteLast() {

    }

    public void contains() {

    }

    public void indexOf() {

    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        System.out.println("out");
    }

}
