package com.dinesh.algorithm.dynamic_programming.longest_increasing_sequence;

import java.util.Arrays;

/**
 *
 * Longest Bitonic subsequence
 * https://www.geeksforgeeks.org/problems/longest-bitonic-subsequence0824
 *
 * https://takeuforward.org/data-structure/longest-bitonic-subsequence-dp-46/
 * https://www.youtube.com/watch?v=y4vN0WNdrlg
 *
 */
public class LongestBiotonicSubSequence {
    public static int LongestBitonicSequence(int n, int[] nums) {
        int[] dpl = new int[n];
        Arrays.fill(dpl, 1);
        int[] dpr = new int[n];
        Arrays.fill(dpr, 1);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                int len = dpl[j] + 1;
                if(nums[j] < nums[i])
                    dpl[i] = Math.max(dpl[i], len);
            }
        }

        for(int i = n-1; i >=0; i--) {
            for(int j = n-1; j > i; j--) {
                int len = dpr[j] + 1;
                if(nums[j] < nums[i])
                    dpr[i] = Math.max(dpr[i], len);
            }
        }

        int max = 0;

        for(int i = 0; i < n; i++)
            if(dpl[i] > 1 && dpr[i] > 1)
                max = Math.max(max, dpl[i] + dpr[i] - 1);

        return max;
    }

}
