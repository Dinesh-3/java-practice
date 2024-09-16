package com.dinesh.algorithm.dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class ChocolatePickup {
    public int solve(int n, int m, int[][] grid) {
        Map<String, Integer> map = new HashMap<>();
        return traverse(0, 0, m-1, grid, map);
    }

    public int solveTabulation(int n, int m, int grid[][]) {
        int[][][] dp = new int[n][m][m];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < m; j++) {
                if(i == j)
                    dp[n-1][j][j] = grid[n-1][j];
                else
                    dp[n-1][i][j] = grid[n-1][i] + grid[n-1][j];
            }
        }

        for(int i = n-2; i >= 0; i--) {

            for(int j1 = 0; j1 < m; j1++) {

                for(int j2 = 0; j2 < m; j2++) {
                    int[] dir = {-1,0,1};

                    int max = 0;
                    for(int c1: dir) {
                        for(int c2: dir) {
                            int col1 = j1 + c1;
                            int col2 = j2 + c2;
                            if(col1 >= 0 && col1 < m && col2 >= 0 && col2 < m) {
                                if(j1 == j2)
                                    max = Math.max(max, grid[i][j1] + dp[i+1][col1][col2]);
                                else
                                    max = Math.max(max, grid[i][j1] + grid[i][j2] + dp[i+1][col1][col2]);
                            }
                        }
                    }
                    dp[i][j1][j2] = max;
                }

            }

        }

        return dp[0][0][m-1];
    }

    public int solveTab(int n, int m, int grid[][]) {
        int[][][] dp = new int[n][m][m];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < m; j++) {
                if(i==j)
                    dp[n-1][i][j] = grid[n-1][i];
                else
                    dp[n-1][i][j] = grid[n-1][i]+ grid[n-1][j];
            }
        }

        int[] paths = {-1, 0, 1};

        for(int i = n-2; i >= 0; i--)
            for(int j1 = 0; j1 < m; j1++)
                for(int j2 = 0; j2 < m; j2++) {
                    int sum = j1 == j2 ? grid[i][j1] : (grid[i][j1] + grid[i][j2]);
                    int max = 0;
                    for(int path1: paths)
                        for(int path2: paths) {
                            int col1 = j1+path1;
                            int col2 = j2+path2;
                            if(col1 >= 0 && col2 >= 0 && col1< m && col2 < m)
                                max = Math.max(max, dp[i+1][col1][col2]);
                        }

                    dp[i][j1][j2] = sum + max;
                }

        return dp[0][0][m-1];
    }

    private int traverse(int r, int c1, int c2, int[][] grid, Map<String, Integer> map) {
        int n = grid.length;
        int m = grid[0].length;

        String key = r + "," + c1 + "," + c2;

        if(map.containsKey(key))
            return map.get(key);

        if((n-1) == r) {
            if(c1 == c2)
                return grid[r][c1];
            return grid[r][c1] + grid[r][c2];
        }

        int[] dir = {-1,0,1};

        int max = 0;
        for(int i: dir) {
            for(int j: dir) {
                int col1 = c1 + i;
                int col2 = c2 + j;
                if(col1 >= 0 && col1 < m && col2 >= 0 && col2 < m) {
                    if(c1 == c2)
                        max = Math.max(max, grid[r][c1] + traverse(r+1, col1, col2, grid, map));
                    else
                        max = Math.max(max, grid[r][c1] + grid[r][c2] + traverse(r+1, col1, col2, grid, map));
                    map.put(key, max);

                }
            }
        }

        map.put(key, max);

        return max;
    }

    public int solveSpaceOptimization(int n, int m, int[][] grid) {
        int[][] dp = new int[m][m];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < m; j++) {
                if(i == j)
                    dp[j][j] = grid[n-1][j];
                else
                    dp[i][j] = grid[n-1][i] + grid[n-1][j];
            }
        }

        for(int i = n-2; i >= 0; i--) {
            int[][] cur = new int[m][m];
            for(int j1 = 0; j1 < m; j1++) {
                for(int j2 = 0; j2 < m; j2++) {
                    int[] dir = {-1,0,1};

                    int max = 0;
                    for(int c1: dir) {
                        for(int c2: dir) {
                            int col1 = j1 + c1;
                            int col2 = j2 + c2;
                            if(col1 >= 0 && col1 < m && col2 >= 0 && col2 < m) {
                                if(j1 == j2)
                                    max = Math.max(max, grid[i][j1] + dp[col1][col2]);
                                else
                                    max = Math.max(max, grid[i][j1] + grid[i][j2] + dp[col1][col2]);
                            }
                        }
                    }
                    cur[j1][j2] = max;
                }
            }
            dp = cur;
        }

        return dp[0][m-1];
    }

}
