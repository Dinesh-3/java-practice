package com.dinesh.algorithm.binary_search;

public class LowerBound {
    public static void main(String[] args) {
        int n = 4;
        int[] array = {1,2,2,3};
        int x = 2;

        int left = 0;
        int right = args.length - 1;

        int ans = array[array.length - 1];
        while(left < right) {
            int mid = left + (right - left) / 2;

            if(array[mid] >= x ) {
                ans = array[mid];
                right = left - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println("ans = " + ans);
    }
}
