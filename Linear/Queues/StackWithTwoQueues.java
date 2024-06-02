package Linear.Queues;

import java.util.ArrayDeque;
import java.util.Queue;

//all operations are in q1 & q2 is only helper for pop
public class StackWithTwoQueues {
    private Queue<Integer> q1 = new ArrayDeque<>();
    private Queue<Integer> q2 = new ArrayDeque<>();
    private int top;

    public void push(int item) {
        q1.add(item);
        top = item;
    }

    public int pop() {
        while (q1.isEmpty())
            throw new IllegalStateException();
        while (q1.size() > 1) {
            top = q1.remove();
            q2.add(top);
        }
        var temp = q1;
        q1 = q2;
        q2 = temp;
        return q2.remove();
    }

    public int peek() {
        if (q1.isEmpty())
            throw new IllegalStateException();
        return top;
    }

    public int size() {
        return q1.size();
    }

    public boolean isEmpty() {
        return q1.isEmpty();
    }

    @Override
    public String toString() {
        return q1.toString();
    }
}

// Build a stack using two queues.
// Implement the following operations and calculate their runtime
// complexities.-push-pop-peek-size-isEmpty
// Solution: StackWithTwoQueues