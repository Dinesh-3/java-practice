package com.dinesh.algorithm.binary_search;

public class SplitArrayLargestSum {
    public static void main(String[] args) {
        int[] numbers = { 1, 4, 4 };
        int k = 3;

        SplitArrayLargestSum largestSum = new SplitArrayLargestSum();
        int maxSum = largestSum.splitArray(numbers, k);

        System.out.println("maxSum = " + maxSum);

    }

    public int splitArray(int[] numbers, int k) {
        int max = 0;
        int sum = 0;

        for (int num : numbers) {
            max = Math.max(max, num);
            sum += num;
        }
        
        int left = max;
        int right = sum;
        
        int ans = max;
        while (left <= right) {
            int middle = ( left + right ) / 2;
            if(isPossibleSum(numbers, middle, k)) {
                left = middle + 1;
                ans = middle;
            }
            else 
                right = middle - 1;
        }

        return ans;
    }

    private boolean isPossibleSum(int[] numbers, int target, int subLength) {
        int count = 0;

        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            sum += num;
            if(sum > target) {
                count++;
                sum = num;
            }

            if(count >= subLength)
                return true;
        }
        if(sum >= target) {
            count++;
        }
        return count >= subLength;
    }
}
