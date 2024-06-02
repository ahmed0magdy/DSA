package Linear.Queues;

// import java.util.PriorityQueue;

// import java.util.Queue;
// import java.util.ArrayDeque;
// import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        StackWithTwoQueues stack = new StackWithTwoQueues();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60);
        stack.pop();
        stack.pop();
        System.out.println(stack.peek());
        System.out.println(stack);
        // Queue<Integer> queue = new ArrayDeque<>();
        // queue.add(10);
        // queue.add(20);
        // queue.add(30);
        // queue.add(40);
        // queue.add(50);
        // QueueReverser.reverser(queue, 3);
        // System.out.println(queue);

        // priorityQueue queue = new priorityQueue(5);
        // queue.add(5);
        // queue.add(3);
        // queue.add(2);
        // queue.add(1);
        // queue.add(4);
        // queue.add(10);
        // queue.add(40);
        // System.out.println(queue);
        // while (!queue.isEmpty()) {
        // System.out.println(queue.remove());
        // }

        // PriorityQueue<Integer> queue = new PriorityQueue<>();
        // queue.add(5);
        // queue.add(3);
        // queue.add(7);
        // queue.add(2);
        // while (!queue.isEmpty()) {
        // System.out.println(queue.remove());
        // }
    }
    // public static void main(String[] args) {
    // LinkedlistQueue queue = new LinkedlistQueue();
    // queue.enqueue(10);
    // queue.enqueue(20);
    // queue.enqueue(30);
    // queue.enqueue(40);
    // queue.enqueue(50);
    // queue.dequeue();
    // queue.dequeue();
    // System.out.println(queue.peek());
    // System.out.println(queue);
    // }
    // public static void main(String[] args) {
    // ArrayQueue queue = new ArrayQueue(5);
    // queue.enqueue(10);
    // queue.enqueue(20);
    // queue.enqueue(30);
    // queue.enqueue(40);
    // queue.enqueue(50);
    // System.out.println(queue.dequeue());
    // System.out.println(queue.dequeue());
    // queue.enqueue(60);
    // queue.enqueue(70);
    // System.out.println(queue.dequeue());
    // queue.enqueue(80);
    // System.out.println(queue);
    // }

    // public static void main(String[] args) {
    // Queue<Integer> queue = new ArrayDeque<>();
    // queue.add(10);
    // queue.add(20);
    // queue.add(30);
    // System.out.println(queue);
    // reverse(queue);
    // System.out.println(queue);
    // }

    // public static void reverse(Queue<Integer> queue) {
    // Stack<Integer> stack = new Stack<>();
    // while (!queue.isEmpty())
    // stack.push(queue.remove());
    // while (!stack.isEmpty())
    // queue.add(stack.pop());
    // }
}
