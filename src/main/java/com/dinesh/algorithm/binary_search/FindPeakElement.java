package com.dinesh.algorithm.binary_search;

/**
 * Peak element in Array
 * https://takeuforward.org/data-structure/peak-element-in-array/
 * 'arr[i - 1]' < 'arr[i]' and 'arr[i + 1]' < 'arr[i]'.
 *
 * 162. Find Peak Element
 * https://leetcode.com/problems/find-peak-element/description/
 *
 */
public class FindPeakElement {

    public static void main(String[] args) {
        FindPeakElement element = new FindPeakElement();
        int[] nums = { 1, 2 };
        int result = element.findPeak(nums);

        System.out.println("result = " + result);

        System.out.println("element.findPeakElement(nums) = " + element.findPeakElement(nums));

    }

    private int findPeak(int[] numbers) {

        if(numbers.length < 2)
            return numbers[0];

        if(numbers[0] > numbers[1])
            return numbers[0];
        if(numbers[numbers.length - 2] < numbers[numbers.length - 1])
            return numbers[numbers.length - 1];

        int leftIndex = 1;
        int rightIndex = numbers.length - 2;

        while (leftIndex <= rightIndex) {
            int middleIndex = leftIndex + ( rightIndex - leftIndex ) / 2;

            if(numbers[middleIndex - 1] < numbers[middleIndex] && numbers[middleIndex] > numbers[middleIndex + 1])
                return numbers[middleIndex];

            if(numbers[middleIndex - 1] < numbers[middleIndex])
                leftIndex = middleIndex + 1;
            else
                rightIndex = middleIndex - 1;
        }

        return -1;
    }

    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        if(nums.length == 1)
            return 0;

        while( left <= right ) {
            int mid = ( left + right ) / 2;

            if(mid - 1 < 0 && mid + 1 >= nums.length)
                return mid;
            else if(mid - 1 < 0 && nums[mid] > nums[mid + 1])
                return mid;
            else if(mid + 1 >= nums.length && nums[mid - 1] < nums[mid])
                return mid;
            else if(mid - 1 >= 0 && mid + 1 < nums.length && nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1])
                return mid;

            if(nums[left] <= nums[mid])
                left = mid + 1;
            else
                right = mid - 1;
        }

        return -1;
    }

}
