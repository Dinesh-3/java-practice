package com.dinesh.algorithm.stack;

import java.util.Set;
import java.util.Stack;

/**
 *
 * Postfix to Prefix Conversion
 * https://www.geeksforgeeks.org/problems/postfix-to-prefix-conversion
 *
 */
public class PostfixToPrefixConversion {
    private static Set<Character> operands = Set.of('+', '-', '/', '*', '^');

    public static void main(String[] args) {
        String result = postToPre("ABC/-AK/L-*");
        System.out.println("result = " + result);
    }

    static String postToPre(String post_exp) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < post_exp.length(); i++) {
            char ch = post_exp.charAt(i);
            if(operands.contains(ch)) {
                String one = stack.pop();
                String two = stack.pop();
                stack.push(ch + two + one);
            } else {
                stack.push(String.valueOf(ch));
            }
        }

        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty())
            builder.append(stack.pop());

        return builder.toString();
    }

}
