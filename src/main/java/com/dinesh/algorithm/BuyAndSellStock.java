package com.dinesh.algorithm;

/**
 * Buy and sell stock with max profit
 */
public class BuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = { 7, 1, 5, 3, 6, 4 };

        int maxProfit = getStockMaxProfit(prices);

    }

    private static int getStockMaxProfit(int[] prices) {
        if(prices == null)
            return 0;
        if(prices.length == 1)
            return prices[0];

        int buyIndex = 0;
        int sellIndex = 1;
        int maxProfit = 0;

        while (sellIndex < prices.length) {
            if(prices[buyIndex] < prices[sellIndex]) {
                int profit = prices[sellIndex] - prices[buyIndex];
                maxProfit = Integer.max(profit, maxProfit);
            }
            else
                buyIndex = sellIndex;
            sellIndex++;
        }

        System.out.println("maxProfit = " + maxProfit);


        return 0;
    }
}
