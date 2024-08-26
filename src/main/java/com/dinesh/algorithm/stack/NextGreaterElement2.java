package com.dinesh.algorithm.stack;


import java.util.Stack;

/**
 *
 *
 *
 */
public class NextGreaterElement2 {
    public int[] nextGreaterElements(int[] nums) {
        int[] elements = new int[nums.length];

        Stack<Integer> stack = new Stack<>();

        for(int i = 2 * nums.length - 1; i >= 0; i--) {
            int number = nums[i % nums.length];
            while(!stack.isEmpty() && stack.peek() <= number)
                stack.pop();
            if(i < nums.length)
                elements[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(number);
        }

        return elements;
    }

}
