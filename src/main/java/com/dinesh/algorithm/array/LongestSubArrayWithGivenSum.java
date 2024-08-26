package com.dinesh.algorithm.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Longest Sub-Array with Sum K
 * https://www.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809
 *
 * https://takeuforward.org/arrays/longest-subarray-with-sum-k-postives-and-negatives/
 * https://www.youtube.com/watch?v=frf7qxiN2qU
 */
public class LongestSubArrayWithGivenSum {
    public static void main(String[] args) {

        int n = 5, k = 10;
        int[] array = { 2,3,5,1,9 };

        int maxLength = 0;

        int left = 0;
        int right = 0;

        int sum = 0;
        while (right < array.length) {
            sum += array[right++];
            if(sum == k)
                maxLength = Math.max(right - left, maxLength);
            else if (sum > k) {
                while (sum > k) {
                    sum -= array[left++];
                }
            }
        }

        System.out.println("maxLength = " + maxLength);

    }

    public static int lenOfLongSubarrPrefixSum(int A[], int N, int K) {
        Map<Integer, Integer> map = new HashMap<>();

        int max = 0;

        int sum = 0;
        for(int i = 0; i < A.length; i++) {
            sum += A[i];
            if(sum == K)
                max = Math.max(max, i+1);
            if(map.containsKey(sum - K))
                max = Math.max(max, (i - map.get(sum-K)));

            if(!map.containsKey(sum))
                map.put(sum, i);

        }

        return max;

    }

}
