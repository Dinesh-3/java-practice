package com.dinesh.algorithm.dynamic_programming;

/**
 * https://www.youtube.com/watch?v=EgG3jsGoPvQ
 *
 * https://takeuforward.org/data-structure/dynamic-programming-frog-jump-dp-3/
 * Dynamic Programming : Frog Jump (DP 3)
 *
 */
public class JumpFrogMinimumEnergy {
    public static void main(String[] args) {
        int n = 4;
        int[] height = { 30, 10, 60, 10, 10, 60, 50 };

        JumpFrogMinimumEnergy energy = new JumpFrogMinimumEnergy();
        int result = energy.tabulation(height);
        System.out.println("result = " + result);

        int minimumEnergy = energy.minimumEnergy(height, n);
        System.out.println("minimumEnergy = " + minimumEnergy);
    }

    public int minimumEnergy(int arr[],int N){
        int[] dp = new int[arr.length + 1];

        return minimumEnergy(arr.length -1, arr, dp);
    }

    public int minimumEnergy(int index, int[] arr, int dp[]){

        if(index == 0)
            return 0;

        if(dp[index] != 0)
            return dp[index];

        int left = minimumEnergy(index - 1, arr, dp) + Math.abs(arr[index] - arr[index-1]);
        int right = Integer.MAX_VALUE;
        if(index > 1)
            right = minimumEnergy(index - 2, arr, dp) + Math.abs(arr[index] - arr[index-2]);

        dp[index] = Math.min(left, right);
        return Math.min(left, right);

    }

    public int tabulation(int[] arr){
        int[] dp = new int[arr.length + 1];

        for (int i = 1; i < arr.length; i++) {
            int left = dp[i - 1] + Math.abs(arr[i] - arr[i - 1]);
            int right = Integer.MAX_VALUE;
            if(i > 1)
                right = dp[i-2] + Math.abs(arr[i] - arr[i - 2]);
            dp[i] = Math.min(left, right);
        }

        return dp[arr.length - 1];
    }

    public int optimal(int[] arr){

        int prevOne = 0;
        int prevTwo = 0;

        for (int i = 1; i < arr.length; i++) {
            int left = prevOne + Math.abs(arr[i] - arr[i - 1]);
            int right = Integer.MAX_VALUE;
            if(i > 1)
                right = prevTwo + Math.abs(arr[i] - arr[i - 2]);
            prevTwo = prevOne;
            prevOne = Math.min(left, right);
        }

        return prevOne;
    }

}
