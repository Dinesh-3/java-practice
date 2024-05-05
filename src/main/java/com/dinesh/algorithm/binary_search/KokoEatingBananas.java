package com.dinesh.algorithm.binary_search;

import java.util.Arrays;

/**
 * 875. Koko Eating Bananas
 * https://leetcode.com/problems/koko-eating-bananas
 */
public class KokoEatingBananas {
    public static void main(String[] args) {
        int[] piles = { 805306368,805306368,805306368 };
        int h = 1000000000;

        KokoEatingBananas bananas = new KokoEatingBananas();
        int result = bananas.minEatingSpeed(piles, h);
        System.out.println("result = " + result);
    }

    public int minEatingSpeed(int[] piles, int h) {

        int max = 0;
        for (var num: piles) {
            max = Math.max(num, max);
        }

        int left = 1;
        int right = max;

        int result = 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if(isMinPossibleHour(piles, middle, h)) {
                right = middle - 1;
                result = middle;
            } else {
                left = middle + 1;
            }
        }

        return result;
    }

    private boolean isMinPossibleHour(int[] piles, int hour, int totalHour) {

        int sum = 0;

        for (int i = 0; i < piles.length; i++) {
            sum += (int) Math.ceil(piles[i] / (double )hour);
        }
        if(sum < 0)
            return false;
        return sum <= totalHour;
    }
}
