package com.dinesh.algorithm.binary_search;

public class KthMissingPositiveNumber {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int k = 2;
//        if(arr.length < 2)
//            return 1;
        int leftIndex = 0;
        int rightIndex = arr.length - 1;

        while(leftIndex <= rightIndex) {
            int middle = leftIndex + ( rightIndex - leftIndex ) / 2;
            int result = arr[middle] - (middle + 1);

            if(result < k)
                leftIndex = middle + 1;
            else
                rightIndex = middle - 1;

        }

        int result = arr[rightIndex] + k - (arr[rightIndex] - (rightIndex + 1));
        System.out.println("result = " + result);
    }
}
