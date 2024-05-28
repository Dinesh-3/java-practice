package com.dinesh.algorithm.array;

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
}
