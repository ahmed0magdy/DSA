package nonlinear.trees;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(7);
        tree.insert(4);
        tree.insert(9);
        tree.insert(1);
        tree.insert(6);
        tree.insert(8);
        tree.insert(10);
        // Tree tree2 = new Tree();
        // tree2.insert(7);
        // tree2.insert(4);
        // tree2.insert(9);
        // tree2.insert(1);
        // tree2.insert(6);
        // tree2.insert(8);
        // tree2.insert(10);
        System.out.println(tree.find(10));
        // tree.traversePreOrder();
        // System.out.println(tree.height());
        // System.out.println(tree.minBST());
        // System.out.println(tree.equals(null));
        // tree.swapRoot();
        // System.out.println(tree.isBst());
        // System.out.println(factorial(4));
        // tree.printNodesAtDistance(2);
        // System.out.println(tree.getNodesAtDistance(2));
        // tree.traverseLevelOrder();
        // System.out.println(tree.size());
        // System.out.println(tree.countLeaves());
        // System.out.println(tree.max());
        // System.out.println(tree.contains(0));
        // System.out.println(tree.areSibling(4, 9));
        // System.out.println(tree.getAncestors(10));
        // System.out.println(tree.isBalanced());
        // System.out.println(tree.isPerfect());
    }

    // public static int factorial(int n) { // 4! = 4 * 3*2*1 //3! = 3*2*1 //n! = n
    // * (n-1)!
    // // base condition
    // if (n == 0)
    // return 1;
    // return n * factorial(n - 1);

    // }

    // public static int factorial(int n) { // 4! = 4 * 3*2*1 //3! = 3*2*1
    // var factorial = 1;

    // for (int i = n; i > 1; i--)
    // factorial *= i;
    // return factorial;

    // }
}
