package com.dinesh.algorithm.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 *
 * Nearest Smaller Element
 * https://www.interviewbit.com/problems/nearest-smaller-element/
 *
 */
public class NearestSmallestElement {
    public static void main(String[] args) {
        int[] numbers = { 3, 2, 1 };

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < numbers.length; i++) {
            while (!stack.isEmpty() && stack.peek() >= numbers[i])
                stack.pop();
            int number = numbers[i];
            numbers[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(number);
        }

        System.out.println(Arrays.toString(numbers));

    }
}
