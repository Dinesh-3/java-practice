package com.dinesh.algorithm.dynamic_programming.subsequence;

import java.util.*;

/**
 *
 * Subset Sum Problem
 * https://www.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1
 *
 */
public class SubsetProblem {



    static Boolean isSubsetSum(int N, int arr[], int sum){
        Map<String, Boolean> map = new HashMap<>();
        return isTargetSum(N-1, arr, sum, map);
    }

    private static boolean isTargetSum(int index, int[] arr, int sum, Map<String, Boolean> map) {
        if(sum == 0)
            return true;
        if(index == 0)
            return arr[index] == sum;

        if(map.containsKey(index + "," + sum))
            return map.get(index + "," + sum);

        boolean notPick = isTargetSum(index-1, arr, sum, map);
        boolean pick = false;
        if(arr[index] <= sum)
            pick = isTargetSum(index-1, arr, sum - arr[index], map);

        map.put(index + "," + sum, pick || notPick);

        return pick || notPick;
    }

    private static Boolean isSubsetSumTabulation(int N, int arr[], int sum){
        boolean[][] dp = new boolean[N][sum+1];
        for(int i = 0; i < N; i++)
            dp[i][0] = true;

        for(int i = 1; i < arr.length; i++) {
            for(int t=1; t <= sum; t++) {
                boolean notTake = dp[i-1][t];
                boolean take = false;
                if(arr[i] <= t)
                    take = dp[i-1][t-arr[i]];
                dp[i][t] = notTake || take;
            }
        }

        return dp[N-1][sum];
    }


}
