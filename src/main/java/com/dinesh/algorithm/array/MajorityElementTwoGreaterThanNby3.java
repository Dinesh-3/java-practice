package com.dinesh.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * https://takeuforward.org/data-structure/majority-elementsn-3-times-find-the-elements-that-appears-more-than-n-3-times-in-the-array/
 * https://www.youtube.com/watch?v=vwZj1K0e9U8
 *
 * 229. Majority Element II
 * https://leetcode.com/problems/majority-element-ii
 */
public class MajorityElementTwoGreaterThanNby3 {

    public static void main(String[] args) {
        MajorityElementTwoGreaterThanNby3 majority = new MajorityElementTwoGreaterThanNby3();
    }

    public List<Integer> majorityElementMySolution(int[] nums) {
        Arrays.sort(nums);

        List<Integer> result = new ArrayList<>();
        int limit = (nums.length / 3);
        int left = 0;
        while( left < nums.length ) {
            if(left + limit < nums.length && nums[left + limit] == nums[left]) {
                if(!result.contains(nums[left]))
                    result.add(nums[left]);
                if(limit == 0)
                    left+= 1;
                else
                    left = left + limit;
            }
            else
                left++;
        }

        return result;

    }

    class Bucket {
        int num;
        int count;
    }
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        var bucket1 = new Bucket();
        var bucket2 = new Bucket();
        String[] numbers = {"1", "2", "3", "4", "5"};

        for (int num : nums) {
            if (bucket1.count == 0 && num != bucket2.num) {
                bucket1.num = num;
                bucket1.count = 1;
            } else if (bucket2.count == 0 && num != bucket1.num) {
                bucket2.num = num;
                bucket2.count = 1;
            } else if (num == bucket1.num)
                bucket1.count += 1;
            else if (num == bucket2.num)
                bucket2.count += 1;
            else {
                bucket1.count -= 1;
                bucket2.count -= 1;
            }
        }

        bucket1.count = 0;
        bucket2.count = 0;

        for (int num : nums) {
            if (bucket1.num == num)
                bucket1.count++;
            if (bucket2.num == num)
                bucket2.count++;
        }

        List<Integer> result = new ArrayList<>();

        if(bucket1.count > (n/3))
            result.add(bucket1.num);

        if(bucket2.count > (n/3) && bucket2.num != bucket1.num)
            result.add(bucket2.num);

        return result;
    }

}
