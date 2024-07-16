package nonlinear.Graphs;

import java.util.*;

public class WGraph {
    private class Node {
        private String label;
        private List<Edge> edges = new ArrayList<>(); // can also optimize to be a map of egdes to quickly check if node
                                                      // is connected to edge instead of iterate list

        public Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }

        public void addEdge(Node to, int weight) {
            edges.add(new Edge(this, to, weight));
        }

        public List<Edge> getEdges() {
            return edges;
            // return edges.values(); for hashtable implementation
        }
    }

    private class Edge {
        private Node from;
        private Node to;
        private int weight;

        public Edge(Node from, Node to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return from + " -> " + to;
        }
    }

    private Map<String, Node> nodes = new HashMap<>();
    // private Map<Node, List<Edge>> adjacencyList = new HashMap<>();

    public void addNode(String label) {
        // var node = new Node(label);
        nodes.putIfAbsent(label, new Node(label));
        // adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(String from, String to, int weight) {
        var fromNode = nodes.get(from);
        if (fromNode == null)
            throw new IllegalArgumentException();
        var toNode = nodes.get(to);
        if (toNode == null)
            throw new IllegalArgumentException();

        fromNode.addEdge(toNode, weight);
        toNode.addEdge(fromNode, weight);
        // adjacencyList.get(fromNode).add(new Edge(fromNode, toNode, weight));
        // adjacencyList.get(toNode).add(new Edge(toNode, fromNode, weight));
    }

    public void print() {
        for (var node : nodes.values()) {
            // var targets = node.edges;
            var edges = node.getEdges();
            if (!edges.isEmpty())
                System.out.println(node + " -> " + edges);
        }
        // for (var source : adjacencyList.keySet()) {
        // var targets = adjacencyList.get(source);
        // if (!targets.isEmpty())
        // System.out.println(source + " -> " + targets);
        // }
    }

    private class NodeEntry {
        private Node node;
        private int priority;

        public NodeEntry(Node node, int priority) {
            this.node = node;
            this.priority = priority;
        }
    }

    // Greedy Algorithm
    // Dijkstra's algorithm
    public int getShortestDistance(String from, String to) { // breadthFirst but with known order
        var fromNode = nodes.get(from);
        Map<Node, Integer> distances = new HashMap<>();
        for (var node : nodes.values())
            distances.put(node, Integer.MAX_VALUE);
        distances.replace(fromNode, 0);

        Set<Node> visited = new HashSet<>();

        PriorityQueue<NodeEntry> queue = new PriorityQueue<>(Comparator.comparingInt(ne -> ne.priority));
        queue.add(new NodeEntry(fromNode, 0));

        while (!queue.isEmpty()) {
            var current = queue.remove().node;
            visited.add(current);

            for (var edge : current.getEdges()) {
                if (visited.contains(edge.to))
                    continue;

                var newDistance = distances.get(current) + edge.weight;
                if (newDistance < distances.get(edge.to)) {
                    distances.replace(edge.to, newDistance);
                    queue.add(new NodeEntry(edge.to, newDistance));
                }
            }
        }

        return distances.get(nodes.get(to));
    }

    public Path getShortestPath(String from, String to) { // return Path object with serious of steps
        var fromNode = nodes.get(from);
        if (fromNode == null)
            throw new IllegalArgumentException();
        var toNode = nodes.get(to);
        if (toNode == null)
            throw new IllegalArgumentException();
        Map<Node, Integer> distances = new HashMap<>();
        for (var node : nodes.values())
            distances.put(node, Integer.MAX_VALUE);
        distances.replace(fromNode, 0);

        Map<Node, Node> previousNodes = new HashMap<>();

        Set<Node> visited = new HashSet<>();

        PriorityQueue<NodeEntry> queue = new PriorityQueue<>(Comparator.comparingInt(ne -> ne.priority));
        queue.add(new NodeEntry(fromNode, 0));

        while (!queue.isEmpty()) {
            var current = queue.remove().node;
            visited.add(current);

            for (var edge : current.getEdges()) {
                if (visited.contains(edge.to))
                    continue;

                var newDistance = distances.get(current) + edge.weight;
                if (newDistance < distances.get(edge.to)) {
                    distances.replace(edge.to, newDistance);
                    previousNodes.put(edge.to, current);
                    queue.add(new NodeEntry(edge.to, newDistance));
                }

            }
        }

        // Stack<Node> stack = new Stack<>();
        // stack.push(toNode);
        // var previous = previousNodes.get(toNode);
        // while (previous != null) {
        // stack.push(previous);
        // previous = previousNodes.get(previous);
        // }

        // var path = new Path();
        // while (!stack.isEmpty())
        // path.addNode(stack.pop().label);

        // return path;
        return buildPath(previousNodes, toNode);
    }

    private Path buildPath(Map<Node, Node> previousNodes, Node toNode) {
        Stack<Node> stack = new Stack<>();
        stack.push(toNode);
        var previous = previousNodes.get(toNode);
        while (previous != null) {
            stack.push(previous);
            previous = previousNodes.get(previous);
        }

        var path = new Path();
        while (!stack.isEmpty())
            path.addNode(stack.pop().label);

        return path;
    }

    public boolean hasCycle() { // depthFirst search
        Set<Node> visited = new HashSet<>();
        for (var node : nodes.values()) {
            if (!visited.contains(node) && hasCycle(visited, node, null))
                // if(hasCycle(visited, node, null))//too much nesting
                return true;
        }
        return false;
    }

    private boolean hasCycle(Set<Node> visited, Node node, Node parent) {
        visited.add(node);
        for (var edge : node.getEdges()) {
            if (edge.to == parent)
                continue;

            if (visited.contains(edge.to) || hasCycle(visited, edge.to, node))
                return true;
            // var result = hasCycle(visited, edge.to, node); //return boolean
            // if(result)
            // return true;
        }
        return false;
    }

    // Greedy ALgorithm
    // Prim's Algorithm
    // use priority queue
    // repeat until all nodes added
    // represent tree as Wgraph

    public WGraph getMinSpanningTree() {
        var tree = new WGraph();
        if (nodes.isEmpty())
            return tree;

        PriorityQueue<Edge> edges = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));

        var startNode = nodes.values().iterator().next();
        edges.addAll(startNode.getEdges());
        tree.addNode(startNode.label);

        while (tree.nodes.size() < nodes.size()) {
            if (edges.isEmpty())
                return tree;
            var minEdge = edges.remove();
            var nextNode = minEdge.to;

            if (tree.containsNode(nextNode.label))
                continue;

            // populate tree
            tree.addNode(nextNode.label);
            tree.addEdge(minEdge.from.label, minEdge.to.label, minEdge.weight);

            // populate PQ
            for (var edge : nextNode.getEdges()) {
                if (!tree.containsNode(edge.to.label))
                    edges.add(edge);
            }
        }

        return tree;
    }

    public boolean containsNode(String label) {
        return nodes.containsKey(label);
    }

    public void removeNode() {

    }
}
