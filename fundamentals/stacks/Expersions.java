
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Expersions {
    private final List<Character> leftBrackets = Arrays.asList('(', '[', '<', '{');
    private final List<Character> rightBrackets = Arrays.asList(')', ']', '>', '}');
    // private String input;

    // public Expersions(String input) {
    // this.input = input;
    // }

    private boolean isleftBrackets(char ch) {
        // var leftBrackets = Arrays.asList('(', '[', '<', '{');
        return leftBrackets.contains(ch);
        // return ch == '(' || ch == '[' || ch == '<' || ch == '{';
    }

    private boolean isrightBrackets(char ch) {
        // var rightBrackets = Arrays.asList(')', ']', '>', '}');
        return rightBrackets.contains(ch);
        // return ch == ')' || ch == ']' || ch == '>' || ch == '}';
    }

    private boolean checkBalanced(char open, char close) {
        return leftBrackets.indexOf(open) == rightBrackets.indexOf(close);
        // return (close == ')' && open != '(') ||
        // (close == ']' && open != '[') ||
        // (close == '>' && open != '<') ||
        // (close == '}' && open != '{');
    }

    public boolean isBalanced(String input) {
        Stack<Character> stack = new Stack<>();
        for (char ch : input.toCharArray()) {
            if (isleftBrackets(ch))
                stack.push(ch);
            else if (isrightBrackets(ch)) {
                if (stack.isEmpty())
                    return false;
                char top = stack.pop();
                if (!checkBalanced(ch, top))
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
