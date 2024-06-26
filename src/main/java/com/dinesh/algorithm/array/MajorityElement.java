package com.dinesh.algorithm.array;

/**
 * 169. Majority Element -> https://leetcode.com/problems/majority-element/description/
 */
public class MajorityElement {
    public static void main(String[] args) {
        int[] numbers = { 10,9,9,9,10 };

        MajorityElement element = new MajorityElement();
        element.majorityElement(numbers);
        element.mooresVotingAlgorithm(numbers);
        element.majorityElementA(numbers);
    }

    public int majorityElementA(int[] nums) {
        int major = -1;
        int count = 0;

        for(int i = 0; i < nums.length; i++) {
            if(count == 0) {
                major = nums[i];
                count++;
            } else {
                if(major == nums[i])
                    count++;
                else
                    count--;
            }
        }

        count = 0;
        for (int num : nums)
            if (num == major)
                count++;

        if(count >= nums.length / 2)
            return major;

        return -1;

    }

    public int majorityElement(int[] nums) {
        int maxFrequency = nums.length / 2;

        int[] numbers = new int[256];
        for(int i = 0; i < nums.length; i++)
            numbers[nums[i]]++;

        for(int num: nums)
            if(numbers[num] > maxFrequency)
                return num;
        return -1;
    }

    public int mooresVotingAlgorithm(int[] nums) {

        int element = -1;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if(count == 0) {
                element = nums[i];
                count++;
            } else {
                if(nums[i] == element)
                    count++;
                else
                    count--;
            }
        }

        return -1;
    }
}
