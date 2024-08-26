package com.dinesh.algorithm.dynamic_programming.subsequence;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Rod Cutting
 * https://www.geeksforgeeks.org/problems/rod-cutting0840/1
 *
 * https://www.youtube.com/watch?v=mO8XpGoJwuo
 * https://takeuforward.org/data-structure/rod-cutting-problem-dp-24/
 *
 */
public class CuttingRodIntoPiecesMaxProfit {

    public int cutRodTabulation(int[] price, int n) {
        int[][] dp = new int[n][n+1];

        for (int i = 0; i <= n; i++)
            dp[0][i] = i * price[0];

        for (int i = 1; i < n; i++) {
            for (int l = 0; l <= n; l++) {
                int notTake = dp[i-1][l];
                int take = Integer.MIN_VALUE;
                if((i+1) <= l)
                    take = price[i] + dp[i][l-(i+1)];
                dp[i][l] = Math.max(notTake, take);
            }
        }

        return dp[n-1][n];
    }

    public int cutRodSpaceOptimization(int price[], int n) {
        int[] prev = new int[n+1];
        int[] current = new int[n+1];

        for (int i = 0; i <= n; i++)
            prev[i] = i * price[0];

        for (int i = 1; i < n; i++) {
            for (int l = 0; l <= n; l++) {
                int notTake = prev[l];
                int take = Integer.MIN_VALUE;
                if((i+1) <= l)
                    take = price[i] + current[l-(i+1)];
                current[l] = Math.max(notTake, take);
            }
            prev = current;
        }

        return prev[n];
    }


    public int cutRod(int[] price, int n) {
        Map<String, Integer> map = new HashMap<>();
        return maxPrice(price.length - 1, n, price, map);
    }

    private int maxPrice(int i, int length, int[] price, Map<String, Integer> map) {
        String key = (i+1) + "," + length;
        if(i == 0)
            return length * price[0];
        if(map.containsKey(key))
            return map.get(key);
        int notPick = maxPrice(i-1, length, price, map);
        int pick = Integer.MIN_VALUE;
        if((i+1) <= length)
            pick = price[i] + maxPrice(i, length - (i + 1), price, map);
        map.put(key, Math.max(notPick, pick));
        return map.get(key);
    }



}
