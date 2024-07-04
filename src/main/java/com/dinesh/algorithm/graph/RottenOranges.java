package com.dinesh.algorithm.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 994. Rotting Oranges
 * https://leetcode.com/problems/rotting-oranges/
 *
 * https://www.youtube.com/watch?v=yf3oUhkvqA0
 * https://takeuforward.org/data-structure/rotten-oranges-min-time-to-rot-all-oranges-bfs/
 *
 */
public class RottenOranges {
    public static void main(String[] args) {

    }

    public class Node {
        int i, j, time;

        public Node(int i, int j, int time) {
            this.i = i;
            this.j = j;
            this.time = time;
        }

    }

    public int orangesRottingOptimized(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        int freshOranges = 0;

        Queue<Node> queue = new LinkedList<>();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] ==1)
                    freshOranges++;
                if(grid[i][j] == 2)
                    queue.add(new Node(i, j , 0));
            }
        }

        int rotternOranges = 0;
        int maxTime = 0;

        int[] rowP = { -1, 0, 1, 0 };
        int[] colP = { 0, 1, 0, -1 };

        while(!queue.isEmpty()) {
            Node cell = queue.remove();

            maxTime = Math.max(maxTime, cell.time);

            for(int i = 0; i < rowP.length; i++) {
                int rowIndex = cell.i + rowP[i];
                int colIndex = cell.j + colP[i];

                if(rowIndex >= 0 && rowIndex < r && colIndex >=0 && colIndex < c
                        && grid[rowIndex][colIndex] == 1
                ) {
                    rotternOranges++;
                    grid[rowIndex][colIndex] = 2;
                    queue.add(new Node(rowIndex, colIndex, cell.time + 1));
                }
            }

        }

        if(freshOranges != rotternOranges)
            return -1;
        return maxTime;
    }

    public int orangesRotting(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int freshOrangeCount = 0;
        Queue<Node> queue = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 2)
                    queue.add(new Node(i,j,0));
                if(grid[i][j] == 1)
                    freshOrangeCount++;
            }
        }

        Set<String> visited = new HashSet<>();
        int maxTime = 0;

        int[] rowP = { 0, -1, 1, 0 };
        int[] colP = { -1, 0, 0, 1 };

        int rottenOrange = 0;
        while(!queue.isEmpty()) {
            Node node = queue.remove();
            visited.add(node.i + "," + node.j);
            maxTime = Math.max(maxTime, node.time);

            for(int i = 0; i < 4; i++) {
                int rowIndex = node.i + rowP[i];
                int colIndex = node.j + colP[i];

                if(rowIndex >= 0 && rowIndex < n && colIndex >= 0 && colIndex < m)
                    if(!visited.contains(rowIndex + "," + colIndex) && grid[rowIndex][colIndex] == 1)
                    {
                        queue.add(new Node(rowIndex, colIndex, node.time + 1));
                        rottenOrange++;
                        grid[rowIndex][colIndex] = 2;
                    }

            }

        }

        if(rottenOrange != freshOrangeCount)
            return -1;

        return maxTime;

    }

}
