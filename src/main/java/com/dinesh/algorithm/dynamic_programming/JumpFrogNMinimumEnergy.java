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

    public int minimizeCost(int arr[], int k) {
        Integer[] dp = new Integer[arr.length];

        return minCost(arr.length - 1, arr, k, dp);
    }

    private int minCost(int index, int[] arr, int k, Integer[] dp) {
        if(index < 0)
            return Integer.MAX_VALUE;
        if(index == 0)
            return 0;
        if(dp[index] != null)
            return dp[index];

        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= k; i++) {
            if(index-i >= 0)
                min = Math.min(min, minCost(index-i, arr, k, dp) + Math.abs(arr[index] - arr[index-i]));
        }

        dp[index] = min;
        return min;
    }


}
