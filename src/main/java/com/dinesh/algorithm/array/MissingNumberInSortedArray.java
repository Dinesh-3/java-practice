package com.dinesh.algorithm.array;

public class MissingNumberInSortedArray {
    public static void main(String[] args) {
        int maxLen = 5;
        int[] array = {1, 2, 4, 5};

        int ans = missingNumber(array, maxLen);
        System.out.println("The missing number is: " + ans);
    }

    public static int missingNumber(int[] a, int N) {

        int xor1 = 0, xor2 = 0;

        for (int i = 0; i < N - 1; i++) {
            xor2 = xor2 ^ a[i];
            xor1 = xor1 ^ (i + 1);
        }
        xor1 = xor1 ^ N;

        return (xor1 ^ xor2);
    }

    public static int missingNumberLoop(int []a, int N) {

        //Summation of first N numbers:
        int sum = (N * (N + 1)) / 2;

        //Summation of all array elements:
        int s2 = 0;
        for (int i = 0; i < N - 1; i++) {
            s2 += a[i];
        }

        int missingNum = sum - s2;
        return missingNum;
    }
}
