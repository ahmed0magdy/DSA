package nonlinear.heaps;

public class priorityQueueWithHeap {
    private heap heap = new heap(10);

    public void enqueue(int item) {
        heap.insert(item);
    }

    public int dequeue() {
        return heap.remove();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }
}
