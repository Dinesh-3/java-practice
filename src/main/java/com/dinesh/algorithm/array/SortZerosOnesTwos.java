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
        int[] nums = {2,0,1};

        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while(mid <= high) {
            if(nums[mid] == 0)
                swap(nums, mid++, low++);
            else if(nums[mid] == 2)
                swap(nums, mid, high--);
            else
                mid++;
        }

    }

    private void swap(int[] numbers, int left, int right) {
        int temp = numbers[left];
        numbers[left] = numbers[right];
        numbers[right] = temp;
    }
}
