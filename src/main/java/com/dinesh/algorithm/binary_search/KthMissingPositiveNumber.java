package com.dinesh.algorithm.binary_search;

public class KthMissingPositiveNumber {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int k = 2;

        int resultTwo = findKthPositive(arr, k);
        System.out.println("resultTwo = " + resultTwo);
    }

    public static int findKthPositive(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;

        while(left <= right) {
            int mid = ( left + right ) / 2;
            int mis = arr[mid] - ( mid + 1);
            if(mis >= k)
                right = mid - 1;
            else
                left = mid + 1;
        }
        if(right < 0)
            return k;

        int missTill = k - (arr[right] - left);
        return arr[right] + missTill;
    }
}
