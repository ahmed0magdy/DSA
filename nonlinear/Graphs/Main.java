package nonlinear.Graphs;

public class Main {
    public static void main(String[] names) {
        var graph = new Graph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addEdge("A", "B");
        graph.addEdge("B", "C");
        graph.addEdge("C", "A");

        // graph.removeEdge("A", "c");
        // graph.removeNode("A");
        // graph.print();
        // graph.traverseBreadthFirst("K");
        // graph.traverseDepthFirst("K");
        // System.out.println(graph.topologicalSort());
        System.out.println(graph.hasCycle());
    }
}
