package Queues;

import java.util.Queue;
import java.util.Stack;

//reverse => stack
public class QueueReverser {
    public static void reverser(Queue<Integer> queue, int k) {
        if (k < 0 || k > queue.size())
            throw new IllegalStateException();

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < k; i++) // reverse
            stack.push(queue.remove());

        while (!stack.isEmpty())
            queue.add(stack.pop());// return to queue [40,50,30,20,10]

        for (int i = 0; i < queue.size() - k; i++)
            queue.add(queue.remove());
    }
}

// Given an integer K and a queue of integers,
// write code to reverse the order of the first K elements of the queue.
// Input:Q=[10,20,30,40,50] , K=3
// Output:Q=[30,20,10,40,50]
// Solution:QueueReverser.reverse()