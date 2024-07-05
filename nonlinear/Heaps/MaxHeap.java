package nonlinear.Heaps;

public class MaxHeap {

    public static void heapify(int[] arr) { // every item must be in right position
        var lastParentIndex = arr.length / 2 - 1;
        // for (int i = 0; i < arr.length/2-1; i++)
        for (int i = lastParentIndex; i >= 0; i--) {
            heapify(arr, i);
        }
    }

    private static void heapify(int[] arr, int index) {
        var largerIndex = index;

        var leftIndex = index * 2 + 1;
        if (leftIndex < arr.length && arr[largerIndex] < arr[leftIndex]) {
            largerIndex = leftIndex;
        }

        var rightIndex = index * 2 + 2;
        if (rightIndex < arr.length && arr[largerIndex] < arr[rightIndex]) {
            largerIndex = rightIndex;
        }

        if (index == largerIndex) {
            return;
        }

        swap(arr, index, largerIndex);
        heapify(arr, largerIndex);

    }

    private static void swap(int[] arr, int first, int second) {
        var temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static int getKthLargest(int[] arr, int k) {
        if (k < 0 || k > arr.length) {
            throw new IllegalArgumentException();
        }

        heap heap = new heap(10);
        for (var number : arr) {
            heap.insert(number);
        }
        for (int i = 0; i < k - 1; i++) {
            heap.remove();
        }

        return heap.max();
    }

}
