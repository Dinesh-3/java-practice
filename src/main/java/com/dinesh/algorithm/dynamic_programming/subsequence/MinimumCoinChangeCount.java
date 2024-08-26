package com.dinesh.algorithm.dynamic_programming.subsequence;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 322. Coin Change
 * https://leetcode.com/problems/coin-change/
 *
 * https://www.youtube.com/watch?v=myPeWb3Y68A
 *
 */
public class MinimumCoinChangeCount {
    private int MAX = (int)(1e9 + 7);
    public int coinChangeTabulation(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];

        for(int i = 0; i <= amount; i++) {
            if(i % coins[0] == 0)
                dp[0][i] = i / coins[0];
            else
                dp[0][i] = MAX;
        }

        for(int i = 1; i < n; i++) {
            for(int t = 0; t <= amount; t++) {
                int notPick = dp[i - 1][t];
                int pick = MAX;
                if(coins[i] <= t)
                    pick = 1 + dp[i][t-coins[i]];
                dp[i][t] = Math.min(notPick, pick);
            }
        }

        return dp[n-1][amount] >= MAX ? -1 : dp[n-1][amount];
    }

    public int coinChange(int[] coins, int amount) {
        Map<String, Integer> map = new HashMap<>();
        int result = coinChange(coins.length-1, coins, amount, map);
        if(result >= MAX)
            return -1;
        return result;
    }

    private int coinChange(int index, int[] coins, int amount, Map<String, Integer> map) {
        String key = index + "," + amount;
        if(index == 0) {
            if(amount % coins[0] == 0)
                return amount / coins[0];
            return MAX;
        }

        if(map.containsKey(key))
            return map.get(key);

        int notPick = coinChange(index - 1, coins, amount, map);
        int pick = MAX;
        if(coins[index] <= amount)
            pick = 1 + coinChange(index, coins, amount - coins[index], map);
        map.put(key, Math.min(notPick, pick));
        return map.get(key);
    }

}
