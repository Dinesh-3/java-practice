package com.dinesh.algorithm.graph;

import java.util.*;

/**
 *
 * M-Coloring Problem
 * https://www.geeksforgeeks.org/problems/m-coloring-problem-1587115620
 *
 */
public class MColoringProblem {
    public static void main(String[] args) {
        List<String> str = new ArrayList<>();
        str.subList(1, str.size());
        boolean[][] graph = {{false, true, true, true}, {true, false, true, false}, {true, true, false, true}, {true, false, true, false}};
        MColoringProblem problem = new MColoringProblem();
        problem.graphColoring(graph, 3, 4);
    }

    public boolean graphColoring(boolean graph[][], int m, int n) {

        int[] colors = new int[n];

        List<List<Integer>> list = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
            for(int j = 0; j < graph[i].length; j++)
                if(graph[i][j])
                    list.get(i).add(j);
        }

        return colorIt(0, colors, list, m);

    }

    private boolean colorIt(int node, int[] colors, List<List<Integer>> list, int m) {
        if(node == list.size())
            return true;

        for(int i = 1; i <= m; i++) {
            if(isPossible(i, node, list, colors)) {
                colors[node] = i;
                if(colorIt(node+1, colors, list, m))
                    return true;
                colors[node] = 0;
            }
        }

        return false;
    }

    private boolean isPossible(int color, int node, List<List<Integer>> adj, int[] colors) {
        for(int edge: adj.get(node))
            if(colors[edge] == color)
                return false;
        return true;
    }

}
