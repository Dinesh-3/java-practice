package com.dinesh.datastructure.graph;

import java.util.*;

public class WeightedGraph {
    private static class Node {
        private final String label;
        private final List<Edge> edges = new ArrayList<>();
        public Node(String label) {
            this.label = label;
        }

        public void addEdge(Node toNode, int weight) {
            edges.add(new Edge(this, toNode, weight));
        }

        public List<Edge> getEdges() {
            return edges;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    private static class Edge {
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
            return from + "->" + to;
        }
    }

    private class NodeEntry {
        private Node node;
        public int priority;

        public NodeEntry(Node node, int priority) {
            this.node = node;
            this.priority = priority;
        }
    }

    private final Map<String, Node> nodes = new HashMap<>();

    public void addNode(String value) {
        nodes.putIfAbsent(value, new Node(value));
    }

    public void addEdge(String from, String to, int weight) {

        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);
        if(fromNode == null || toNode == null)
            return;

        fromNode.addEdge(toNode, weight);
        toNode.addEdge(fromNode, weight);

    }

    public List<String> getShortestPath(String from, String to) {
        Map<Node, Integer> distances = new HashMap<>();
        Map<Node, Node> previousNodes = new HashMap<>();

        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);

        for (var node: nodes.values()) {
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.replace(fromNode, 0);

        Set<Node> visited = new HashSet<>();

        PriorityQueue<NodeEntry> queue = new PriorityQueue<>(Comparator.comparing(ne -> ne.priority));
        queue.add(new NodeEntry(fromNode, 0));

        while (!queue.isEmpty()) {
            Node current = queue.remove().node;
            visited.add(current);

            for (var edge : current.getEdges()) {
                if(visited.contains(edge.to))
                    continue;
                int newDistance = distances.get(current) + edge.weight;

                if(newDistance < distances.get(edge.to)) {
                    distances.replace(edge.to, newDistance);
                    previousNodes.put(edge.to, current);
                    queue.add(new NodeEntry(edge.to, newDistance));
                }

            }

        }

        Stack<Node> stack = new Stack<>();
        stack.push(toNode);

        var previous = previousNodes.get(toNode);
        while (previous != null) {
            stack.push(previous);
            previous = previousNodes.get(previous);
        }

        List<String> paths = new ArrayList<>();
        while (!stack.isEmpty())
            paths.add(stack.pop().label);

        return paths;

    }

    public boolean hasCycle() {
        Set<Node> visited = new HashSet<>();

        for (var node: nodes.values()) {
            if(visited.contains(node))
                continue;
            if(hasCycle(node, null, visited))
                return true;
        }
        return false;
    }

    private boolean hasCycle(Node node, Node parent, Set<Node> visited) {
        visited.add(node);

        for (var edge: node.getEdges()) {
            if(edge.to == parent)
                continue;
            if(visited.contains(edge.to))
                return true;

            if(hasCycle(edge.to, node, visited))
                return true;
        }

        return false;
    }

}
