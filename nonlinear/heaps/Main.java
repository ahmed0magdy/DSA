package nonlinear.heaps;

public class Main {

    public static void main(String[] args) {
        var minHeap = new MinHeap(10);
        minHeap.insert(15, "fifteen");
        minHeap.insert(10, "Ten");
        minHeap.insert(20, "Twenty");
        minHeap.insert(5, "Five");
        System.out.println(minHeap.heaptoString());
        var getsize = minHeap.getSize();
        for (int i = 0; i < getsize; i++) {
            String removed = minHeap.remove();
            System.out.println("Removed: " + removed);
        }

        // int[] numbers = { 5, 3, 8, 4, 1, 2 };
        // System.out.println(heap.isMaxHeap(numbers));
        // int[] numbers = { 5, 3, 8, 4, 1, 2 };
        // MaxHeap.heapify(numbers);
        // System.out.println(Arrays.toString(numbers));
        // System.out.println(MaxHeap.getKthLargest(numbers, 7));
        // var heap = new heap(10);
        // heap.insert(10);
        // heap.insert(5);
        // heap.insert(17);
        // heap.insert(4);
        // heap.insert(22);
        // heap.remove();
        // heap.insert(2);
        // System.out.println("DONE");
        // int[] numbers = {5, 3, 10, 1, 4, 2};
        // var heap = new heap(10);
        // for (var number : numbers) {
        //     heap.insert(number);
        // }
        // while (!heap.isEmpty()) {
        //     System.out.println(heap.remove());
        // }
        // for (var i = 0; i < numbers.length; i++) // for (var i = numbers.length - 1; i >= 0; i--)
        // {
        //     numbers[i] = heap.remove();
        // }
        // System.out.println(Arrays.toString(numbers));
        // priorityQueue queue = new priorityQueue(5);
        // insert O(n) - for heaps O(log n) heaps are better
        // delete O(1) - O(log n) queues are better
        // queue.add(30);
        // queue.add(20);
        // queue.add(10);
        // System.out.println(queue);
    }
}
