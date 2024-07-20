package Sort;

import java.util.*;

public class Sort {
    // 3 inefficient algorithms O(n^2)
    public void bubbleSort(int[] arr) {
        boolean isSorted;
        for (var i = 0; i < arr.length; i++) {
            isSorted = true;
            for (var j = 1; j < arr.length - i; j++) { // comparison
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                    isSorted = false;
                }
            }
            if (isSorted)
                return;
        }
    }

    public void selectionSort(int[] arr) {
        for (var i = 0; i < arr.length; i++) {
            var minValue = i;
            for (var j = i + 1; j < arr.length; j++) // this loop to search for min value
                if (arr[j] < arr[minValue])
                    minValue = j;
            if (minValue != i)
                swap(arr, minValue, i);
        }
    }

    public void insertionSort(int[] arr) {
        for (var i = 0; i < arr.length; i++) {
            var current = arr[i];
            var j = i - 1;
            while (j >= 0 && arr[j] > current) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = current; // look at condition
        }
    }

    // efficient algorithms

    // Not In-Place Merging
    public void mergeSort(int[] arr) { // divide&conquer
        // base condition
        if (arr.length < 2)
            return;
        // divide each into half
        var middle = arr.length / 2;

        int[] left = new int[middle];
        for (var i = 0; i < middle; i++)
            left[i] = arr[i];

        int[] right = new int[arr.length - middle];
        for (var i = middle; i < arr.length; i++)
            right[i - middle] = arr[i];

        mergeSort(left);
        mergeSort(right);

        // sort & merge result
        merge(arr, left, right);
    }

    private void merge(int[] result, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j])
                result[k++] = left[i++];
            else
                result[k++] = right[j++];
        }

        while (i < left.length)
            result[k++] = left[i++];

        while (j < right.length)
            result[k++] = right[j++];

    }

    // In-Place Merging
    public void inplaceMergeSort(int[] arr, int left, int right) {
        if (left < right) { // base condition

            var mid = left + (right - left) / 2; // prevent overflow

            inplaceMergeSort(arr, left, mid);
            inplaceMergeSort(arr, mid + 1, right);

            inplaceMerging(arr, left, mid, right);

        }

    }

    private void inplaceMerging(int[] arr, int left, int mid, int right) {
        var n1 = mid - left + 1;
        var n2 = right - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (var i = 0; i < n1; i++)
            leftArray[i] = arr[left + i];
        for (var i = 0; i < n2; i++)
            rightArray[i] = arr[mid + 1 + i];

        int i = 0, j = 0, k = left;

        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j])
                arr[k++] = leftArray[i++];
            else
                arr[k++] = rightArray[j++];
        }

        while (i < leftArray.length)
            arr[k++] = leftArray[i++];

        while (j < rightArray.length)
            arr[k++] = rightArray[j++];

    }
    // so difficult - sonnet3.5
    // public void inplaceMergeSort(int[] arr, int left, int right) {
    // if (left < right) {
    // int mid = left + (right - left) / 2;
    // inplaceMergeSort(arr, left, mid);
    // inplaceMergeSort(arr, mid + 1, right);
    // inplaceMerging(arr, left, mid, right);
    // }
    // }

    // private void inplaceMerging(int[] arr, int left, int mid, int right) {
    // int start2 = mid + 1;

    // // If the direct merge is already sorted
    // if (arr[mid] <= arr[start2]) {
    // return;
    // }

    // // Two pointers to maintain start of both arrays to merge
    // while (left <= mid && start2 <= right) {
    // // If element 1 is in right place
    // if (arr[left] <= arr[start2]) {
    // left++;
    // } else {
    // int value = arr[start2];
    // int index = start2;

    // // Shift all the elements between element 1
    // // element 2, right by 1.
    // while (index != left) {
    // arr[index] = arr[index - 1];
    // index--;
    // }
    // arr[left] = value;

    // // Update all the pointers
    // left++;
    // mid++;
    // start2++;
    // }
    // }
    // }

    public void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int start, int end) {
        if (start >= end)
            return;
        var boundary = partition(arr, start, end);
        quickSort(arr, start, boundary - 1);
        quickSort(arr, boundary + 1, end);
    }

    private int partition(int[] arr, int start, int end) {
        // var pivot = arr[arr.length-1];
        // var boundary = -1;
        var pivot = arr[end];
        var boundary = start - 1;

        // for (var i = 0; i < arr.length; i++)
        for (var i = start; i <= end; i++) {
            if (arr[i] <= pivot) {
                swap(arr, i, ++boundary);
            }
        }
        return boundary;
    }

    public void countingSort(int[] arr, int max) {
        int[] counts = new int[max + 1];
        for (var item : arr)
            counts[item]++;

        var k = 0;
        for (var i = 0; i < counts.length; i++)
            for (var j = 0; j < counts[i]; j++)
                arr[k++] = i;
    }

    public void bucketSort(int[] arr, int bucketsNo) {
        var i = 0;
        for (var bucket : createBuckets(arr, bucketsNo)) {
            Collections.sort(bucket); // quicksort
            for (var item : bucket)
                arr[i++] = item;
        }
    }

    // single responsibilty
    private List<List<Integer>> createBuckets(int[] arr, int bucketsNo) {

        List<List<Integer>> buckets = new ArrayList<>();
        // intialization of buckets
        for (var i = 0; i < bucketsNo; i++)
            buckets.add(new ArrayList<>());

        for (var item : arr)
            buckets.get(item / bucketsNo).add(item);

        return buckets;
    }

    public void swap(int[] arr, int first, int second) {
        var temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
