package Linear.stacks;

import java.util.Arrays;

public class TwoStacks { // space efficient
    private int[] items;
    private int top1, top2;

    public TwoStacks(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("size should be greater than 0");
        }
        items = new int[capacity];
        top1 = -1;
        top2 = capacity;
    }

    // Function to push an integer into the stack1.
    public void push1(int x) {
        if (top1 < top2 - 1) {
            items[++top1] = x;
        } else {
            throw new IllegalStateException("Stackoverflow1");
        }
    }

    // Function to push an integer into the stack2.
    public void push2(int x) {
        if (top1 < top2 - 1) {
            items[--top2] = x;
        } else {
            throw new IllegalStateException("Stackoverflow2");
        }
    }

    // Function to remove an element from top of the stack1.
    public int pop1() {
        if (top1 >= 0) {
            return items[top1--];// pretend it is removed until new one is pushed
            // int x = items[top1];
            // top1--;
            // return x;
        } else {
            throw new IllegalStateException();
        }
    }

    // Function to remove an element from top of the stack2.
    public int pop2() {
        if (top2 < items.length) {
            return items[top2++];// pretend it is removed until new one is pushed
            // int x = items[top2];
            // top2++;
            // return x;
        } else {
            throw new IllegalStateException();
        }
    }

    public boolean isEmpty1() {
        return top1 == -1;
    }

    public boolean isEmpty2() {
        return top2 == items.length;
    }

    public boolean isFull1() {
        return top1 == top2 - 1;
    }

    public boolean isFull2() {
        return top2 == top1 + 1;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }

}
// public class TwoStacks { // not space efficient
// private int[] items;
// private int top1, top2;
// private int size;

// public TwoStacks(int n) {
// items = new int[n];
// size = n;
// top1 = n / 2 + 1;
// top2 = n / 2;
// }

// // Function to push an integer into the stack1.
// public void push1(int x) {
// if (top1 > 0) {
// items[--top1] = x;
// } else {
// throw new IllegalStateException("Stackoverflow1");
// }
// }

// // Function to push an integer into the stack2.
// public void push2(int x) {
// if (top2 < size - 1) {
// items[++top2] = x;
// } else {
// throw new IllegalStateException("Stackoverflow2");
// }
// }

// // Function to remove an element from top of the stack1.
// public int pop1() {
// if (top1 <= size / 2) {
// int x = items[top1];
// top1++;
// return x;
// } else {
// throw new IllegalStateException();
// }
// }

// // Function to remove an element from top of the stack2.
// public int pop2() {
// if (top2 >= size / 2 + 1) {
// int x = items[top2];
// top2--;
// return x;
// } else {
// throw new IllegalStateException();
// }
// }

// public boolean isEmpty1() {
// return top1 == size / 2 + 1;
// }

// public boolean isEmpty2() {
// return top2 == size / 2;
// }

// public boolean isFull1() {
// return top1 == 0;
// }

// public boolean isFull2() {
// return top2 == size - 1;
// }

// @Override
// public String toString() {
// return Arrays.toString(items);
// }

// }

// Implement two stacks in one array. Support these operations:

// push1() // to push in the first stack
// push2() // to push in the second stack
// pop1()
// pop2()
// isEmpty1()
// isEmpty2()
// isFull1()
// isFull2()
// Make sure your implementation is space efficient. (hint: do not allocate
// the same amount of space by dividing the array in half.)
