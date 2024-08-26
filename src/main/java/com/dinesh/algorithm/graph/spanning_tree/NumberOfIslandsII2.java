package com.dinesh.algorithm.graph.spanning_tree;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Number of island II
 * https://www.youtube.com/watch?v=Rn6B-Q4SNyA
 *
 * https://takeuforward.org/graph/number-of-islands-ii-online-queries-dsu-g-51/
 *
 */
public class NumberOfIslandsII2 {
    public static void main(String[] args) {
        int n = 4, m = 5;
        int[][] operators = {{0, 0}, {0, 0}, {1, 1}, {1, 0}, {0, 1},
                {0, 3}, {1, 3}, {0, 4}, {3, 2}, {2, 2}, {1, 2}, {0, 2}
        };

        int[][] islands = new int[n][m];

        DisjointSet set = new DisjointSet(m*n);

        List<Integer> result = new ArrayList<>();
        int[][] directions = { {1,0}, {0,1}, {-1,0}, {0,-1} };
        int count = 0;
        for (int i = 0; i < operators.length; i++) {
            int[] position = operators[i];
            int parentRow = position[0];
            int parentCol = position[1];
            if(islands[parentRow][parentCol] == 1) {
                result.add(count);
                continue;
            }

            count++;
            islands[parentRow][parentCol] = 1;

            for(int[] path: directions) {
                if(count == 1)
                    continue;
                int rowIndex = parentRow + path[0];
                int colIndex = parentCol + path[1];

                if(rowIndex >= 0 && rowIndex < n && colIndex >= 0 && colIndex < m
                    && islands[rowIndex][colIndex] == 1
                ) {
                    int nodeOne = rowIndex*m + colIndex;
                    int nodeTwo = parentRow*m + parentCol;
                    if(!set.isConnected(nodeOne, nodeTwo)) {
                        set.unionBySize(nodeOne, nodeTwo);
                        count--;
                    }
                }
            }

            result.add(count);
        }

        System.out.println("result = " + result);


    }
}
