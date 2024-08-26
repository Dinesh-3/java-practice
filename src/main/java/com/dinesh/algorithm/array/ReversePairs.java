package com.dinesh.algorithm.array;

public class ReversePairs {

    public static void main(String[] args) {
        int[] nums = {1,3,2,3,1};
        ReversePairs pairs = new ReversePairs();
        pairs.reversePairs(nums);
    }

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int low, int high) {
        if(low >= high)
            return 0;

        int count = 0;

        int mid = (low+high) / 2;

        count += mergeSort(nums, low, mid);
        count += mergeSort(nums, mid+1, high);
        count += count(nums, low, mid, high);
        merge(nums, low, mid, high);
        return count;
    }

    private int count(int[] nums, int low, int mid, int high) {
        int count = 0;

        int index = mid+1;
        for(int i = low; i <= mid; i++) {
            while(index <= high && nums[i] > ((long)2 * nums[index]))
                index++;
            count = count + (index - (mid+1));
        }

        return count;

    }

    private void merge(int[] nums, int low, int mid, int high) {

        int left = low;
        int right = mid + 1;

        int srIndex = 0;
        int[] arr = new int[high-low+1];
        while(left <= mid & right <= high) {
            if(nums[left] <= nums[right])
                arr[srIndex++] = nums[left++];
            else
                arr[srIndex++] = nums[right++];
        }

        while(left <= mid) arr[srIndex++] = nums[left++];

        while(right <= high) arr[srIndex++] = nums[right++];

        for(int i = low; i <= high; i++)
            nums[i] = arr[i-low];

    }

}
