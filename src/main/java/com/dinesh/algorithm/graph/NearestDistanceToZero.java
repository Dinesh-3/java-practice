package com.dinesh.algorithm.graph;

import java.util.*;

/**
 *
 * 542. 01 Matrix
 * https://leetcode.com/problems/01-matrix/
 *
 */
public class NearestDistanceToZero {
    public static void main(String[] args) {
        int[][] matrix = {{0,1,0},{0,1,0},{0,1,0},{0,1,0},{0,1,0}};

        NearestDistanceToZero distanceToZero = new NearestDistanceToZero();
        int[][] result = distanceToZero.updateMatrix(matrix);
        System.out.println("result = " + Arrays.deepToString(result));

    }
    public class Node {
        int i, j, time;

        public Node(int i, int j, int time) {
            this.i = i;
            this.j = j;
            this.time = time;
        }

    }

    public int[][] updateMatrix(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        Queue<Node> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 0) {
                    queue.add(new Node(i,j,0));
                }
            }
        }

        int[][] result = new int[n][m];
        int[] rowP = { 0, -1, 1, 0 };
        int[] colP = { -1, 0, 0, 1 };

        while(!queue.isEmpty()) {
            Node node = queue.remove();
//            System.out.println("("+node.i + "," + node.j+"),"+node.time);
            visited.add(node.i + "," + node.j);
            result[node.i][node.j] = node.time;
            for(int i = 0; i < 4; i++) {
                int rowIndex = node.i + rowP[i];
                int colIndex = node.j + colP[i];

                if(rowIndex >= 0 && rowIndex < n && colIndex >= 0 && colIndex < m)
                    if(!visited.contains(rowIndex + "," + colIndex) && grid[rowIndex][colIndex] != 0)
                    {
                        System.out.println("("+ rowIndex + "," +colIndex+"),"+node.time);
                        visited.add(rowIndex + "," + colIndex);
                        queue.add(new Node(rowIndex, colIndex, node.time + 1));
                    }
            }
            System.out.println("Done");
        }

        return result;

    }
}
