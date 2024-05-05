package com.dinesh.algorithm.binary_search;

import java.util.Arrays;

/**
 * https://takeuforward.org/data-structure/aggressive-cows-detailed-solution/
 * https://www.youtube.com/watch?v=R_Mfw4ew-Vo
 */
public class AggressiveCows {
    public static void main(String[] args) {

        int[] arr = { 0,3,4,7,10,9 };
        int n = 6;
        int k = 4;

        int result = minDistanceInAggressiveCows(arr, k);
        System.out.println("result = " + result);

    }

    private static int minDistanceInAggressiveCows(int[] places, int cows) {
        Arrays.sort(places);

        int left = 1;
        int right = places[places.length - 1] - places[0];


        int result = 1;
        while (left <= right) {

            int middle = (left + right) / 2;

            if(isPossiblePlaceCows(places, middle, cows)) {
                result = middle;
                left = middle + 1;
            } else {
                right = middle - 1;
            }

        }

        return result;

    }

    private static boolean isPossiblePlaceCows(int[] places, int distance, int cows) {
        int currentDistance = 0;

        int count = 1;
        for (int i = 1; i < places.length; i++) {
            currentDistance = currentDistance + (places[i] - places[i - 1]);
            if(currentDistance >= distance ) {
                count ++;
                currentDistance = 0;
            }

            if(count == cows)
                return true;
        }
        return false;
    }


}
