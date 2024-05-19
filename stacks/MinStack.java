
public class MinStack {
    private ArrayStack items = new ArrayStack();
    private ArrayStack minStack = new ArrayStack();

    public void push(int item) {
        items.push(item);
        if (minStack.isEmpty())
            minStack.push(item);
        else if (item < minStack.peek())
            minStack.push(item);
    }

    // idea is here how to get out min if it is poped
    public int pop() {
        if (items.isEmpty())
            throw new IllegalStateException("Stack is empty.");
        var top = items.pop();
        if (top == minStack.peek())
            minStack.pop();
        return top;

    }

    public int min() {
        if (minStack.isEmpty()) {
            throw new IllegalStateException("Min stack is empty.");
        }
        return minStack.peek();
    }

    public void printStacks() {
        System.out.println("Stack: " + items);
        System.out.println("MinStack: " + minStack);
    }
}

// Design a stack that supports push, pop and retrieving the minimum value in
// constant time.
// For example, we populate our stack with[5,2,10,1](from left to right).
// stack.min() 1
// stack.pop()
// stack.min() 2