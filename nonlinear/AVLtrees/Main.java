package nonlinear.AVLtrees;

public class Main {
    public static void main(String[] args) {
        var tree = new AVLTrees();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.printTree();
    }
}
