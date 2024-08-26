package com.dinesh.algorithm.dynamic_programming.partition;

import java.util.*;

/**
 *
 * Matrix Chain Multiplication
 * https://www.geeksforgeeks.org/problems/matrix-chain-multiplication0303
 *
 * https://takeuforward.org/dynamic-programming/matrix-chain-multiplication-dp-48/
 * https://www.youtube.com/watch?v=vRVfmbCFW7Y
 *
 */
public class MinMatrixChainMultiplication {

    static int matrixMultiplicationTabulation(int N, int arr[])
    {

        int[][] dp = new int[N][N];

        for(int i = N-1; i >= 1; i--) {
            for(int j = i+1; j < N; j++) {
                int min = Integer.MAX_VALUE;

                for(int k = i; k < j; k++) {
                    int mul = arr[i-1] * arr[k] * arr[j] +
                            dp[i][k] + dp[k+1][j];
                    min = Math.min(min, mul);
                }

                dp[i][j] = min;
            }
        }

        return dp[1][N-1];
    }
    static int matrixMultiplication(int N, int arr[])
    {
        Map<String, Integer> map = new HashMap<>();
        return mat(1, N-1, arr, map);
    }

    private static int mat(int i, int j, int[] arr, Map<String, Integer> map) {
        String key = i + "," + j;
        if(i == j)
            return 0;

        if(map.containsKey(key))
            return map.get(key);

        int min = Integer.MAX_VALUE;

        for(int k = i; k < j; k++) {
            int mul = arr[i-1] * arr[k] * arr[j] +
                    mat(i, k, arr, map) + mat(k+1, j, arr, map);
            map.put(key, mul);
            min = Math.min(min, mul);
        }

        map.put(key, min);
        return min;
    }

}
