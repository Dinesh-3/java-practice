package com.dinesh.algorithm.stack;

import java.util.Stack;

/**
 * https://takeuforward.org/data-structure/implement-min-stack-o2n-and-on-space-complexity/
 *
 * Implement Min Stack : O(2N) and O(N) Space Complexity
 * https://www.youtube.com/watch?v=V09NfaGf2ao
 *
 * 155. Min Stack
 * https://leetcode.com/problems/min-stack/description/
 *
 */
class MinStack {
    private Stack<Integer> stack = new Stack<>();

    // approach one
    private Stack<Integer> mins = new Stack<>();

    // approach two
    private int min = Integer.MAX_VALUE;

    public MinStack() {

    }

    public void push(int val) {
        if(stack.isEmpty()) {
            mins.push(val);
        } else {
            int min = Math.min(mins.peek(), val);
            mins.push(min);
        }
        stack.push(val);
    }

    public void pushApproachTwo(int val) {
        if(stack.isEmpty()) {
            min = val;
            stack.push(val);
        } else {
            if(val < min) {
                stack.push(2 * val - min);
                min = val;
            }
        }
    }

    public void pop() {
        int popped = stack.pop();
        if(popped < min) {
            int result = (2 * min) - popped;
            min = result;
        }
      //  mins.pop();
    }

    public int top() {
        if(stack.empty())
            return -1;
        Integer peek = stack.peek();
        if(peek < min)
            return min;
        return peek;
    }

    public int getMin() {
        return mins.peek();
    }
}