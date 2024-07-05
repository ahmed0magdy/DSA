package nonlinear.Tries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Trie {

    // public static int ALPHABEt_SIZE = 26;
    private class Node {

        private final char value;
        // private Node[] children = new Node[ALPHABEt_SIZE];
        private final HashMap<Character, Node> children = new HashMap<>();
        private boolean isEndOfWord;

        public Node(char value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "value= " + value;
        }

        public boolean hasChild(char ch) {
            return children.containsKey(ch);
        }

        public void addChild(char ch) {
            children.put(ch, new Node(ch));
        }

        public Node getChild(char ch) {
            return children.get(ch);
        }

        public Node[] getChildren() {
            return children.values().toArray(new Node[0]);
        }

        public boolean hasChildren() {
            return !children.isEmpty();
        }

        public void removeChild(char ch) {
            children.remove(ch);
        }

    }

    private final Node root = new Node(' ');

    public void insert(String word) {
        var current = root;
        for (var ch : word.toCharArray()) {
            // array
            // var index = ch - 'a';
            // if (current.children[index] == null) {
            // current.children[index] = new Node(ch);
            // }
            // current = current.children[index];
            // }
            // hashtable
            // if (!current.children.containsKey(ch)) {
            // current.children.put(ch, new Node(ch));
            // }
            // current = current.children.get(ch);
            // }
            // abstraction
            if (!current.hasChild(ch)) {
                current.addChild(ch);
            }
            current = current.getChild(ch);
        }
        current.isEndOfWord = true;
    }

    public boolean contains(String word) {
        if (word == null) {
            return false;
        }
        var current = root;
        for (var ch : word.toCharArray()) {
            if (!current.hasChild(ch)) {
                return false;
            }
            current = current.getChild(ch);
        }
        return current.isEndOfWord;
    }

    public void traverse() {
        traverse(root);
    }

    private void traverse(Node root) {
        // pre-order traverse
        // used to print a word
        // System.out.println(root.value);
        // for (var child : root.getChildren()) {
        // traverse(child);
        // }

        // Post-order traverse
        // used to delete a word
        for (var child : root.getChildren()) {
            traverse(child);
        }
        System.out.println(root.value);
    }

    public void remove(String word) {
        if (word == null) {
            return;
        }
        remove(root, word, 0);
    }

    private void remove(Node root, String word, int index) { // post-order traverse
        if (word.length() == index) {
            root.isEndOfWord = false;
            return;
        }
        var ch = word.charAt(index);
        var child = root.getChild(ch);
        if (child == null) {
            return;
        }
        remove(child, word, index + 1);
        // child.getChildren.length ==0
        if (!child.hasChildren() && !child.isEndOfWord) {
            root.removeChild(ch);
        }
    }

    public List<String> autoComplete(String prefix) {
        List<String> words = new ArrayList<>();
        var lastNode = findLasNode(prefix);
        autoComplete(lastNode, prefix, words);
        return words;
    }

    private void autoComplete(Node root, String prefix, List<String> words) {
        if (root == null)
            return;
        if (root.isEndOfWord)
            words.add(prefix);

        for (var child : root.getChildren())
            autoComplete(child, prefix + child.value, words);
    }

    private Node findLasNode(String prefix) {
        if (prefix == null)
            return null;

        var current = root;
        for (var ch : prefix.toCharArray()) {
            var child = current.getChild(ch);
            if (child == null)
                return null;
            current = child;
        }
        return current;
    }

    public boolean containsRecursive(String word) {
        if (word == null)
            return false;
        return containsRecursive(root, word, 0);
    }

    private boolean containsRecursive(Node root, String word, int index) {
        if (word.length() == index)
            return root.isEndOfWord;
        if (root == null)
            return false;
        var ch = word.charAt(index);
        var child = root.getChild(ch);
        if (child == null)
            return false;
        return containsRecursive(child, word, index + 1);
    }

    public int countWords() {
        return countWords(root);
    }

    private int countWords(Node root) {
        var total = 0;
        if (root.isEndOfWord)
            total++;
        for (var child : root.getChildren())
            total += countWords(child);

        return total;
    }

    public int countWordsUsingStacks() {
        int total = 0;
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            if (current.isEndOfWord)
                total++;

            // Push all children of the current node to the stack
            for (Node child : current.getChildren()) {
                stack.push(child);
            }
        }

        return total;
    }

    public void printWords() {
        printWords(root, "");
    }

    private void printWords(Node root, String word) {
        if (root.isEndOfWord)
            System.out.println(word);

        for (var child : root.getChildren())
            printWords(child, word + child.value);
    }

    // 1.we keep walking down the tree as long as the current node has only one
    // child.
    // 2.The maximum number of characters we can include in the prefix should be
    // equal to the length of the shortest word.
    public static String longestCommonPrefix(String[] words) {
        if (words == null)
            return "";

        var trie = new Trie();
        for (var word : words)
            trie.insert(word);
        var prefix = new StringBuffer();
        var maxPrefix = getShortest(words).length();
        var current = trie.root;
        // while (current != null) {
        while (prefix.length() < maxPrefix) {
            var children = current.getChildren();
            if (children.length != 1)
                break;
            current = children[0];
            prefix.append(current.value);
        }

        return prefix.toString();
    }

    private static String getShortest(String[] words) {
        if (words.length == 0)
            return "";
        var shortest = words[0];
        for (var i = 0; i > words.length; i++) {
            if (words.length < shortest.length())
                shortest = words[i];
        }
        return shortest;
    }
}

// 1- Implement the contains method recursively. Compare the iterative
// and recursive solutions.
// 2- Count the number of words in a trie.
// 3- Given an array of strings, find the longest common prefix. Test your
// algorithm against these test cases.
// Input: [“card”, “care”]
// Output: “car”
// Input: [“car”, “care”]
// Output: “car”
// Input: [“car”, “dog”]
// Output: “”
// Input: [“car”]
// Output: “car”
