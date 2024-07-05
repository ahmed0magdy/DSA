package nonlinear.Heaps;

public class heap {

    private final int[] items;
    private int size;

    public heap(int capacity) {
        items = new int[capacity];
    }

    public void insert(int value) {
        if (isFull()) {
            throw new IllegalStateException();
        }
        items[size++] = value;
        bubbleUp();
    }

    public int remove() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        var root = items[0];
        items[0] = items[--size];
        bubbleDown();
        return root;
    }

    private void bubbleDown() {
        var index = 0;
        while (index < size && !isValidParent(index)) {
            var largestChildIndex = largestChildIndex(index);
            swap(index, largestChildIndex);
            index = largestChildIndex;
        }
    }

    private int largestChildIndex(int index) {
        if (!hasLeftChild(index)) {
            return index;
        }
        if (!hasRightChild(index)) {
            return leftIndex(index);
        }
        return (leftchild(index) > rightchild(index)) ? leftIndex(index) : rightIndex(index);
    }

    private boolean isValidParent(int index) {
        if (!hasLeftChild(index)) {
            return true;
        }
        var isValid = items[index] >= leftchild(index);
        if (hasRightChild(index)) {
            isValid &= items[index] >= rightchild(index);
        }
        return isValid;
    }

    private boolean hasLeftChild(int index) {
        return leftIndex(index) < size;
    }

    private boolean hasRightChild(int index) {
        return rightIndex(index) < size;
    }

    private int leftchild(int index) {
        return items[leftIndex(index)];
    }

    private int rightchild(int index) {
        return items[rightIndex(index)];
    }

    private int leftIndex(int index) {
        return index * 2 + 1;
    }

    private int rightIndex(int index) {
        return index * 2 + 2;
    }

    private void bubbleUp() {
        var index = size - 1;
        while (index > 0 && items[index] > items[parent(index)]) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private void swap(int first, int second) {
        var temp = items[first];
        items[first] = items[second];
        items[second] = temp;
    }

    public boolean isFull() {
        return items.length == size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int max() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }

        return items[0];
    }

    public static boolean isMaxHeap(int[] arr) {
        return isMaxHeap(arr, 0);
    }

    private static boolean isMaxHeap(int[] arr, int index) {
        var lastParentIndex = (arr.length - 2) / 2;
        if (index > lastParentIndex) // bypass all leaf nodes bec they don't have children
        {
            return true;
        }
        var leftindex = index * 2 + 1;
        var rightindex = index * 2 + 2;
        var leftchild = leftindex < arr.length ? arr[leftindex] : arr[index];
        var rightchild = rightindex < arr.length ? arr[rightindex] : arr[index];
        var isValid = arr[index] >= leftchild && arr[index] >= rightchild;
        return isValid && isMaxHeap(arr, leftindex) && isMaxHeap(arr, rightindex);
    }

}
