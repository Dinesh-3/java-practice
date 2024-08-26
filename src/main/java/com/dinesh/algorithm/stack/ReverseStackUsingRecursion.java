package com.dinesh.algorithm.stack;

import java.util.Stack;

/**
 *
 * Reverse a Stack
 * https://www.geeksforgeeks.org/problems/reverse-a-stack
 *
 *
 *
 */
public class ReverseStackUsingRecursion {
    static void reverse(Stack<Integer> s)
    {
        if(s.isEmpty())
            return;
        reverse(s, s.pop());
    }

    static void reverse(Stack<Integer> s, int element)
    {
        if(s.isEmpty()) {
            s.push(element);
            return;
        }
        reverse(s, s.pop());

        insertBottom(s, element);
    }

    private static void insertBottom(Stack<Integer> s, int element) {
        if(s.isEmpty()) {
            s.push(element);
            return;
        }
        int poped = s.pop();
        insertBottom(s, element);
        s.push(poped);
    }

}
