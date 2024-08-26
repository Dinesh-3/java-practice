package com.dinesh.algorithm.stack;

import java.util.Collections;
import java.util.Stack;

/**
 *
 * 402. Remove K Digits
 * https://leetcode.com/problems/remove-k-digits/
 *
 * https://www.youtube.com/watch?v=jmbuRzYPGrg
 *
 */
public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);
            while(k > 0 && !stack.isEmpty() && ch < stack.peek()) {
                stack.pop();
                --k;
            }

            stack.push(ch);
        }

        while(k > 0) {
            stack.pop();
            --k;
        }

        Collections.reverse(stack);

        while(!stack.isEmpty() && stack.peek() == '0')
            stack.pop();

        if(stack.isEmpty())
            stack.push('0');

        StringBuilder builder = new StringBuilder();
        while(!stack.isEmpty())
            builder.append(stack.pop());

        return builder.toString();
    }
}
