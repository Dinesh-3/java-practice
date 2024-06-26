package com.dinesh.algorithm.array;

import java.util.HashMap;
import java.util.Map;


/**
 *
 * https://takeuforward.org/data-structure/length-of-the-longest-subarray-with-zero-sum/
 * https://www.youtube.com/watch?v=xmguZ6GbatA
 *
 */
public class LargestSubArrayWithSumZero {
    public static void main(String[] args) {
        int[] arr = {15,-2,2,-8,1,7,10,23};

        LargestSubArrayWithSumZero array = new LargestSubArrayWithSumZero();
        array.maxLen(arr, arr.length);
    }

    private int maxLen(int arr[], int n)
    {
        Map<Integer, Integer> map = new HashMap<>();

        int maxLength = 0;

        int sum = 0;

        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if(sum == 0) {
                maxLength = Math.max(maxLength, i + 1);
            } else if (map.containsKey(sum)) {
                maxLength = Math.max(maxLength, i - map.get(sum) + 1 );
            } else {
                map.put(sum, i);
            }

        }

        return maxLength;

    }

    int maxLen2(int[] arr, int n)
    {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if(sum == 0)
                max = Math.max(max, i+1);
            else if(map.containsKey(sum))
                max = Math.max(max, i - map.get(sum) + 1);
            else
                map.put(sum, i);
        }

        return max;
    }

}
