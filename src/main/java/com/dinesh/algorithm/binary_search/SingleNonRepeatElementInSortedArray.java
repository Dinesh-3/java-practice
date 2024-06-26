package com.dinesh.algorithm.binary_search;

/**
 *540. Single Element in a Sorted Array
 * https://leetcode.com/problems/single-element-in-a-sorted-array/description/
 *
 * https://takeuforward.org/data-structure/search-single-element-in-a-sorted-array/
 */
public class SingleNonRepeatElementInSortedArray {
    public static void main(String[] args) {
        SingleNonRepeatElementInSortedArray array = new SingleNonRepeatElementInSortedArray();

        int[] nums = { 1,1,2,2,3 };

        int result = array.singleNonDuplicateTwo(nums);

        System.out.println("result = " + result);
    }

    public int singleNonDuplicate(int[] nums) {

        if(nums.length < 2)
            return nums[0];

        int leftIndex = 0;
        int rightIndex = nums.length - 1;

        while(leftIndex <= rightIndex) {
            int middleIndex = leftIndex + ( rightIndex - leftIndex ) / 2;

            if(middleIndex + 1 >= nums.length )
                return nums[middleIndex];
            if(middleIndex - 1 < 0 && nums[middleIndex] != nums[middleIndex + 1])
                return nums[middleIndex];
            if(nums[middleIndex] != nums[middleIndex - 1] && nums[middleIndex] != nums[middleIndex + 1] )
                return nums[middleIndex];

            if((middleIndex % 2 == 1 && nums[middleIndex - 1] == nums[middleIndex]) || (middleIndex % 2 == 0 && nums[middleIndex + 1] == nums[middleIndex]))
                leftIndex = middleIndex + 1;
            else
                rightIndex = middleIndex - 1;
        }

        return -1;
    }

    public int singleNonDuplicateTwo(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while( low <= high ) {
            int mid = ( low + high ) / 2;

            if(mid - 1 < 0 && mid + 1 >= nums.length)
                return nums[mid];
            if(mid - 1 < 0 && nums[mid] != nums[mid + 1])
                return nums[mid];
            if(mid + 1 >= nums.length && nums[mid - 1] != nums[mid])
                return nums[mid];
            if(nums[mid - 1] != nums[mid] && nums[mid] != nums[mid + 1])
                return nums[mid];

            if((mid % 2 == 1 && nums[mid] == nums[mid - 1]) || (mid % 2 == 0 && nums[mid] == nums[mid + 1]))
                low = mid + 1;
            else
                high = mid - 1;
        }

        return -1;
    }
}
