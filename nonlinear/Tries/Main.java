package nonlinear.Tries;

public class Main {

    public static void main(String[] args) {
        // var trie = new Trie();
        // trie.insert("car");
        // trie.insert("card");
        // trie.insert("canada");
        // System.out.println(trie.containsRecursive("ca"));
        // trie.traverse();
        // trie.insert("care");
        // trie.insert("careful");
        // trie.insert("egg");
        // trie.remove(null);
        // System.out.println(trie.contains("car"));
        // System.out.println(trie.contains("care"));
        // var words = trie.autoComplete("c");
        // System.out.println(words);
        // System.out.println(trie.countWords());
        // System.out.println(trie.countWordsUsingStacks());
        // trie.printWords();
        // String[] words = { "can", "canada", "care", "cab" };
        String[] words = { "can", "canada" };
        System.out.println(Trie.longestCommonPrefix(words));
    }
}
