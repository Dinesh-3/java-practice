package com.dinesh.algorithm.greedy;

import java.util.Arrays;

/**
 *
 * https://takeuforward.org/strivers-a2z-dsa-course/strivers-a2z-dsa-course-sheet-2
 *
 * https://www.geeksforgeeks.org/problems/minimum-platforms-1587115620/1
 *
 */
public class MinimumPlatformsRequired {
    public static void main(String[] args) {
        int[] arr = {900, 1100, 1235};
        int[] dep = {1000, 1200, 1240};

        findPlatform(arr, dep, arr.length);

    }

    static int findPlatform(int arr[], int dep[], int n)
    {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int arrIndex = 0;
        int depIndex = 0;

        int max = 0;
        int platform = 0;

        while( arrIndex < arr.length && depIndex < dep.length) {
            if(dep[depIndex] >= arr[arrIndex]) {
                platform++;
                arrIndex++;
            } else {
                platform--;
                depIndex++;
            }
            max = Math.max(max, platform);

        }

        return max;

    }

}
