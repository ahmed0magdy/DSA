package Sort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] numbers = { 7, 3, 1, 4, 6, 2, 3, 5 };
        // int[] numbers = { 7, 3 };
        var sorter = new Sort();
        // sorter.bubbleSort(numbers);
        // sorter.selectionSort(numbers);
        // sorter.insertionSort(numbers);
        // sorter.mergeSort(numbers);
        // sorter.inplaceMergeSort(numbers, 0, (numbers.length - 1));
        // sorter.quickSort(numbers);
        // sorter.countingSort(numbers, 7);
        sorter.bucketSort(numbers, 3);
        System.out.println(Arrays.toString(numbers));
    }
}
