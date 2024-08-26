package com.dinesh.algorithm.stack;

import java.util.Set;
import java.util.Stack;

/**
 *
 * https://www.geeksforgeeks.org/problems/prefix-to-postfix-conversion
 *
 */
public class PrefixToPostFix {
    private static Set<Character> operands = Set.of('+', '-', '/', '*', '^');

    public static void main(String[] args) {
        String result = preToPost("*-A/BC-/AKL");
        System.out.println("result = " + result);
    }

    static String preToPost(String pre_exp) {
        Stack<String> stack = new Stack<>();

        for (int i = pre_exp.length() - 1; i >= 0 ; i--) {
            char ch = pre_exp.charAt(i);
            if(operands.contains(ch)) {
                String op1 = stack.pop();
                String op2 = stack.pop();
                stack.push(op1 + op2 + ch);
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
