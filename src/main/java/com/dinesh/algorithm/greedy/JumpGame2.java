package com.dinesh.algorithm.greedy;

/**
 *
 * 45. Jump Game II
 * https://leetcode.com/problems/jump-game-ii
 *
 */
public class JumpGame2 {
    public static void main(String[] args) {
        int[] nums = { 2,3,1,1,4 };

        JumpGame2 game = new JumpGame2();
        int count = game.jump(nums);
        System.out.println("count = " + count);
    }

    public int jump(int[] nums) {
        int left = 0;
        int right = 0;

        int count = 0;

        if(nums.length <= 1)
            return 0;

        while(right < nums.length - 1) {
            count++;
            int prevRight = right;
            for(int i = left; i <= prevRight; i++)
                right = Math.max(i + nums[i], right);
            left = prevRight + 1;
        }

        return count;

    }

}
