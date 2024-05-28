package com.dinesh.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**

 * 31. Next Permutation -> https://leetcode.com/problems/next-permutation/description/
 *
 * https://takeuforward.org/data-structure/next_permutation-find-next-lexicographically-greater-permutation/
 * https://www.youtube.com/watch?v=JDOXKqF60RQ

 */
public class NextPermutation {

    public static void main(String[] args) {
        int[] arr = { 3, 2, 1 };


        // Step 1 Find the intersection where i < i + 1
        int index = 0;
        for (int i = arr.length - 1; i > 0; i--) {
            if(arr[i-1] < arr[i])
            {
                index = i - 1;
                break;
            }
        }

        if(index >= 0)
        {
            // Step 2 Find and replace minimum element which is just greater than intersection index
            int smallerMax = index + 1;
            for (int i = arr.length - 1; i >= index; i--) {
                if(arr[i] > arr[index] && arr[i] < arr[smallerMax] ) {
                    smallerMax = i;
                    break;
                }
            }

            swap(arr, smallerMax, index);
        }

        // step 3 sort the right section of the intersection array
        Arrays.sort(arr, index + 1, arr.length);

        System.out.println("arr = " + Arrays.toString(arr));
    }

    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

}
