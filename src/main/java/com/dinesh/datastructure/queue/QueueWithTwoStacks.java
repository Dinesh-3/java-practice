package com.dinesh.datastructure.queue;

import java.util.Stack;

public class QueueWithTwoStacks<T> {
    private Stack<T> enqueueStack = new Stack<>();
    private Stack<T> dequeueStack = new Stack<>();

    public void enqueue(T item) {
        enqueueStack.push(item);
    }

    public T dequeue() {
        if(isEmpty())
            throw new IllegalArgumentException();

        migrateEnqueueToDequeueStack();

        return dequeueStack.pop();
    }

    private void migrateEnqueueToDequeueStack() {
        if(dequeueStack.empty())
            while (!enqueueStack.empty())
                dequeueStack.push(enqueueStack.pop());
    }

    public T peek() {
        migrateEnqueueToDequeueStack();
        return dequeueStack.peek();
    }

    public boolean isEmpty() {
        return enqueueStack.isEmpty() && dequeueStack.isEmpty();
    }
}
