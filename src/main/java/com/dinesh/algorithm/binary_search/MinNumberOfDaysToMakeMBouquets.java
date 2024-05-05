package com.dinesh.algorithm.binary_search;

/**
 *
 * Minimum days to make M bouquets
 * https://takeuforward.org/data-structure/nth-root-of-a-number-using-binary-search/
 *
 * https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/
 */
public class MinNumberOfDaysToMakeMBouquets {
    public static void main(String[] args) {

    }

    public int minDays(int[] bloomDay, int m, int k) {
        int min = bloomDay[0];
        int max = bloomDay[0];

        for(int i = 1; i < bloomDay.length; i++) {
            int day = bloomDay[i];
            min = Math.min(day, min);
            max = Math.max(day, max);
        }

        int left = 0;
        int right = max;

        int ans = -1;

        while(left <= right) {
            int middle = left + (right - left) / 2;

            if(isPossible(bloomDay, m,k,middle)) {
                right = middle - 1;
                ans = middle;
            } else {
                left = middle + 1;
            }
        }

        return ans;


    }

    private boolean isPossible(int[] bloomDay, int m, int k, int day) {
        int total = 0;

        int count = 0;
        for(int i = 0; i < bloomDay.length; i++) {
            if(bloomDay[i] <= day)
                count++;
            else {
                total = total + (count / k);
                count = 0;
            }
        }
        total = total + (count / k);
        return total >= m;
    }
}
