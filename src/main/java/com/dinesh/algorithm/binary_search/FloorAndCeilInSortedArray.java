package com.dinesh.algorithm.binary_search;

public class FloorAndCeilInSortedArray {
    public static void main(String[] args) {
        int input = 25;

        int[] array = { 10, 20, 30, 40 };

        int left = 0;
        int right = array.length - 1;

        while (left < right) {

            int midIndex = left + (right - left) / 2;

            if(array[midIndex] == input) {
                System.out.println("mid = " + array[midIndex]);
                break;
            }
            if(array[midIndex] < input)
                left = midIndex + 1;
            else
                right = midIndex - 1;

        }

        System.out.println("floor = " + array[left - 1]);
        System.out.println("ceil = " + array[right + 1]);
    }
}
