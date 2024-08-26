package com.dinesh.algorithm.stack;

import java.util.*;

/**
 * https://www.geeksforgeeks.org/problems/prefix-to-infix-conversion
 */
public class PrefixToInfix {
    private static Set<Character> operands = Set.of('+', '-', '/', '*', '^');

    public static void main(String[] args) {
        String result = prefixToInfix("*-A/BC-/AKL");
        System.out.println("result = " + result);
    }

    public static String prefixToInfix(String prefix) {
        Stack<String> stack = new Stack<>();

        for (int i = prefix.length() - 1; i >= 0; i--) {
            char c = prefix.charAt(i);

            if (operands.contains(c)) {
                String operand1 = stack.pop();
                String operand2 = stack.pop();
                String infix = "(" + operand1 + c + operand2 + ")";
                stack.push(infix);
            } else {
                stack.push(String.valueOf(c));
            }
        }

        return stack.pop();
    }

}
