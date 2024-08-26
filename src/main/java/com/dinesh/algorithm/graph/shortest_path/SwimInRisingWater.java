package com.dinesh.algorithm.graph.shortest_path;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * 778. Swim in Rising Water
 * https://leetcode.com/problems/swim-in-rising-water
 *
 */
public class SwimInRisingWater {
    class Node {
        int i;
        int j;
        int maxJump;
        public Node(int i, int j, int maxJump) {
            this.i = i;
            this.j = j;
            this.maxJump = maxJump;
        }
    }

    public int swimInWater(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        boolean[][] visited = new boolean[r][c];

        Queue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.maxJump));
        queue.add(new Node(0, 0, grid[0][0]));
        visited[0][0] = true;

        int[][] paths = {{1,0}, {0,1}, {-1,0}, {0,-1}};

        while(!queue.isEmpty()) {
            Node node = queue.remove();
            if(node.i == r-1 && node.j == c-1)
                return node.maxJump;

            for(int[] path: paths) {
                int rowIndex = node.i + path[0];
                int colIndex = node.j + path[1];

                if(rowIndex >= 0 && rowIndex < r && colIndex >= 0 && colIndex < c) {
                    if(!visited[rowIndex][colIndex]) {
                        visited[rowIndex][colIndex] = true;
                        queue.add(new Node(rowIndex, colIndex, Math.max(grid[rowIndex][colIndex], node.maxJump)));
                    }
                }
            }

        }

        return -1;
    }
}
