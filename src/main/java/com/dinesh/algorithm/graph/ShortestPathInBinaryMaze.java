package com.dinesh.algorithm.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ShortestPathInBinaryMaze {

    public static void main(String[] args) {
        int[][] grid = {{0, 1}, {1, 0}};
        ShortestPathInBinaryMaze maze = new ShortestPathInBinaryMaze();
        int result = maze.shortestPathBinaryMatrix(grid);
        System.out.println("result = " + result);
    }

    class Node {
        int i;
        int j;
        int distance;

        public Node(int i, int j, int distance) {
            this.i = i;
            this.j = j;
            this.distance = distance;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;

        if(grid[0][0] == 1 || grid[row-1][col-1] == 1)
            return -1;

        int[][] visited = new int[row][col];

        for (int[] ints : visited) Arrays.fill(ints, -1);


        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0,0, 0));

        int[] rowP = { -1, 0, 1, 0, -1, 1, 1, -1 };
        int[] colP = { 0, 1, 0, -1, -1, -1, 1, 1 };

        while (!queue.isEmpty()) {
            Node node = queue.remove();
            if(node.i == row - 1 && node.j == col - 1)
                return node.distance + 1;

            for (int i = 0; i < rowP.length; i++) {
                int rowIndex = node.i + rowP[i];
                int colIndex = node.j + colP[i];

                if(rowIndex >= 0 && rowIndex < row && colIndex >= 0 && colIndex < col
                        && grid[rowIndex][colIndex] == 0
                        &&( visited[rowIndex][colIndex] == -1 || visited[rowIndex][colIndex] > node.distance + 1)
                ) {
                    visited[rowIndex][colIndex] = node.distance + 1;
                    queue.add(new Node(rowIndex, colIndex, node.distance + 1));
                }
            }

        }

        return -1;
    }}
