package Queues;

import java.util.Stack;

// [10 ,20 , 30]
// s1 [10, 20 ,30]
//s2 [30,20,10]
public class StackQueue {
    private Stack<Integer> st1 = new Stack<>();
    private Stack<Integer> st2 = new Stack<>();

    public void enqueue(int item) {
        st1.push(item);
    }

    // o(n)
    public int dequeue() {
        if (isEmpty())
            throw new IllegalStateException();
        moveFromSt1toSt2();
        return st2.pop();
    }

    public void moveFromSt1toSt2() {
        if (st2.isEmpty()) {
            while (!st1.isEmpty())
                st2.push(st1.pop());
        }
    }

    public int peek() {
        if (isEmpty())
            throw new IllegalStateException();
        moveFromSt1toSt2();
        return st2.peek();
    }

    public Boolean isEmpty() {
        return st1.isEmpty() && st2.isEmpty();
    }
}
