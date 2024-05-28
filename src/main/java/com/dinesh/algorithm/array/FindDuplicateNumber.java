package com.dinesh.algorithm.array;

/**
 *
 * 287. Find the Duplicate Number
 * https://leetcode.com/problems/find-the-duplicate-number
 *
 * https://takeuforward.org/data-structure/find-the-duplicate-in-an-array-of-n1-integers/
 * https://www.youtube.com/watch?v=32Ll35mhWg0
 *
 */
public class FindDuplicateNumber {
    public static void main(String[] args) {

    }

    public int findDuplicate(int[] nums) {

        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow != fast);

        fast = nums[0];

        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

}
