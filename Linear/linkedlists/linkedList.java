package Linear.linkedlists;

// import java.util.LinkedList;
import java.util.NoSuchElementException;

//try without using tail

public class linkedList {
    private class Node {
        private int value;
        private Node next;

        private Node(int data) {
            value = data;
            next = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public void addFirst(int item) {
        Node node = new Node(item);
        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

    public void addLast(int item) {
        // O(1) , there is another solution without using tail O(n)
        Node node = new Node(item);
        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public void deleteFirst() {
        if (head == null)
            throw new NoSuchElementException();
        if (head == tail) {
            head = tail = null;
        } else {
            Node second = head.next;
            head.next = null; // not necessary for garbage collector
            head = second;
        }
        size--;

    }

    public void deleteLast() {
        if (tail == null)
            throw new NoSuchElementException();
        if (head == tail) {
            head = tail = null;
        } else {
            var previous = getPrevious(tail);
            tail = previous;
            tail.next = null;
        }
        size--;
        // my solution
        // Node current = head;
        // Node befNode = null;
        // while (current.next != null) {
        // befNode = current;
        // current = current.next;
        // }
        // tail = befNode;
        // tail.next = null;

        // mosh solution
        // var current = head;
        // while (current != null) {
        // if (current.next == tail)
        // break;
        // current = current.next;
        // }

    }

    public Node getPrevious(Node node) {
        var current = head;
        while (current != null) {
            if (current.next == node)
                return current;
            current = current.next;
        }
        return null;
    }

    public boolean contains(int item) {
        // Node current = head;
        // while (current != null) {
        // if (current.value == item)
        // return true;
        // current = current.next;
        // }
        // return false;
        return indexOf(item) != -1;
    }

    public int indexOf(int item) {
        Node current = head;
        int index = 0;
        while (current != null) {
            if (current.value == item)
                return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        System.err.println("out");
    }

    public int size() { // efficiency n(1)
        return size;
    }

    public int[] toArray() {
        int[] array = new int[size];
        var current = head;
        var index = 0;
        while (current != null) {
            array[index++] = current.value;
            current = current.next;
        }
        return array;
    }

    public void reversed() {
        if (head == null)
            return;
        // [10-> 20-> 30-> 40-> 50]
        // [10 <-20 <-30 <-40 <-50]
        Node current = head; // head.next
        Node prev = null; // head
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        tail = head;
        tail.next = null;
        head = prev;
    }

    public int getKthFromEnd(int k) {
        if (k < 1) {
            throw new IllegalArgumentException("k must be greater than 0");
        }
        // we can use size instead of two-pointer technique
        // [10 ,20 ,30 ,40, 50, 60, 70]
        if (head == null)
            throw new IllegalStateException();
        Node ref = head;
        Node cur = head;
        for (int i = 0; i < k; i++) {
            ref = ref.next;
            if (ref == null)
                throw new IllegalArgumentException("k is greater than the number of nodes in the list");
        }
        while (ref != null) { // when u change it to tail k becomes k-1 and other things happen in vedio
            cur = cur.next;
            ref = ref.next;
        }

        return cur.value;

    }

    public void printMiddle() {// try without tail
        // [10 ,20 ,30 ,40 ,50 ,60]
        if (head == null)
            throw new IllegalStateException();
        var a = head;
        var b = head;
        while (b != tail && b.next != tail) {
            b = b.next.next;
            a = a.next;
        }
        if (b == tail) {
            System.out.println(a.value);
        } else {
            System.out.println(a.value + " , " + a.next.value);
        }
    }

    public boolean hasLoop() {
        if (head == null)
            return false;

        var a = head;
        var b = head;
        while (b != null && b.next != null) {
            b = b.next.next;
            a = a.next;
            if (a == b)
                return true;
        }
        return false;
    }

    public linkedList createWithLoop() {
        linkedList list = new linkedList();

        // Creating nodes
        list.head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);

        // Connecting nodes to form a loop
        list.head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = second; // Loop here, connecting fifth node back to the second

        return list;
    }

}
