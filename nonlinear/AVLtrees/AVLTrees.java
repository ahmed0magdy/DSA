package nonlinear.AVLtrees;

public class AVLTrees {

    private class AVLNode {

        private final int value;
        private int height;
        private AVLNode leftchild;
        private AVLNode rightchild;

        public AVLNode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "value:" + this.value;
        }

    }

    private AVLNode root; // every tree must have a reference to its root

    public void insert(int value) {
        root = insert(root, value);
    }

    private AVLNode insert(AVLNode root, int value) {
        if (root == null) {
            return new AVLNode(value);
        }

        if (value < root.value) {
            root.leftchild = insert(root.leftchild, value);
        } else {
            root.rightchild = insert(root.rightchild, value);
        }

        // root.height = 1 + Math.max(height(root.leftchild), height(root.rightchild));
        setHeight(root);

        // var balanceFactor = height(root.leftchild) - height(root.rightchild);
        // if (balanceFactor > 1)
        // System.out.println(root.value + " is Left heavy");
        // else if (balanceFactor < -1)
        // System.out.println(root.value + " is right heavy");

        // if (isLeftHeavy(root))
        // System.out.println(root.value + " is Left heavy");
        // else if (isRighttHeavy(root))
        // System.out.println(root.value + " is right heavy");

        return balance(root);
    }

    private AVLNode balance(AVLNode node) {
        if (isLeftHeavy(node)) {
            if (balanceFactor(node.leftchild) < 0)
                node.leftchild = leftRotate(node.leftchild);
            // System.out.println("leftRotate " + node.leftchild.value);
            return rightRotate(node);
            // System.out.println("rightRotate " + node.value);

        } else if (isRighttHeavy(node)) {
            if (balanceFactor(node.rightchild) > 0)
                node.rightchild = rightRotate(node.rightchild);
            // System.out.println("rightRotate " + node.rightchild.value);
            return leftRotate(node);
            // System.out.println("leftRotate " + node.value);
        }
        return node;
    }

    private AVLNode leftRotate(AVLNode root) {
        var newRoot = root.rightchild;
        root.rightchild = newRoot.leftchild;
        newRoot.leftchild = root;
        setHeight(root);
        setHeight(newRoot);
        return newRoot;
    }

    private AVLNode rightRotate(AVLNode root) {
        var newRoot = root.leftchild;
        root.leftchild = newRoot.rightchild;
        newRoot.rightchild = root;
        setHeight(root);
        setHeight(newRoot);
        return newRoot;
    }

    private boolean isLeftHeavy(AVLNode node) {
        return balanceFactor(node) > 1;

    }

    private boolean isRighttHeavy(AVLNode node) {
        return balanceFactor(node) < -1;

    }

    private int balanceFactor(AVLNode node) {
        return (node == null) ? 0 : (height(node.leftchild) - height(node.rightchild));
    }

    private void setHeight(AVLNode node) {
        node.height = 1 + Math.max(height(node.leftchild), height(node.rightchild));
    }
    // setHeight does not return any value (void return type). Instead, it directly
    // sets the height property of the node object. This method performs an action
    // that has a side effect on the node object, which is updating its height
    // attribute.
    // using return setHeight calculates the height of the node and returns the
    // computed value as an int. This method does not modify the node object itself;
    // it simply performs a calculation and returns the result. Callers of this
    // method would use the returned value for further computations or assignments.

    private int height(AVLNode node) {
        return (node == null) ? -1 : node.height;
    }

    public void printTree() {
        printTree(root);
    }

    private void printTree(AVLNode node) {
        if (node != null) {
            System.out.println(node); // Print node value
            printTree(node.leftchild); // Traverse left subtree
            printTree(node.rightchild); // Traverse right subtree
        }
    }
}

// 10
//// 20 (h=-1)
///// 30

// leftRotate(10)

// 10
///// 30 (1) balancefactor(root.rightchild) > 0
/// 20

// rightRotate(30)

// 10
//// 20
///// 30

// leftRotate(10)