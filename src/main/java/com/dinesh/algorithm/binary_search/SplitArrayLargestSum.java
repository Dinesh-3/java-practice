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
            if(isPossibleSum(middle, numbers, k)) {
                left = middle + 1;
                ans = middle;
            }
            else 
                right = middle - 1;
        }

        return ans;
    }

    private boolean isPossibleSum(int number, int[] nums, int k) {
        int count = 0;
        int sum = 0;

        for(int num: nums) {
            sum += num;
            if(sum > number)
            {
                count++;
                sum = num;
            }

        }

        if(sum <= number)
            count++;
        return count <= k;
    }
}
