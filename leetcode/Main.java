package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        var sol = new Solution();
        String[] s = { "[(])", "([{}])", "(]", "[]" };
        for (String w : s)
            System.out.println(sol.isValid(w));

    }
}

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> CloseOpen = new HashMap<>();
        CloseOpen.put(']', '[');
        CloseOpen.put(')', '(');
        CloseOpen.put('}', '{');

        for (char c : s.toCharArray()) {
            if (CloseOpen.containsKey(c)) {
                if (!stack.isEmpty() && stack.peek() == CloseOpen.get(c))
                    stack.pop();
                else
                    return false;
            } else
                stack.push(c);
        }
        return stack.isEmpty();
    }
}