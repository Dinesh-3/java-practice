package com.dinesh.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
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

    public List<Integer> majorityElement(int[] nums) {
        int[] e1 = { 0, -1 };
        int[] e2 = { 0, 0 };

        for(int i = 0; i < nums.length; i++) {
            if(e1[0] == 0 && nums[i] != e2[1]) {
                e1[0] = 1;
                e1[1] = nums[i];
            }
            else if(e2[0] == 0 && nums[i] != e1[1]) {
                e2[0] = 1;
                e2[1] = nums[i];
            }
            else if(e1[1] == nums[i])
                e1[0]++;
            else if (e2[1] == nums[i])
                e2[0]++;
            else {
                e1[0]--;
                e2[0]--;
            }
        }

        e1[0] = e2[0] = 0;

        List<Integer> result = new ArrayList<>();
        int targetCount = (nums.length / 3) + 1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == e1[1])
                e1[0]++;
            else if(nums[i] == e2[1])
                e2[0]++;

            if(e1[0] == targetCount && !result.contains(e1[1]))
                result.add(e1[1]);
            if(e2[0] == targetCount && !result.contains(e2[1]))
                result.add(e2[1]);

            if(result.size() == 2)
                break;
        }

        return result;

    }

}
