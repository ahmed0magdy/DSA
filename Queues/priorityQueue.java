package Queues;

import java.util.Arrays;

//using ARRAY
//       2
//[1,5,6,7]
public class priorityQueue {
    private int[] items;
    private int count;

    priorityQueue(int capacity) {
        items = new int[capacity];
    }

    public void add(int item) {
        if (isFull()) {
            int[] newItems = new int[items.length * 2];
            for (int i = 0; i < count; i++) {
                newItems[i] = items[i];
            }
            items = newItems;
        }

        // items[i+1] = item;
        int i = shiftItemstoInsert(item);
        items[i] = item;
        count++;
    }

    public int shiftItemstoInsert(int item) {
        int i;
        for (i = count - 1; i >= 0; i--) {
            if (items[i] > item) {
                items[i + 1] = items[i];
            } else {
                break;
            }
        }

        return i + 1;
    }

    public int remove() {
        if (isEmpty())
            throw new IllegalStateException();
        // PS: if you want to remove from beginning of array use a pointer [smallest to
        // biggest]
        return items[--count];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == items.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
