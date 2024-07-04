package com.dinesh.algorithm.graph;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfEnclaves {
    class Node {
        int i = 0;
        int j = 0;
        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    public int numEnclaves(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        Queue<Node> queue = new LinkedList<>();

        for(int i = 0; i < c; i++) {
            if(grid[0][i] == 1)
                queue.add(new Node(0, i));

            if(grid[r - 1][i] == 1)
                queue.add(new Node(r - 1, i));
        }

        for(int i = 0; i < r; i++) {
            if(grid[i][0] == 1)
                queue.add(new Node(i, 0));

            if(grid[i][c-1] == 1)
                queue.add(new Node(i, c-1));
        }

        int[] rowP = { -1, 0, 1, 0 };
        int[] colP = { 0, 1, 0, -1 };;

        while(!queue.isEmpty()) {
            Node node = queue.remove();
            grid[node.i][node.j] = 0;

            for(int i = 0; i < rowP.length; i++) {
                int rowIndex = node.i + rowP[i];
                int colIndex = node.j + colP[i];
                if(rowIndex >= 0 && rowIndex < r && colIndex >= 0 && colIndex < c
                        && grid[rowIndex][colIndex] == 1
                ) {
                    grid[rowIndex][colIndex] = 0;
                    queue.add(new Node(rowIndex, colIndex));
                }
            }
        }

        int count = 0;
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(grid[i][j] == 1)
                    count++;
            }
        }

        return count;

    }
}
