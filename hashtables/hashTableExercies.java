package hashtables;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class hashTableExercies {
    public static int mostFrequent(int[] numbers) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int number : numbers) {
            var count = map.getOrDefault(number, 0);
            map.put(number, count + 1);
        }

        int max = -1;
        int result = numbers[0];
        for (var item : map.entrySet()) {
            if (item.getValue() > max) {
                max = item.getValue();
                result = item.getKey();
            }
        }
        return result;

    }

    public static int countPairsWithDiff(int[] numbers, int diff) { // working between array and set
        Set<Integer> set = new HashSet<>();
        for (int number : numbers)
            set.add(number);
        int count = 0;
        for (var number : numbers) {
            if (set.contains(number - diff))
                count++;
            if (set.contains(number + diff))
                count++;
            set.remove(number);
        }
        return count;
    }

    public static int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int number = target - numbers[i];
            if (map.containsKey(number)) {
                return new int[] { map.get(number), i };
            }
            map.put(numbers[i], i);
        }
        return null;
    }

}

// 1-
// Find the
// most repeated
// element in
// an array
// of integers.
// What is
// the
// time
// complexity of this method?(A variation of this
// exercise is
// finding
// the
// most repeated
// word in
// a sentence.
// The algorithm
// is the
// same.Here we
// use an
// array of numbers for simplicity.)Input:[1,2,2,3,3,3,4]Output:3
// Solution:HashTableExercises.mostFrequent()

// 2-
// Given an
// array of integers,
// count the
// number of
// unique pairs
// of integers
// that have
// difference k.Input:[1,7,5,9,2,12,3]K=2 Output:4
// We have
// four pairs
// with difference 2:(1,3),(3,5),(5,7),(7,9).
// Note that
// we only
// want the
// number of
// these pairs, not
// the pairs themselves.Solution:HashTableExercises.countPairsWithDiff()

// 3-
// Given an
// array of integers,return
// indices of
// the two
// numbers such
// that they
// add up
// to a
// specific target.Input:[2,7,11,15]-target=9 Output:[0,1](because 2+7=9)
// Assume that
// each input
// has exactly
// one solution, and
// you may
// not use
// the same
// element twice.Solution:HashTableExercises.twoSum()