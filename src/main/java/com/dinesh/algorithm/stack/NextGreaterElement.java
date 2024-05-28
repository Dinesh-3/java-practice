package com.dinesh.algorithm.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *
 * 496. Next Greater Element I
 * https://leetcode.com/problems/next-greater-element-i
 *
 * https://takeuforward.org/data-structure/next-greater-element-using-stack/
 * https://www.youtube.com/watch?v=Du881K7Jtk8
 */
public class NextGreaterElement {

    public static void main(String[] args) {

        int[] result = { 5, 3, 1, 2, 5, 3, 1, 2, 4, 6 };



        NextGreaterElement element = new NextGreaterElement();
        int[] elements = element.getAllNextGreaterElement(result);
        System.out.println("elements = " + Arrays.toString(elements));


        int[] input2 = {1,3,4,2};
        Map<Integer, Integer> elementMap = element.getAllNextGreaterElementMap(input2);
        System.out.println("elementMap = " + elementMap);
    }

    // Without Circle
    private int[] getAllNextGreaterElement(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];
        stack.push(arr[arr.length - 1]);
        for(int i = arr.length - 2; i >= 0; i--) {
            int ele = arr[i];
            if(stack.empty()) {
                result[i] = -1;
            } else if (stack.peek() > ele) {
                result[i] = stack.peek();
            } else {
                while (!stack.empty() && stack.peek() <= ele)
                    stack.pop();
                if(stack.empty())
                    result[i] = -1;
                else
                    result[i] = stack.peek();
            }
            stack.push(ele);
        }

        if(stack.empty())
            result[arr.length - 1] = -1;
        else {
            while (!stack.empty() && stack.peek() <= arr[arr.length - 1])
                stack.pop();
            if(stack.empty())
                result[arr.length - 1] = -1;
            else
                result[arr.length - 1] = stack.peek();
        }

        return result;

    }


    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = getAllNextGreaterElementMap(nums2);

        int[] result = new int[nums1.length];

        for(int i = 0; i < nums1.length; i++)
            result[i]= map.get(nums1[i]);

        return result;
    }

    private Map<Integer, Integer> getAllNextGreaterElementMap(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = arr.length - 1; i >= 0; i--) {
            int ele = arr[i];

            while (!stack.empty() && stack.peek() <= ele)
                stack.pop();

            if(stack.empty())
                map.put(ele, -1);
            else
                map.put(ele, stack.peek());

            stack.push(ele);
        }

        return map;

    }


}
