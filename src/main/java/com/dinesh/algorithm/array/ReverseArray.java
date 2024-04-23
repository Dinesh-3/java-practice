package com.dinesh.algorithm.array;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int n = 5;
        int[] arr = { 1, 2, 5, 8 };

        reverseArrayTwoPointers(arr);

        System.out.println("arr = " + Arrays.toString(arr));
    }

    private static void reverseArrayTwoPointers(int[] array) {
        for (int i = 0; i < array.length / 2; i++)
            swap(array, i,array.length - 1-i );
    }

    private static void swap(int[] array, int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
}
