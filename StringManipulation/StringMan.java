package StringManipulation;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class StringMan {
    // String utility methods
    public static int countVowels(String str) {
        if (str == null)
            return 0;
        String vowels = "aeiou"; // can use set instead of string can make the vowel-checking process more
                                 // efficient.
        var count = 0;
        for (var ch : str.toLowerCase().toCharArray())
            if (vowels.indexOf(ch) != -1) // vowels.contains(Character.toString(ch)) //only for java
                count++;
        // str = str.toLowerCase();
        // for (int i = 0; i < str.length(); i++)
        // if (vowels.indexOf(str.charAt(i)) != -1)
        // count++;
        return count;
    }

    public static String reverse(String str) { // StringReverser in stack lesson
        if (str == null)
            return "";
        // String reversed = "";
        // for (var i = str.length() - 1; i >= 0; i--) { // O(n)
        // reversed += str.charAt(i); // O(n) cuz string immutable
        // }
        // return reversed;

        StringBuilder reversed = new StringBuilder();
        for (var i = str.length() - 1; i >= 0; i--) // O(n)
            reversed.append(str.charAt(i)); // O(1)

        return reversed.toString();
    }

    public static String reverseWords(String sentence) { // can also use stack
        if (sentence == null)
            return "";
        String[] words = sentence.trim().split(" ");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);

        // StringBuilder reversed = new StringBuilder();
        // for (var i = words.length - 1; i >= 0; i--)
        // reversed.append(words[i] + " ");

        // return reversed.toString().trim();
    }

    public static boolean areRotations(String str1, String str2) {
        // if (str1 == null || str2 == null)
        // return false;

        // return (str1.length() == str2.length() && (str1 + str1).contains(str2));

        // another sol using two pointers to iterate through str1 and str2. The idea is
        // to find a starting point in str1 that matches the first character of str2.
        // From there, we check if all subsequent characters in str1 (considering
        // wrap-around) match the characters in str2.

        // more useful if string is million characters

        if (str1 == null || str2 == null || str1.length() != str2.length())
            return false;

        var len = str1.length();
        for (var i = 0; i < len; i++) {
            var match = true;
            for (var j = 0; j < len; j++) {
                if (str1.charAt((i + j) % len) != str2.charAt(j)) {
                    match = false;
                    break;
                }
            }
            if (match)
                return true;
        }
        return false;
        // https://chatgpt.com/share/fef0261a-05f3-45fb-93e3-f38e156dc51d
    }

    public static String removeDuplicates(String str) {
        if (str == null)
            return "";

        StringBuilder output = new StringBuilder();
        Set<Character> seen = new HashSet<>();

        for (var ch : str.toCharArray()) {
            if (!seen.contains(ch)) {
                seen.add(ch);
                output.append(ch);
            }
        }
        return output.toString();
    }

    public static char getMaxOccuringChar(String str) {
        if (str == null || str.isEmpty())
            throw new IllegalArgumentException();

        final int ASCII_SIZE = 256;
        int[] frequencies = new int[ASCII_SIZE];
        for (var ch : str.toCharArray())
            frequencies[ch]++;

        int max = 0;
        var result = ' ';
        for (var i = 0; i < frequencies.length; i++) {
            if (frequencies[i] > max) {
                max = frequencies[i];
                result = (char) i;
            }
        }
        return result;
        // Map<Character, Integer> frequencies = new HashMap<>(); //using HashMap
        // for (var ch : str.toCharArray()) {
        // // frequencies.put(ch, frequencies.getOrDefault(ch, 0) + 1);
        // if (frequencies.containsKey(ch))
        // frequencies.replace(ch, frequencies.get(ch) + 1);
        // else
        // frequencies.put(ch, 1);
        // }
        // var max = -1;
        // char result = ' ';
        // for (Map.Entry<Character, Integer> item : frequencies.entrySet()) {
        // if (item.getValue() > max) {
        // max = item.getValue();
        // result = item.getKey();
        // }
        // }
        // return result;
    }

    public static String capitilize(String sentence) {
        if (sentence == null || sentence.trim().isEmpty())
            return "";

        String[] words = sentence.trim().replace(" +", " ").split(" "); // trim before, inbetween and after sentence
        for (var i = 0; i < words.length; i++) {
            words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase();
        }

        return String.join(" ", words);
    }

    public static boolean areAnagrams(String first, String second) { // O(nlogn)
        if (first == null || second == null || first.length() != second.length()) // string length is O(1) operation
            return false;
        // ['A', 'B', 'C', 'D']
        // O(n)
        var arr1 = first.toLowerCase().toCharArray();
        // O(nlogn) quicksort
        Arrays.sort(arr1);

        var arr2 = second.toLowerCase().toCharArray();
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }

    public static boolean areAnagrams2(String first, String second) {// O(n) histograms //use hashMap or Integer array
        if (first == null || second == null || first.length() != second.length())
            return false;

        final int ENGLISH_ALPHABET = 26;
        int[] frequencies = new int[ENGLISH_ALPHABET];

        first = first.toLowerCase();
        for (var i = 0; i < first.length(); i++)
            frequencies[first.charAt(i) - 'a']++; // unique index
        // we can alse count frq in second and compare two frqs for equality
        second = second.toLowerCase();
        for (var i = 0; i < second.length(); i++) {
            if (frequencies[second.charAt(i) - 'a'] == 0)
                return false;

            frequencies[second.charAt(i) - 'a']--;
        }

        return true;
    }

    public static boolean isPalindrome(String word) {
        if (word == null)
            return false;

        // 4 iterations soln for small strings
        // var input = new StringBuilder(word);
        // input.reverse();
        // return input.toString().equals(word);

        var left = 0;
        var right = word.length() - 1;
        while (left < right)
            if (word.charAt(left++) != word.charAt(right--))
                return false;

        return true;
    }
}
