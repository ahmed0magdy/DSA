package hashtables;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

//a green apple
public class charFinder {
    public char FindFirstUnRepeatedChar(String str) {
        Map<Character, Integer> map = new HashMap<>();
        var chars = str.toCharArray();
        for (var ch : chars) {
            // if (map.containsKey(ch)) {
            // int count = map.get(ch);
            // System.out.println(count);
            // System.out.println(ch);
            // map.put(ch, count + 1);
            // } else {
            // map.put(ch, 1);
            // }
            var count = map.containsKey(ch) ? map.get(ch) : 0;
            map.put(ch, count + 1);
        }

        // System.out.println(map);
        for (var ch : chars) {
            if (map.get(ch) == 1)
                return ch;
        }
        return Character.MIN_VALUE;
    }

    // sets
    public char FindFirstRepeatedChar(String str) {
        Set<Character> set = new HashSet<>();
        for (var ch : str.toCharArray()) {
            if (set.contains(ch))
                return ch;

            set.add(ch);
        }
        return Character.MIN_VALUE;
    };
}
