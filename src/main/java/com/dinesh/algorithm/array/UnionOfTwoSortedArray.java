package com.dinesh.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;

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
        ArrayList<Integer> list = new ArrayList<>();

        int first = 0;
        int second = 0;

        while(first < n && second < m) {
            if(arr1[first] <= arr2[second]) {
                if(list.isEmpty() || list.get(list.size()-1) != arr1[first])
                    list.add(arr1[first]);
                first++;
            } else {
                if(list.isEmpty() || list.get(list.size()-1) != arr2[second])
                    list.add(arr2[second]);
                second++;
            }
        }

        while(first < n) {
            if(list.isEmpty() || list.get(list.size()-1) != arr1[first])
                list.add(arr1[first]);
            first++;
        }

        while(second < m) {
            if(list.isEmpty() || list.get(list.size()-1) != arr2[second])
                list.add(arr2[second]);
            second++;
        }

        return list;
    }
}
