package com.dinesh.algorithm.dynamic_programming.subsequence;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Knapsack with Duplicate Items
 * https://www.geeksforgeeks.org/problems/knapsack-with-duplicate-items4201
 *
 */
public class KnapsackWithDuplicateItems {
    static int MAX = (int)(1e9 + 7);

    static int knapSackTabulation(int N, int W, int val[], int wt[])
    {
        int[][] dp = new int[N][W+1];

        for(int w = 0; w <= W; w++)
            dp[0][w] = (w / wt[0]) * val[0];

        for(int i = 1; i < N; i++) {
            for(int w = 1; w <= W; w++) {
                int notPick = dp[i-1][w];
                int pick = Integer.MIN_VALUE;
                if(wt[i] <= w)
                    pick = val[i] + dp[i][w - wt[i]];
                dp[i][w] = Math.max(notPick, pick);
            }
        }

        return dp[N-1][W];
    }

    static int knapSackTableSpaceOptimization(int N, int W, int val[], int wt[])
    {
        int[] prev = new int[W+1];

        for(int w = 0; w <= W; w++)
            prev[w] = (w / wt[0]) * val[0];

        for(int i = 1; i < N; i++) {
            int[] current = new int[W+1];
            for(int w = 1; w <= W; w++) {
                int notPick = prev[w];
                int pick = Integer.MIN_VALUE;
                if(wt[i] <= w)
                    pick = val[i] + current[w - wt[i]];
                current[w] = Math.max(notPick, pick);
            }
            prev = current;
        }

        return prev[W];
    }

    static int knapSack(int N, int W, int val[], int wt[])
    {
        Map<String, Integer> map = new HashMap<>();

        return knapSack(N-1, val, wt, W, map);

    }

    private static int knapSack(int index, int[] val, int[] wt, int weight, Map<String, Integer> map) {
        String key = index + "," + weight;
        if(index == 0)
            return (weight / wt[index]) * val[0];
        if(map.containsKey(key))
            return map.get(key);
        int notPick = knapSack(index-1, val, wt, weight, map);

        int pick = Integer.MIN_VALUE;
        if(wt[index] <= weight)
            pick = val[index] + knapSack(index, val, wt, weight - wt[index], map);
        map.put(key, Math.max(notPick, pick));
        return map.get(key);
    }

}
