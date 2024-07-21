package Search;

public class Search {
    public int linearSearch(int[] arr, int target) {
        for (var i = 0; i < arr.length; i++)
            if (arr[i] == target)
                return i;
        return -1;
    }

    public int binarySearchRec(int[] arr, int target) {
        return binarySearchRec(arr, target, 0, arr.length - 1);
    }

    private int binarySearchRec(int[] arr, int target, int left, int right) {
        if (left > right)
            return -1;
        var middle = left + (right - left) / 2;
        if (arr[middle] == target)
            return middle;

        if (target < arr[middle])
            return binarySearchRec(arr, target, left, middle - 1);

        return binarySearchRec(arr, target, middle + 1, right);
    }

    public int binarySearch(int[] arr, int target) {
        // pointers
        var left = 0;
        var right = arr.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (arr[middle] == target)
                return middle;
            if (target < arr[middle])
                right = middle - 1;
            else
                left = middle + 1;
        }
        return -1;
    }

    public int ternarySearch(int[] arr, int target) {
        return ternarySearch(arr, target, 0, arr.length - 1);
    }

    // Iterative Approach:For large arrays or deep recursion, consider an iterative
    // approach to avoid potential stack overflow errors.
    private int ternarySearch(int[] arr, int target, int left, int right) {
        if (left > right)
            return -1;

        var partitionSize = (right - left) / 3;
        var mid1 = left + partitionSize;
        var mid2 = right - partitionSize;

        if (target == arr[mid1])
            return mid1;
        if (target == arr[mid2])
            return mid2;

        if (target < arr[mid1])
            return ternarySearch(arr, target, left, mid1 - 1);
        if (target > arr[mid2])
            return ternarySearch(arr, target, mid2 + 1, right);

        return ternarySearch(arr, target, mid1 + 1, mid2 - 1);
    }

    public int jumpSearch(int[] arr, int target) {
        var blockSize = (int) Math.sqrt(arr.length); // returns double
        var start = 0;
        var next = blockSize;

        while (start < arr.length && target > arr[next - 1]) { // Math.min(next, arr.length) - 1
            start = next;
            // if(start >= arr.length)
            // break;
            next += blockSize;
            if (next > arr.length)
                next = arr.length;
        }

        for (var i = start; i < next; i++) { // Math.min(next, arr.length) - 1
            if (arr[i] == target)
                return i;
        }
        return -1;
    }

    public int exponentialSearch(int[] arr, int target) {
        var bound = 1;
        while (bound < arr.length && arr[bound] < target)
            bound *= 2;

        return binarySearchRec(arr, target, bound / 2, Math.min(bound, arr.length - 1));
    }
}
