package com.dinesh.algorithm.array;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] numbers = { 1, 1, 2 };
        removeDuplicates(numbers);
        System.out.println("numbers = " + Arrays.toString(numbers));
    }

    public static int removeDuplicates(int[] numbers) {
        int index = 0;
        for(int i = 0; i < numbers.length; i++) {
            if(numbers[index] == numbers[i])
                continue;
            else {
                numbers[++index] = numbers[i];
            }
        }

        return index;
    }
}
