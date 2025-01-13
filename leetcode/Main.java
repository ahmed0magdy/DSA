package leetcode;

public class Main {
    public static void main(String[] args) {
        var arr = new DynamicArray(10);
        arr.set(0, 2);
        arr.set(1, 4);
        arr.set(3, 5);
        System.out.println(arr.getSize());

    }
}

class DynamicArray {
    private int[] arr;
    private int capacity;
    private int length;

    public DynamicArray(int capacity) {
        if (capacity > 0) {
            this.capacity = capacity;
            this.length = 0;
            this.arr = new int[this.capacity];
        }
    }

    public int get(int i) {
        return arr[i];
    }

    public void set(int i, int n) {
        arr[i] = n;
    }

    public void pushback(int n) {
        if (length == capacity)
            resize();
        arr[length++] = n;
    }

    public int popback() {
        return arr[--length];
    }

    private void resize() {
        capacity *= 2;
        int[] newArr = new int[capacity];
        for (int i = 0; i < length; i++)
            newArr[i] = arr[i];

        arr = newArr;
    }

    public int getSize() {
        return length;
    }

    public int getCapacity() {
        return capacity;
    }
}

// Design a

// Dynamic Array (aka a resizable array) class, such as an ArrayList in Java or
// a vector in C++.

// Your DynamicArray class should support the following operations:

// DynamicArray(int capacity) will initialize an empty array with a capacity of
// capacity, where capacity > 0.
// int get(int i) will return the element at index i. Assume that index i is
// valid.
// void set(int i, int n) will set the element at index i to n. Assume that
// index i is valid.
// void pushback(int n) will push the element n to the end of the array.
// int popback() will pop and return the element at the end of the array. Assume
// that the array is non-empty.
// void resize() will double the capacity of the array.
// int getSize() will return the number of elements in the array.
// int getCapacity() will return the capacity of the array.
// If we call void pushback(int n) but the array is full, we should resize the
// array first.
// Note:

// The index
// i provided

// to get(int i)

// and set(int i) is guaranteed to be greater than or equal to 0 and less than
// the number of elements in the array.