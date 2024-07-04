package com.dinesh.algorithm.binary_tree;

/**
 *
 * https://www.youtube.com/watch?v=muncqlKJrH0
 * https://takeuforward.org/data-structure/number-of-islands/
 *
 * Number Of connected Islands in 8 direction
 *
 */
public class NumberOfConnectedIslands {
    public static void main(String[] args) {
        char[][] grid =  {
                {'0', '1', '0', '0', '0', '0', '0'},
                {'0', '0', '0', '1', '0', '1', '0'}
        };
        int count = numberOfConnectedIslands(grid);
        System.out.println("count = " + count);
    }

    private static int numberOfConnectedIslands(char[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        boolean[][] visited = new boolean[r][c];

        int count = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(!visited[i][j] && grid[i][j] == '1') {
                    dfs(i, j, grid, visited);
                    count++;
                }

            }
        }

        return count;
    }

    private static void dfs(int i, int j, char[][] grid, boolean[][] visited) {
        int r = grid.length;
        int c = grid[0].length;

        visited[i][j] = true;

        int[] rowP = { -1, 0 , 1, 0, 1, 1, -1, -1 };
        int[] colP = { 0, 1 , 0, -1, -1, 1, 1, -1 };

        for (int k = 0; k < rowP.length; k++) {
            int rowIndex = i + rowP[k];
            int colIndex = j + colP[k];

            if(rowIndex >= 0 && rowIndex < r && colIndex >= 0 && colIndex < c
                && !visited[rowIndex][colIndex] && grid[rowIndex][colIndex] == '1'
            )
                dfs(rowIndex, colIndex, grid, visited);
        }

    }


}
