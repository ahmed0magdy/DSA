package Linear.arrays;

public class Array {
    private int[] items;
    private int count;

    // constructor
    public Array(int length) {
        items = new int[length];
    }

    public void insert(int item) {
        // if array is full
        // The reason for doubling the size of the array instead of increasing it by one
        // is primarily due to performance considerations.
        // When an array needs to be expanded, a new array is created and all the
        // elements from the old array are copied to the new one. This operation is
        // relatively expensive in terms of time complexity, taking O(n) time where n is
        // the number of elements in the array.
        // If we increased the size of the array by just one element each time an insert
        // operation is performed, we would have to perform this expensive operation
        // every time, leading to a time complexity of O(n^2) for inserting n elements.
        // On the other hand, if we double the size of the array each time it needs to
        // be expanded, then the total number of copies that need to be made when
        // inserting n elements is roughly 2n, leading to an amortized time complexity
        // of O(1) per insert operation, which is much more efficient.
        // This strategy is known as dynamic array resizing or array doubling, and is
        // used in many programming languages and libraries to implement dynamic arrays
        // or array lists. It’s a trade-off between time (faster inserts) and space
        // (potentially using more memory than necessary). In many cases, the improved
        // time efficiency is worth the extra space.
        // The division by 2 in the formula n*(n-1)/2 comes from the formula for the sum
        // of an arithmetic series.
        // An arithmetic series is a sequence of numbers in which the difference between
        // any two consecutive terms is constant. For example, the sequence 1, 2, 3,
        // ..., n-1 is an arithmetic series where the common difference is 1.
        // The sum S of the first n terms of an arithmetic series can be found using the
        // formula:
        // S=2n​∗(a+l)
        // where:
        // n is the number of terms,
        // a is the first term, and
        // l is the last term.
        if (count == items.length) {
            int[] newItems = new int[count * 2];
            for (int i = 0; i < count; i++)
                newItems[i] = items[i];
            items = newItems;
        }
        // insert last item & increment count
        items[count++] = item;
    }

    public void removeAt(int index) {
        // validate index
        if (index < 0 || index >= count)
            throw new IllegalArgumentException();
        // shift items to left & shrink array size
        for (int i = index; i < count - 1; i++) // take care here in vedio is wrong
            items[i] = items[i + 1];

        count--;
    }

    public int indexOf(int item) {
        // O(n)
        for (int i = 0; i < count; i++)
            if (items[i] == item)
                return i;
        return -1;
    }

    public int max() {
        if (count == 0)
            throw new IllegalStateException("Array is empty");

        int max = items[0];
        for (int i = 1; i < count; i++)
            if (max < items[i])
                max = items[i];
        return max;
    }

    public Array intersect(Array other) {
        Array intersection = new Array(count);
        for (int i = 0; i < count; i++) {
            if (other.indexOf(items[i]) >= 0)
                intersection.insert(items[i]);
        }
        return intersection;
    }

    // we only swap elements until the middle of the array is reached

    public void reverse() {
        for (int i = 0; i < count / 2; i++) {
            var temp = items[i];
            items[i] = items[count - 1 - i];
            items[count - 1 - i] = temp;
        }
    }

    // public void reversegpt4() {
    // for (int start = 0, end = count - 1; start < end; start++, end--) {
    // int temp = items[start];
    // items[start] = items[end];
    // items[end] = temp;
    // }
    // }

    // public void reverse() {
    // int[] reversed = new int[count];
    // int n = count;
    // for (int i = 0; i < count; i++) {
    // reversed[n - 1] = items[i];
    // n--;
    // }
    // for (int i = 0; i < count; i++)
    // System.out.println(reversed[i]);
    // }

    public void insertAt(int item, int index) {
        // 0 1 2 3 4 5 6
        // [10, 20 ,30 ,40 ,50, 60]
        // Check if the index is out of bounds
        if (index < 0 || index > count)
            throw new IllegalArgumentException("Index out of bounds");

        // Resize the array if it is full
        if (count == items.length) {
            int[] newItems = new int[count * 2];
            for (int i = 0; i < count; i++)
                newItems[i] = items[i];
            items = newItems;
        }

        // Shift items to the right to make space for the new item
        for (int i = count; i > index; i--)
            items[i] = items[i - 1];

        // Insert the new item at the given index
        items[index] = item;

        // Increment the count
        count++;
    }

    public void print() {
        for (int i = 0; i < count; i++)
            System.out.print(items[i] + " ");
        System.out.println();
    }
}