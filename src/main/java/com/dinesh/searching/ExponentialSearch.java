package com.dinesh.searching;

public class ExponentialSearch {
    public static void main(String[] args) {
        int[] numbers = {2, 5, 6,7,8,9,12,23,34,56,67};

        int index2 = findIndex(numbers, 43);

        System.out.println("index = " + index2);
    }

    private static int findIndex(int[] numbers, int target) {
        int bound = 1;

        while (bound < numbers.length && numbers[bound] < target) {
            bound += 2;
        }

        int left = bound / 2;
        int right = Math.min(bound, numbers.length - 1);

        return searching.BinarySearch.recursion(numbers, target, left, right);
    }
}
