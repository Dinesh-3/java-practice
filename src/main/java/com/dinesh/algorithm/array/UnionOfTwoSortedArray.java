package com.dinesh.algorithm.array;

import java.util.ArrayList;

/**
 *
 * Find the Union
 * https://takeuforward.org/data-structure/union-of-two-sorted-arrays/
 *
 */
public class UnionOfTwoSortedArray {

    public static void main(String[] args) {
        int[] arr1 = {-7, 8};
        int[] arr2 = { -8, -3, 8 };

        findUnion(arr1, arr2, arr1.length, arr2.length);
    }

    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
        ArrayList<Integer> result = new ArrayList<>();

        int leftIndex = 0;
        int rightIndex = 0;

        while(leftIndex < arr1.length && rightIndex < arr2.length) {
            while(!result.isEmpty() && leftIndex < arr1.length && result.get(result.size() - 1) == arr1[leftIndex]) {
                leftIndex++;
            }

            while(!result.isEmpty() && rightIndex < arr2.length && result.get(result.size() - 1) == arr2[rightIndex]) {
                rightIndex++;
            }
            if(leftIndex < arr1.length && rightIndex < arr2.length) {
                if (arr1[leftIndex] < arr2[rightIndex]) {
                    result.add(arr1[leftIndex++]);
                } else {
                    result.add(arr2[rightIndex++]);
                }
            }
        }

        while(leftIndex < arr1.length) {
            while(!result.isEmpty() && leftIndex < arr1.length  && result.get(result.size() - 1) == arr1[leftIndex])
            {
                leftIndex++;
            }
            if(leftIndex < arr1.length)
                result.add(arr1[leftIndex++]);
        }

        while(rightIndex < arr2.length) {
            while(!result.isEmpty() && rightIndex < arr2.length && result.get(result.size() - 1) == arr2[rightIndex])
            {
                rightIndex++;
            }
            if(rightIndex < arr2.length)
                result.add(arr2[rightIndex++]);
        }

        return result;

    }
}
