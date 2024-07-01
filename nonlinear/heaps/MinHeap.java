package nonlinear.heaps;

public class MinHeap {

    private class Node {

        private final int key;
        private final String value;

        public Node(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }
    private final Node[] nodes;
    private int size;

    public MinHeap(int capacity) {
        nodes = new Node[capacity];
    }

    public void insert(int key, String value) {

        if (isFull()) {
            throw new IllegalStateException();
        }

        nodes[size++] = new Node(key, value);
        bubbleUp();
    }

    public String remove() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        var root = nodes[0].value;
        nodes[0] = nodes[--size];
        bubbleDown();
        return root;
    }

    private void bubbleDown() {
        var index = 0;
        while (index < size && !isValidParent(index)) {
            var smallerChildIndex = smallerChildIndex(index);
            swap(index, smallerChildIndex);
            index = smallerChildIndex;
        }
    }

    private int smallerChildIndex(int index) {
        if (!hasLeftChild(index)) {
            return index;
        }
        if (!hasRightChild(index)) {
            return leftIndex(index);
        }

        return (leftChild(index).key < rightChild(index).key) ? leftIndex(index) : rightIndex(index);
    }

    private boolean isValidParent(int index) {
        if (!hasLeftChild(index)) {
            return true;
        }

        var isValid = nodes[index].key <= nodes[leftIndex(index)].key;
        if (hasRightChild(index)) {
            isValid &= nodes[index].key <= nodes[rightIndex(index)].key;
        }

        return isValid;

    }

    private boolean hasLeftChild(int index) {
        return leftIndex(index) < size;
    }

    private boolean hasRightChild(int index) {
        return rightIndex(index) < size;
    }

    private Node leftChild(int index) {
        return nodes[leftIndex(index)];
    }

    private Node rightChild(int index) {
        return nodes[rightIndex(index)];
    }

    private int leftIndex(int index) {
        return index * 2 + 1;
    }

    private int rightIndex(int index) {
        return index * 2 + 2;
    }

    private void bubbleUp() {
        int index = size - 1;
        while (index > 0 && nodes[index].key < nodes[parent(index)].key) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    private void swap(int first, int second) {
        var temp = nodes[first];
        nodes[first] = nodes[second];
        nodes[second] = temp;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    public boolean isFull() {
        return size == nodes.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String heaptoString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(String.format("key: %d, value %s \n", nodes[i].key, nodes[i].value));
        }
        return sb.toString();
    }

    public int getSize() {
        return size;
    }
}

// Implement a min heap. In this implementation, store the items in an 
// array of nodes. Each node should have two fields: key (integer) and 
// value (string). Nodes should be heapified based on their keys.
