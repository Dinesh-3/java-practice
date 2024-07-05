package com.dinesh.algorithm.graph;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class PathMinimumEffort {

    public static void main(String[] args) {
        int[][] heights = {{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};
        PathMinimumEffort effort = new PathMinimumEffort();
        effort.minimumEffortPath(heights);
    }
    class Pair {
        int i;
        int j;
        int distance;
        public Pair(int i, int j, int distance) {
            this.i = i;
            this.j = j;
            this.distance = distance;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;
        Integer[][] visited = new Integer[row][col];

        Queue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt(pair -> pair.distance));
        queue.add(new Pair(0,0,0));

        int[][] directions = {{ -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 }};

        while(!queue.isEmpty()) {
            Pair pair = queue.remove();
            if(pair.i == row - 1 && pair.j == col - 1)
                return pair.distance;
            for(int k = 0; k < directions.length; k++) {
                int rowIndex = pair.i + directions[k][0];
                int colIndex = pair.j + directions[k][1];
                if(!(rowIndex >= 0 && rowIndex  < row && colIndex >= 0 && colIndex < col))
                    continue;
                int newDistance = Math.max(Math.abs(heights[pair.i][pair.j] - heights[rowIndex][colIndex]), pair.distance);
                if(visited[rowIndex][colIndex] == null ||
                        visited[rowIndex][colIndex] > newDistance
                ) {
                    visited[rowIndex][colIndex] = newDistance;
                    queue.add(new Pair(rowIndex,colIndex,newDistance));
                }
            }
        }

        return -1;

    }

}
