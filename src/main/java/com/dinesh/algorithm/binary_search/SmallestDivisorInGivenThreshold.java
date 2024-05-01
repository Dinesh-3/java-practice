package com.dinesh.algorithm.binary_search;

/**
 * 1283. Find the Smallest Divisor Given a Threshold
 * https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/description/
 */
public class SmallestDivisorInGivenThreshold {
    public static void main(String[] args) {

        int[] numbers = { 44,22,33,11,1 };
        int threshold = 5;

        int max = numbers[0];

        for (int i = 1; i < numbers.length; i++)
            max = Math.max(numbers[i], max);

        int leftIndex = 1;
        int rightIndex = max;

        while (leftIndex <= rightIndex) {
            int middle = leftIndex + (rightIndex - leftIndex) / 2;

            int sum = 0;
            for (int number : numbers) sum = sum + (int) Math.ceil((double) number / middle);

            if(sum <= threshold) {
                rightIndex = middle - 1;
            } else {
                leftIndex = middle + 1;
            }

        }

        System.out.println("result = " + leftIndex);
    }
}
