package com.dinesh.algorithm.dynamic_programming.stock;

/**
 *
 * 188. Best Time to Buy and Sell Stock IV
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
 *
 * https://www.youtube.com/watch?v=IV1dHbk5CDc
 * https://takeuforward.org/data-structure/buy-and-sell-stock-iv-dp-38/
 *
 */
public class BestTimeToBuyAndSellStockIV {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][k+1];

        for(int i = n-1; i >= 0; i--) {
            for(int j = 0; j < 2; j++) {
                for(int l = 1; l <= k; l++) {
                    if(j == 0)
                        dp[i][j][l] = Math.max(-prices[i] + dp[i+1][1][l], dp[i+1][0][l]);
                    else
                        dp[i][j][l] = Math.max(prices[i] + dp[i+1][0][l-1], dp[i+1][1][l]);
                }
            }
        }

        return dp[0][0][k];
    }
}
