package com.dinesh.algorithm.dynamic_programming.stock;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 123. Best Time to Buy and Sell Stock III
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii
 *
 * https://www.youtube.com/watch?v=-uQGzhYj8BQ
 *
 */
public class BestTimeToBuyAndSellStockIII {

    public int maxProfitTabulation(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][3];

        for(int i = n - 1; i >= 0; i--) {
            for(int b = 0 ; b < 2; b++) {
                for(int c = 1; c <= 2; c++) {
                    int profit = 0;
                    if(b == 0)
                        profit = Math.max(-prices[i] + dp[i+1][1][c], dp[i+1][0][c]);
                    if(b == 1)
                        profit = Math.max(prices[i] + dp[i+1][0][c-1], dp[i+1][1][c]);
                    dp[i][b][c] = profit;
                }
            }
        }

        return dp[0][0][2];
    }

    public int maxProfitSpaceOptimization(int[] prices) {
        int n = prices.length;
        int[][] prev = new int[2][3];

        for(int i = n - 1; i >= 0; i--) {
            int[][] curr = new int[2][3];
            for(int b = 0 ; b < 2; b++) {
                for(int c = 1; c <= 2; c++) {
                    int profit = 0;
                    if(b == 0)
                        profit = Math.max(-prices[i] + prev[1][c], prev[0][c]);
                    if(b == 1)
                        profit = Math.max(prices[i] + prev[0][c-1], prev[1][c]);
                    curr[b][c] = profit;
                }
            }
            prev = curr;
        }

        return prev[0][2];
    }


    public int maxProfit(int[] prices) {
        Map<String, Integer> map = new HashMap<>();
        return maxProfit(0, 2, prices, 0, map);
    }

    private int maxProfit(int index, int limit, int[] prices, int buy, Map<String, Integer> map) {
        String key = index + "," + limit + "," + buy;
        if(limit == 0)
            return 0;
        if(index == prices.length)
            return 0;
        if(map.containsKey(key))
            return map.get(key);

        int profit = 0;
        if(buy == 0)
            profit = Math.max(-prices[index] + maxProfit(index+1, limit, prices, 1, map), maxProfit(index+1, limit, prices, 0, map));
        if(buy == 1)
            profit = Math.max(prices[index] + maxProfit(index+1, limit-1, prices, 0, map), maxProfit(index+1, limit, prices, 1, map));
        map.put(key, profit);
        return profit;
    }

}
