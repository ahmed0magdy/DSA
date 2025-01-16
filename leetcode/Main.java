package leetcode;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        obj.push(4);
        obj.push(3);
        obj.push(2);
        obj.push(5);

        obj.pop();
        int param_3 = obj.top();
        int param_4 = obj.getMin();
        System.out.println(param_3);
        System.out.println(param_4);
    }
}

class MinStack {

    Stack<Long> stack;
    long min;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(0l);
            min = val;
        } else {
            stack.push(val - min);
            if (val < min)
                min = val;
        }
    }

    public void pop() {
        if (stack.isEmpty())
            return;
        long pop = stack.pop();
        if (pop < 0)
            min -= pop;
    }

    public int top() {
        long top = stack.peek();
        if (top > 0)
            return (int) (top + min);
        else
            return (int) min;

    }

    public int getMin() {
        return (int) min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * long val =4;
 * long val =3;
 * long val =2;
 * long val =5;
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */