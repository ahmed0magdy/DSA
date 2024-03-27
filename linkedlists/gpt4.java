package linkedlists;
// package linkedlistsm;

// public class gpt4 {

// }

// // Node class representing each element in the linked list
// class Node {
// int data; // or any other type you want to store
// Node next;

// Node(int data) {
// this.data = data;
// this.next = null;
// }
// }

// // LinkedList class
// class LinkedList {
// Node head; // reference to the first node in the list

// // Constructor to create an empty LinkedList
// public LinkedList() {
// head = null;
// }

// // Method to add a new node at the beginning of the list
// public void addFirst(int data) {
// Node newNode = new Node(data); // create a new node with the given data
// newNode.next = head; // link the new node to the current head
// head = newNode; // update the head to be the new node
// }

// // Method to print the contents of the linked list
// public void printList() {
// Node current = head;
// while (current != null) {
// System.out.print(current.data + " -> ");
// current = current.next;
// }
// System.out.println("null");
// }
// }

// // Example usage
// public class Main {
// public static void main(String[] args) {
// LinkedList list = new LinkedList();
// list.addFirst(3);
// list.addFirst(2);
// list.addFirst(1);

// list.printList(); // Output: 1 -> 2 -> 3 -> null
// }
// }

// class Node {
// int data;
// Node next;

// Node(int data) {
// this.data = data;
// this.next = null;
// }
// }

// class LinkedList {
// Node head;

// public LinkedList() {
// head = null;
// }

// public void addFirst(int data) {
// Node newNode = new Node(data);
// newNode.next = head;
// head = newNode;
// }

// public void addLast(int data) {
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

// public void printList() {
// Node current = head;
// while (current != null) {
// System.out.print(current.data + " -> ");
// current = current.next;
// }
// System.out.println("null");
// }
// }

// public class Main {
// public static void main(String[] args) {
// LinkedList list = new LinkedList();
// list.addLast(1);
// list.addLast(2);
// list.addLast(3);

// list.printList(); // Output: 1 -> 2 -> 3 -> null
// }
// }

// class LinkedList {
// Node head;

// // ... (other methods like addFirst, addLast, etc.)

// public void deleteFirst() {
// if (head == null) {
// // List is empty, nothing to delete
// return;
// }
// // Move the head to the next node, effectively deleting the first node
// head = head.next;
// }

// public void deleteLast() {
// if (head == null) {
// // List is empty, nothing to delete
// return;
// }
// if (head.next == null) {
// // There is only one element in the list
// head = null;
// return;
// }
// // Find the second-to-last node
// Node current = head;
// while (current.next.next != null) {
// current = current.next;
// }
// // Set the second-to-last node's next to null, effectively deleting the last
// // node
// current.next = null;
// }

// public boolean contains(int data) {
// Node current = head;
// while (current != null) {
// if (current.data == data) {
// return true; // Data found
// }
// current = current.next;
// }
// return false; // Data not found
// }

// public int indexOf(int data) {
// Node current = head;
// int index = 0;
// while (current != null) {
// if (current.data == data) {
// return index; // Data found, return its index
// }
// current = current.next;
// index++;
// }
// return -1; // Data not found, return -1
// }
// }

// class Node<T> {
// T data;
// Node<T> next;

// Node(T data) {
// this.data = data;
// this.next = null;
// }
// }

// class LinkedList<T> {
// Node<T> head;

// // ... (other methods like addFirst, addLast, etc.)

// public void deleteFirst() {
// if (head == null) {
// // List is empty, nothing to delete
// return;
// }
// // Move the head to the next node, effectively deleting the first node
// head = head.next;
// }

// public void deleteLast() {
// if (head == null) {
// // List is empty, nothing to delete
// return;
// }
// if (head.next == null) {
// // There is only one element in the list
// head = null;
// return;
// }
// // Find the second-to-last node
// Node<T> current = head;
// while (current.next.next != null) {
// current = current.next;
// }
// // Set the second-to-last node's next to null, effectively deleting the last
// // node
// current.next = null;
// }

// public boolean contains(T data) {
// Node<T> current = head;
// while (current != null) {
// if (current.data.equals(data)) {
// return true; // Data found
// }
// current = current.next;
// }
// return false; // Data not found
// }

// public int indexOf(T data) {
// Node<T> current = head;
// int index = 0;
// while (current != null) {
// if (current.data.equals(data)) {
// return index; // Data found, return its index
// }
// current = current.next;
// index++;
// }
// return -1; // Data not found, return -1
// }
// }

// public class Main {
// public static void main(String[] args) {
// LinkedList<String> list = new LinkedList<>();
// list.addLast("Hello");
// list.addLast("World");
// list.addLast("!");

// System.out.println("List contains 'World': " + list.contains("World")); //
// true
// System.out.println("Index of 'Hello': " + list.indexOf("Hello")); // 0

// list.deleteFirst(); // Deletes "Hello"
// list.deleteLast(); // Deletes "!"

// list.printList(); // Output: World -> null
// }
// }

// class Node<T> {
// private T data;
// private Node<T> next;

// public Node(T data) {
// this.data = data;
// this.next = null;
// }

// public T getData() {
// return data;
// }

// public void setData(T data) {
// this.data = data;
// }

// public Node<T> getNext() {
// return next;
// }

// public void setNext(Node<T> next) {
// this.next = next;
// }
// }

// class LinkedList<T> {
// private Node<T> head;

// public void addFirst(T item) {
// Node<T> newNode = new Node<>(item);
// newNode.setNext(head);
// head = newNode;
// }

// // ... (other methods)
// }