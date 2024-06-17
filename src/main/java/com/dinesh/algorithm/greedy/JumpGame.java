package com.dinesh.algorithm.greedy;

/**
 * 55. Jump Game
 * https://leetcode.com/problems/jump-game
 *
 */
public class JumpGame {

    public static void main(String[] args) {
        int[] rooms = { 2,3,1,1,4 };
        JumpGame game = new JumpGame();
        game.canJump(rooms);
    }

    public boolean canJump(int[] nums) {
        if(nums.length == 1)
            return true;
        int maxJump = 0;

        int index = 0;
        while(index < nums.length) {
            if(maxJump < index)
                return false;
            maxJump = Math.max(maxJump, nums[index] + index);
            index++;
        }
        return true;
    }
}
