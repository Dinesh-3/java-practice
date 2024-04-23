package com.dinesh.algorithm.array;

import java.util.ArrayList;
import java.util.List;

public class RotateArrayByK {
    public static void main(String[] args) {
        int[] numbers = { -1,-100,3,99 };
        int k = 2;

        for (int i = 0; i < numbers.length / 2; i++)
            swap(numbers, i,numbers.length - 1 - i );

        for (int i = 0; i < k / 2; i++)
            swap(numbers, i,k - 1 -i );

        for (int i = k; i < ((numbers.length + k) / 2); i++)
            swap(numbers, i,numbers.length - 1 + k - i );

    }

    private static void swap(int[] array, int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

}
