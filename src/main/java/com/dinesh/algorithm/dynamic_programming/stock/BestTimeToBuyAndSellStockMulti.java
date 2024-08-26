package com.dinesh.algorithm.dynamic_programming.stock;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 122. Best Time to Buy and Sell Stock II
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii
 *
 * https://www.youtube.com/watch?v=nGJmxkUJQGs
 * https://takeuforward.org/data-structure/buy-and-sell-stock-ii-dp-36/
 *
 */
public class BestTimeToBuyAndSellStockMulti {
    public int maxProfitTabulation(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];

        dp[n][0] = dp[n][1] = 0;

        for(int i = n-1; i >= 0; i--) {
            for(int b = 0; b < 2; b++) {
                int profit;
                if( b == 0)
                    profit = Math.max(dp[i+1][0], -prices[i] + dp[i+1][1]);
                else
                    profit = Math.max(dp[i+1][1], prices[i] + dp[i+1][0]);
                dp[i][b] = profit;
            }
        }

        return dp[0][0];
    }

    public int maxProfitSpaceOptimization(int[] prices) {
        int n = prices.length;
        int[] prev = new int[2];
        prev[0] = prev[1] = 0;

        for(int i = n-1; i >= 0; i--) {
            int[] curr = new int[2];
            for(int b = 0; b < 2; b++) {
                int profit;
                if( b == 0)
                    profit = Math.max(prev[0], -prices[i] + prev[1]);
                else
                    profit = Math.max(prev[1], prices[i] + prev[0]);
                curr[b] = profit;
            }
            prev = curr;
        }

        return prev[0];
    }

    public int maxProfit(int[] prices) {
        Map<String, Integer> map = new HashMap<>();
        return maxProfit(0, prices, map, 0);
    }
    private int maxProfit(int index, int[] prices, Map<String, Integer> map, int isBuy) {
        String key = index + "," + isBuy;
        if(index == prices.length)
            return 0;
        if(map.containsKey(key))
            return map.get(key);
        int profit = 0;
        if(isBuy == 0)
            profit = Math.max(maxProfit(index+1, prices, map, 0), -prices[index] + maxProfit(index+1, prices, map, 1));

        if(isBuy == 1)
            profit = Math.max(maxProfit(index+1, prices, map, 1), prices[index] + maxProfit(index+1, prices, map, 0));

        map.put(key, profit);

        return profit;
    }

}
