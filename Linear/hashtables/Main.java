package Linear.hashtables;

public class Main {
    public static void main(String[] args) {
        int[] numbers1 = { 1, 2, 2, 3, 3, 3, 4 };
        int[] numbers2 = { 1, 7, 5, 9, 2, 12, 3 };
        int[] numbers3 = { 2, 7, 11, 15 };

        System.out.println(hashTableExercies.mostFrequent(numbers1));
        System.out.println(hashTableExercies.countPairsWithDiff(numbers2, 2));
        int[] result = hashTableExercies.twoSum(numbers3, 9);
        System.out.println("Indices: " + result[0] + ", " + result[1]);
        // HashMap table = new HashMap(5);
        // table.put(6, "A+"); // 1
        // table.put(8, "B"); // 3
        // table.put(11, "c"); // 1 //collision
        // table.remove(6);
        // System.out.println(table.get(11));
        // System.out.println(table);

        // hashTable table = new hashTable(5);
        // table.put(6, "A+"); // 1
        // table.put(8, "B"); // 3
        // table.put(11, "c"); // 1 //collision
        // table.remove(6);
        // System.out.println(table.get(1));

        // System.out.println(hash("123456-AH"));
        // charFinder finder = new charFinder();
        // var ch = finder.FindFirstUnRepeatedChar("a green apple");
        // System.out.println(ch);

        // charFinder finder = new charFinder();
        // var ch = finder.FindFirstRepeatedChar("a green apple");
        // System.out.println(ch);

    }

    public static int hash(String str) { // return index value [address]
        int hash = 0;
        for (var ch : str.toCharArray())
            hash += ch; // implicit casting

        return hash % 100;
    }
}
