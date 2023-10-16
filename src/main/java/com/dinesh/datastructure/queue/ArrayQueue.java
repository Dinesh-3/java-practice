package com.dinesh.datastructure.queue;

public class ArrayQueue<T> {

    private T[] array = (T[]) new Object[4];

    private int front = 0;
    private int rear = 0;

    public void enqueue(T item) {
        array[rear++] = item;
    }

    public T dequeue() {
        return array[front++];
    }

    public T peek() {
        return array[front];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return rear == array.length;
    }
}
