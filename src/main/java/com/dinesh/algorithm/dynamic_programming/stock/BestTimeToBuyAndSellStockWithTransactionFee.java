package com.dinesh.algorithm.dynamic_programming.stock;

/**
 *
 * Best Time to Buy and Sell Stock with Transaction Fee
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee
 *
 * https://takeuforward.org/data-structure/buy-and-sell-stocks-with-transaction-fees-dp-40/
 * https://www.youtube.com/watch?v=k4eK-vEmnKg
 *
 */
public class BestTimeToBuyAndSellStockWithTransactionFee {

    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];

        for(int i = n-1; i >= 0; i--) {
            dp[i][0] = Math.max(-prices[i] + dp[i+1][1],  dp[i+1][0]);
            dp[i][1] = Math.max(prices[i]-fee + dp[i+1][0],  dp[i+1][1]);
        }

        return dp[0][0];
    }


    public int maxProfitSO(int[] prices, int fee) {
        int n = prices.length;
        int[] prev = new int[2];

        for(int i = n-1; i >= 0; i--) {
            int[] curr = new int[2];
            curr[0] = Math.max(-prices[i] + prev[1],  prev[0]);
            curr[1] = Math.max(prices[i]-fee + prev[0],  prev[1]);

            prev = curr;
        }

        return prev[0];
    }


}
