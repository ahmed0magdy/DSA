import java.util.Arrays;

public class ArrayStack {
    private int[] items;
    private int count;

    ArrayStack(int n) {
        items = new int[n];
    }

    public void push(int item) {
        if (items.length == count)
            throw new StackOverflowError();
        items[count++] = item;
    }

    public int pop() {
        if (count == 0)
            throw new IllegalStateException();
        return items[--count];
    }

    public int peek() {
        if (count == 0)
            throw new IllegalStateException();
        return items[count - 1];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public String toString() {
        // var contents = Arrays.copyOfRange(items, 0, count);
        return Arrays.toString(items);
    }
}

// public class ArrayStack {

// private int[] stackArray; // The array to hold the stack elements

// private int top; // Index of the top element in the stack

// private final int MAX_SIZE = 100; // Maximum size for our stack

// public ArrayStack() {

// this.stackArray = new int[MAX_SIZE]; // Initialize array with a fixed
// capacity

// this.top = -1; // The stack is initially empty, so top is set to -1

// }

// /**
// *
// * Push an element onto the stack.
// *
// */

// public void push(int value) {

// if (isFull()) {

// System.out.println("Stack Overflow");

// return;

// }

// stackArray[++top] = value; // Increment top and add element to the array

// }

// /**
// *
// * Pop an element from the stack if it's not empty.
// *
// */

// public int pop() {

// if (isEmpty()) {

// System.out.println("Stack Underflow");

// return -1; // Returning invalid value, could also throw IllegalStateException

// }

// return stackArray[top--]; // Decrement top and return the element

// }

// /**
// *
// * Check if the stack is empty.
// *
// */

// public boolean isEmpty() {

// return (top == -1);

// }

// /**
// *
// * Check if the stack is full.
// *
// */

// private boolean isFull() {

// return top == MAX_SIZE - 1;

// }

// }