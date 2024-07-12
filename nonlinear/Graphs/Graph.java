package nonlinear.Graphs;

import java.util.*;

public class Graph {
    private class Node {
        private final String label;

        public Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() { // when java converts source or node to string it should print value of node
            return label;
        }
    }

    // private List<Node> nodes = new ArrayList<>();
    private final Map<String, Node> nodes = new HashMap<>();

    private final Map<Node, List<Node>> adjacencyList = new HashMap<>();

    public void addNode(String label) { // addVertex
        var node = new Node(label);
        nodes.putIfAbsent(label, node);
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(String from, String to) {
        var fromNode = nodes.get(from);
        if (fromNode == null)
            throw new IllegalArgumentException();
        var toNode = nodes.get(to);
        if (toNode == null)
            throw new IllegalArgumentException();

        adjacencyList.get(fromNode).add(toNode); // check fromNode for null if adjancencyList not initiated in addNode
        // adjacencyList.get(toNode).add(fromNode);
    }

    public void print() {
        for (var source : adjacencyList.keySet()) {
            var targets = adjacencyList.get(source); // we get a list object of nodes
            if (!targets.isEmpty())
                System.out.println(source + " -> " + targets);
        }
    }

    public void removeNode(String label) {
        var node = nodes.get(label);
        if (node == null)
            return;
        for (var n : adjacencyList.keySet())
            adjacencyList.get(n).remove(node);
        adjacencyList.remove(node);
        nodes.remove(label);
    }

    public void removeEdge(String from, String to) {
        var fromNode = nodes.get(from);
        var toNode = nodes.get(to);
        if (fromNode == null || toNode == null)
            return;

        adjacencyList.get(fromNode).remove(toNode);
    }

    // get node
    // print it and add it to visited set so we don't visit it again
    // loop on this node to get its neighbours/children

    public void traverseDepthFirstRec(String label) {
        var node = nodes.get(label);
        if (node == null)
            return;
        traverseDepthFirstRec(node, new HashSet<>());
    }

    private void traverseDepthFirstRec(Node root, Set<Node> visited) {
        System.out.println(root);
        visited.add(root);

        for (var node : adjacencyList.get(root))
            if (!visited.contains(node))
                traverseDepthFirstRec(node, visited);
    }

    public void traverseDepthFirst(String label) { // we need visited set and stack to get children
        var node = nodes.get(label);
        if (node == null)
            return;

        Set<Node> visited = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            var current = stack.pop();
            if (visited.contains(current))
                continue;
            System.out.println(current);
            visited.add(current);

            for (var n : adjacencyList.get(current)) {
                if (!visited.contains(n))
                    stack.push(n);
            }
        }
    }

    public void traverseBreadthFirst(String label) { // we need visited set and queue to get neighbours
        var node = nodes.get(label);
        if (node == null)
            return;
        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            var current = queue.remove();
            if (visited.contains(current))
                continue;
            System.out.println(current);
            visited.add(current);

            for (var neighbour : adjacencyList.get(current)) {
                if (!visited.contains(neighbour))
                    queue.add(neighbour);
            }
        }
    }

    public List<String> topologicalSort() {
        Set<Node> visited = new HashSet<>();
        Stack<Node> stack = new Stack<>();

        for (var node : nodes.values())
            topologicalSort(node, visited, stack);

        List<String> sorted = new ArrayList<>();
        while (!stack.isEmpty())
            sorted.add(stack.pop().label);

        return sorted;
    }

    private void topologicalSort(Node node, Set<Node> visited, Stack<Node> stack) {
        if (visited.contains(node))
            return;

        visited.add(node);
        for (var n : adjacencyList.get(node))
            topologicalSort(n, visited, stack);

        stack.push(node);
    }

    public boolean hasCycle() {
        Set<Node> all = new HashSet<>();
        Set<Node> visiting = new HashSet<>();
        Set<Node> visited = new HashSet<>();

        all.addAll(nodes.values());

        while (!all.isEmpty()) {
            // var current = all.toArray(new Node[0])[0]; //instead of returning array of
            // objects, it returns array of node objects
            var current = all.iterator().next();
            if (hasCycle(current, all, visiting, visited))
                return true;
        }
        return false;
    }

    private boolean hasCycle(Node node, Set<Node> all, Set<Node> visiting, Set<Node> visited) {
        all.remove(node);
        visiting.add(node);
        for (var n : adjacencyList.get(node)) {
            if (visited.contains(n))
                continue;
            if (visiting.contains(n))
                return true;
            if (hasCycle(n, all, visiting, visited))
                return true;
        }
        visiting.remove(node);
        visited.add(node);
        return false;
    }
}
