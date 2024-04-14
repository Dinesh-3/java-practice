package com.dinesh.datastructure.graph;

public class GraphMain {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");

        graph.addEdge("A", "B");
        graph.addEdge("B", "A");
        graph.addEdge("C", "A");

        graph.traverseDepthFirst("C");
        graph.traverseDepthFirstRec("C");

        System.out.println("graph.topologicalSort() = " + graph.topologicalSort());

        WeightedGraph weightedGraph = new WeightedGraph();

        weightedGraph.addNode("A");
        weightedGraph.addNode("B");
        weightedGraph.addNode("C");

        weightedGraph.addEdge("A", "B", 2);
        weightedGraph.addEdge("A", "C", 6);
        weightedGraph.addEdge("B", "C", 2);

        System.out.println(weightedGraph.getShortestPath("A", "C"));

    }
}
