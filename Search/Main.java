package Search;

public class Main {
    public static void main(String[] args) {
        // int[] numbers = { 7, 1, 3, 6, 5 };
        // var search = new Search();
        // var index = search.linearSearch(numbers, 30);
        // System.out.println(index);

        // int[] numbers = { 1, 3, 5, 6, 7 };
        // var search = new Search();
        // var index = search.binarySearchRec(numbers, 60);
        // var index = search.binarySearch(numbers, 70);
        // var index = search.ternarySearch(numbers, 7);
        // var index = search.jumpSearch(numbers, 7);
        // System.out.println(index);

        int[] numbers = { 3, 5, 6, 9, 11, 18, 20, 21, 24, 30 };
        var search = new Search();
        var index = search.exponentialSearch(numbers, 30);
        System.out.println(index);

    }
}
