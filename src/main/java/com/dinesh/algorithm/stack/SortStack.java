package com.dinesh.algorithm.stack;

import java.util.Stack;

public class SortStack {
    public Stack<Integer> sort(Stack<Integer> s) {
        Stack<Integer> stack = new Stack<>();

        while(!s.isEmpty()) {
            int poped = s.pop();

            while(!stack.isEmpty() && stack.peek() < poped)
                s.push(stack.pop());

            stack.push(poped);
        }

        while(!stack.isEmpty())
            s.push(stack.pop());

        return s;

    }

}
