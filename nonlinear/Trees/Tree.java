package nonlinear.Trees;

import java.util.ArrayList;

public class Tree {

    private class Node {

        private final int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node+" + value;
        }
    }

    private Node root;

    public void insert(int value) {
        var node = new Node(value);
        if (root == null) {
            root = node;
            return;
        }

        var current = root;
        while (true) {
            if (value < current.value) {
                if (current.leftChild == null) {
                    current.leftChild = node;
                    break;
                }
                current = current.leftChild;
            } else {
                if (current.rightChild == null) {
                    current.rightChild = node;
                    break;
                }
                current = current.rightChild;
            }
        }
    }

    public boolean find(int value) {
        var current = root;
        while (current != null) {
            if (value < current.value) {
                current = current.leftChild;
            } else if (value > current.value) {
                current = current.rightChild;
            } else {
                return true;
            }

        }
        return false;
    }

    public void traversePreOrder() {
        traversePreOrder(root);
    }

    private void traversePreOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.value);
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }

    public void traverseInOrder() {
        traverseInOrder(root);
    }

    private void traverseInOrder(Node root) {
        if (root == null) {
            return;
        }
        traverseInOrder(root.leftChild);
        System.out.println(root.value);
        traverseInOrder(root.rightChild);
    }

    public void traversePostOrder() {
        traversePostOrder(root);
    }

    private void traversePostOrder(Node root) {
        if (root == null) {
            return;
        }
        traversePostOrder(root.leftChild);
        traversePostOrder(root.rightChild);
        System.out.println(root.value);
    }

    public int height() {
        return height(root);
    }

    private int height(Node root) { // post order traversal
        if (root == null) {
            return -1;
        }
        if (IsLeaf(root)) {
            return 0;
        }
        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }

    private boolean IsLeaf(Node root) { // can i remove root parameter? bec it works!!
        return root.leftChild == null && root.rightChild == null;
    }

    public int min() {
        return min(root);
    }

    // O(n)
    private int min(Node root) { // post order traversal // binary tree not BST
        if (IsLeaf(root)) {
            return root.value;
        }
        var left = min(root.leftChild);
        var right = min(root.rightChild);

        return Math.min(Math.min(left, right), root.value);
    }

    // O(logn)
    public int minBST() {
        if (root == null) {
            throw new IllegalStateException();
        }
        var current = root;
        var last = current; // pointer
        while (current != null) {
            last = current;
            current = current.leftChild; // if max => rightchild
        }
        return last.value;
    }

    public boolean equals(Tree other) {
        if (other == null) {
            return false;
        }
        return equals(root, other.root);
    }

    private boolean equals(Node root, Node secondRoot) { // preorder traversal
        if (root == null && secondRoot == null) {
            return true;
        }

        if (root != null && secondRoot != null) {
            return root.value == secondRoot.value && equals(root.leftChild, secondRoot.leftChild)
                    && equals(root.rightChild, secondRoot.rightChild);
        }

        return false;
    }

    public boolean isBst() {
        return isBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBst(Node root, int min, int max) {// preorder traversal
        if (root == null) {
            return true;
        }
        if (root.value < min || root.value > max) {
            return false;
        }

        return isBst(root.leftChild, min, root.value - 1) && isBst(root.rightChild, root.value + 1, max);
    }

    public void swapRoot() {
        var temp = root.leftChild;
        root.leftChild = root.rightChild;
        root.rightChild = temp;
    }

    public void printNodesAtDistance(int distance) {
        printNodesAtDistance(root, distance);
    }

    private void printNodesAtDistance(Node root, int distance) {
        if (root == null) {
            return;
        }
        if (distance == 0) {
            System.out.println(root.value);
            return;
        }

        printNodesAtDistance(root.leftChild, distance - 1);
        printNodesAtDistance(root.rightChild, distance - 1);
    }

    public ArrayList<Integer> getNodesAtDistance(int distance) {
        ArrayList<Integer> list = new ArrayList<>();
        // var list = new ArrayList<Integer>();
        getNodesAtDistance(root, distance, list);
        return list;
    }

    private void getNodesAtDistance(Node root, int distance, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        if (distance == 0) {
            list.add(root.value);
            return;
        }

        getNodesAtDistance(root.leftChild, distance - 1, list);
        getNodesAtDistance(root.rightChild, distance - 1, list);
    }

    public void traverseLevelOrder() {
        for (int i = 0; i <= height(); i++) {
            System.out.println(getNodesAtDistance(i));
        }
    }

    // public void traverseLevelOrder() { //his solution
    // for (var i = 0; i <= height(); i++) {
    // for (var value : getNodesAtDistance(i))
    // System.out.println(value);
    // }
    // }

    public int size() {
        return size(root);
    }

    private int size(Node node) { // number of nodes
        if (node == null) {
            return 0;
        }
        return 1 + size(node.leftChild) + size(node.rightChild);
    }

    public int countLeaves() {
        return countLeaves(root);
    }

    private int countLeaves(Node root) {
        if (root == null) {
            return 0;
        }
        if (IsLeaf(root)) {
            return 1;
        }
        return countLeaves(root.leftChild) + countLeaves(root.rightChild);
    }

    public int max() {
        return max(root);
    }

    private int max(Node root) {
        if (root == null) {
            throw new IllegalStateException();
        }
        if (root.rightChild == null) {
            return root.value;
        }
        return max(root.rightChild);
    }

    public boolean contains(int value) {
        return contains(root, value);
    }

    private boolean contains(Node root, int value) {
        if (root == null) {
            return false;
        }

        if (root.value == value) {
            return true;
        }

        return contains(root.leftChild, value) || contains(root.rightChild, value);
    }

    public boolean areSibling(int first, int second) {
        return areSibling(root, first, second);
    }

    private boolean areSibling(Node root, int first, int second) {
        if (root == null) {
            return false;
        }

        var siblings = false;
        if (root.leftChild != null && root.rightChild != null) {
            siblings = (root.leftChild.value == first && root.rightChild.value == second)
                    || (root.rightChild.value == first && root.leftChild.value == second);
        }

        return siblings || areSibling(root.leftChild, first, second) || areSibling(root.rightChild, first, second);
    }

    public ArrayList<Integer> getAncestors(int value) {
        var list = new ArrayList<Integer>();
        getAncestors(root, value, list);
        return list;
    }

    private boolean getAncestors(Node root, int value, ArrayList<Integer> list) {
        if (root == null) {
            return false;
        }
        if (root.value == value) {
            return true;
        }

        if (getAncestors(root.leftChild, value, list) || getAncestors(root.rightChild, value, list)) {
            list.add(root.value);
            return true;
        }

        return false;
    }

    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node root) { // like idea of balance method in AVLTree
        if (root == null) {
            return true;
        }

        var balanceFactor = height(root.leftChild) - height(root.rightChild);
        return Math.abs(balanceFactor) <= 1 && isBalanced(root.leftChild) && isBalanced(root.rightChild);
    }

    public boolean isPerfect() {
        // there is another solution using depth of leftmost branch
        // Use a recursive function to ensure all nodes have two children and all leaves
        // are at the calculated depth.
        return size() == (Math.pow(2, height() + 1) - 1);
    }

}

// Check to see if a binary tree is perfect.In a perfect binary tree,every
// level (except the last level) is full of nodes.
// Hint: think about the relationship between the height and size of a
// binary tree.
