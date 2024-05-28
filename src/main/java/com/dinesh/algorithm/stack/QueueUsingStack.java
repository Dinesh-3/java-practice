package com.dinesh.algorithm.stack;

import java.util.Stack;

public class QueueUsingStack {
    Stack<Integer> stackOne = new Stack<>();
    Stack<Integer> stackTwo = new Stack<>();

    public void add(int item) {
        stackOne.add(item);
    }

    public int remove() {
        if(stackTwo.isEmpty())
            while (!stackOne.isEmpty())
                stackTwo.push(stackTwo.pop());
        return stackTwo.pop();
    }

    public int peek() {
        return stackTwo.peek();
    }

}

