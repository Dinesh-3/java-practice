package com.dinesh.algorithm.graph.shortest_path;

import java.util.*;

/**
 *
 * Floyd Warshall
 * https://www.geeksforgeeks.org/problems/implementing-floyd-warshall2042
 *
 * https://takeuforward.org/data-structure/floyd-warshall-algorithm-g-42/
 * https://www.youtube.com/watch?v=YbY8cVwWAvw
 *
 */
public class FloydWarshall {

    public void shortest_distance(int[][] matrix)
    {
        int len = matrix.length;

        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                if(matrix[i][j] == -1)
                    matrix[i][j] = (int) 1e9;
                if(i == j)
                    matrix[i][j] = 0;
            }
        }

        for(int via = 0; via < len; via++) {
            for(int i = 0; i < len; i++) {
                for(int j = 0; j < len; j++) {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][via] + matrix[via][j]);
                }
            }
        }

        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                if(matrix[i][j] == (int) 1e9)
                    matrix[i][j] = -1;
            }
        }

    }
}
