package com.dinesh.algorithm.array;

/**
 *
 * https://takeuforward.org/data-structure/sort-an-array-of-0s-1s-and-2s/
 */
public class SortZerosOnesTwos {
    public static void main(String[] args) {
        SortZerosOnesTwos sort = new SortZerosOnesTwos();
        sort.dutchNationalFlagAlgorithm();
    }

    public void dutchNationalFlagAlgorithm() {
        int[] numbers = {2,0,1};

        int left = 0;
        int mid = 0;
        int right = numbers.length - 1;

        while (mid <= right) {

            if(numbers[mid] == 2)
            {
                swap(numbers, right, mid);
                right--;
            } else if(numbers[mid] == 1) {
                mid++;
            }else if(numbers[mid] == 0)
            {
                swap(numbers, left, mid);
                left++;
                mid++;
            }
        }

    }

    private void swap(int[] numbers, int left, int right) {
        int temp = numbers[left];
        numbers[left] = numbers[right];
        numbers[right] = temp;
    }
}
