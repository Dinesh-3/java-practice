package com.dinesh.algorithm.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 *
 * https://www.geeksforgeeks.org/problems/infix-to-postfix-1587115620
 * https://takeuforward.org/data-structure/infix-to-postfix/
 *
 */
public class InfixToPostfix {

    public static void main(String[] args) {
        String result = infixToPostfix("a+b*(c^d-e)^(f+g*h)-i");
        System.out.println("result = " + result);
    }

    private static Set<Character> operands = Set.of('+', '-', '/', '*', '^');
    private static Map<Character, Integer> map = new HashMap<>();

    static {
        map.put('+', 1);
        map.put('-', 1);
        map.put('*', 2);
        map.put('/', 2);
        map.put('^', 3);
    }

    // Function to convert an infix expression to a postfix expression.
    public static String infixToPostfix(String exp) {
        Stack<Character> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if(operands.contains(ch)) {
                while(!stack.isEmpty() && map.containsKey(stack.peek()) && map.get(stack.peek()) >= map.get(ch))
                    builder.append(stack.pop());
                stack.push(ch);
            }else if(ch == '(')
                stack.push('(');
            else if(ch == ')') {
                while(!stack.isEmpty() && stack.peek() != '(')
                    builder.append(stack.pop());
                stack.pop();
            } else
                builder.append(ch);
        }
        while(!stack.isEmpty())
            builder.append(stack.pop());


        return builder.toString();


    }
}
