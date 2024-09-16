package com.dinesh.algorithm.dynamic_programming.subsequence;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 518. Coin Change II
 * https://leetcode.com/problems/coin-change-ii
 *
 * https://www.youtube.com/watch?v=HgyouUi11zk
 *
 */
public class CoinChangeII {

    public int changeTabulation(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int t = 0; t <= amount; t++)
            if(t % coins[0] == 0)
                dp[0][t] = 1;

        for(int i = 1; i < n; i++) {
            for(int t = 0; t <= amount; t++) {
                int notTake = dp[i-1][t];
                int take = 0;
                if(coins[i] <= t)
                    take = dp[i][t-coins[i]];
                dp[i][t] = notTake + take;
            }
        }

        return dp[n-1][amount];
    }

    public int change(int amount, int[] coins) {
        Map<String, Integer> map = new HashMap<>();
        return change(coins.length-1, coins, amount, map);
    }

    private int change(int index, int[] coins, int amount, Map<String, Integer> map) {
        String key = index + "," + amount;
        if(index == 0) {
            if(amount % coins[0] == 0)
                return 1;
            return 0;
        }

        if(map.containsKey(key))
            return map.get(key);

        int notTake = change(index-1, coins, amount, map);
        int take = 0;
        if(coins[index] <= amount)
            take = change(index, coins, amount - coins[index], map);

        map.put(key, notTake + take);
        return notTake + take;
    }

}
