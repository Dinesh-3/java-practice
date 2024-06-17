package com.dinesh.algorithm.greedy;

public class MinimumCoins {
    public static void main(String[] args) {

        int[] coins = { 1000, 500, 100, 50, 20, 10, 5, 2, 1 };

        int count = 0;
        int amount = 322;

        for (int i = 0; i < coins.length; i++) {
            if(amount <= 0)
                break;
            if(amount >= coins[i]) {
                count += amount / coins[i];
                amount = amount % coins[i];
            }
        }

        System.out.println("count = " + count);

    }


}
