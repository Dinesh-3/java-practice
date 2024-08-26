package com.dinesh.algorithm.stack;

import java.util.Set;
import java.util.Stack;

/**
 *
 * Postfix to Infix Conversion
 * https://www.geeksforgeeks.org/problems/postfix-to-infix-conversion
 *
 *
 */
public class PostfixToInfixConversion {
    private static Set<Character> operands = Set.of('+', '-', '/', '*', '^');

    public static void main(String[] args) {
        String result = postToInfix("ab*c+");
        System.out.println("result = " + result);
    }
    static String postToInfix(String exp) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if(operands.contains(ch)) {
                String one = stack.pop();
                String two = stack.pop();
                stack.push('(' + two + ch + one + ')');
            } else {
                stack.push(String.valueOf(ch));
            }
        }

        return stack.pop();
    }
}
