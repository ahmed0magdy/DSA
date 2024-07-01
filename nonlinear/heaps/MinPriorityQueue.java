package nonlinear.heaps;

public class MinPriorityQueue {

    private MinHeap minHeap;

    public MinPriorityQueue(int capacity) {
        minHeap = new MinHeap(capacity);
    }

    public void add(String value, int priority) {
        minHeap.insert(priority, value);
    }

    public String remove() {
        return minHeap.remove();
    }

    public boolean isEmpty() {
        return minHeap.isEmpty();
    }

}

// Implement a min priority queue with the following operations: 
// • add(String value, int priority)
// • remove()
// • isEmpty()
// Use the MinHeap class that 
// you created in the last exercise. Items with 
// a smaller priority should be moved to the beginning of the queue. Hint: 
// use the priority of each item as the key in your min heap.
