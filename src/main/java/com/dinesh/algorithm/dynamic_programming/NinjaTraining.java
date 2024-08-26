package com.dinesh.algorithm.dynamic_programming;

public class NinjaTraining {
    public static int ninjaTraining(int n, int points[][]) {
        return maximumPoints(points, n);
    }

    public static int maximumPoints(int arr[][], int N) {

        int r = arr.length;
        int c = arr[0].length;

        int[][] dp = new int[r][c];

        int max = Integer.MIN_VALUE;

        for(int i = 0; i < c; i++)
            max = Math.max(max, getMax(r-1, i, i, arr, dp));

        return max;

    }

    public static int getMax(int i, int j, int prevC, int[][] arr, int[][] dp) {
        int r = arr.length;
        int c = arr[0].length;

        if(i < 0 || j < 0 || i >= r || j >= c)
            return Integer.MIN_VALUE;

        if(i == 0)
            return arr[i][j];

        int max = Integer.MIN_VALUE;
        for(int cIndex = 0; cIndex < c; cIndex++)
            if(cIndex != prevC)
                max = Math.max(arr[i][j] + getMax(i-1, cIndex, j, arr, dp), max);
        return max;

    }


}
