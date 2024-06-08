package com.dinesh.algorithm.graph;

/**
 * 733. Flood Fill
 * https://leetcode.com/problems/flood-fill
 *
 * https://takeuforward.org/graph/flood-fill-algorithm-graphs/
 * https://www.youtube.com/watch?v=C-2_uSRli8o
 */
public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;

        int[][] visited = new int[n][m];
        int targetColor = image[sr][sc];
        dfs(sr, sc, image, targetColor, visited);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(visited[i][j] == 1) {
                    image[i][j] = color;
                }
            }
        }
        return image;

    }

    public void dfs(int row, int col, int[][] image, int targetColor, int[][] visited) {
        int n = image.length;
        int m = image[0].length;

        visited[row][col] = 1;

        int[] rowP = { -1, 0 , 1, 0 };
        int[] colP = { 0, 1 , 0, -1 };

        for(int i = 0; i < 4; i++) {
            int rowI = row + rowP[i];
            int colI = col + colP[i];

            if(rowI >= 0 && rowI < n && colI >= 0 && colI < m
                    && image[rowI][colI] == targetColor && visited[rowI][colI] == 0
            ) {
                visited[rowI][colI] = 1;
                dfs(rowI, colI, image, targetColor, visited);
            }

        }

    }
}
