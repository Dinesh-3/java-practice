package com.dinesh.algorithm.dynamic_programming;


/**
 * https://www.geeksforgeeks.org/problems/minimal-cost
 * https://takeuforward.org/data-structure/dynamic-programming-frog-jump-with-k-distances-dp-4/
 * https://www.youtube.com/watch?v=Kmh3rhyEtB8
 *
 */
public class JumpFrogNMinimumEnergy {

    public int minimizeCost(int arr[],int N,int K){
        int[] dp = new int[arr.length];

        int min = Integer.MAX_VALUE;
        for(int i = 1; i < arr.length; i++) {
            int res = Integer.MAX_VALUE;
            for(int j = 1; j <= K; j++) {
                if( i - j >= 0) {
                    int result = dp[i-j] + Math.abs(arr[i] - arr[i - j]);
                    res = Math.min(result, res);
                }
            }
            dp[i] = res;
        }

        return dp[arr.length - 1];

    }
}
