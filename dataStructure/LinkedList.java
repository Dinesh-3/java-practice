package dataStructure;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

public class LinkedList<T> {
    private class Node {
        private T data;
        private Node next;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node first;
    private Node last;
    private int size;

    public void addLast(T item) {
        var node = new Node(item);
        if (first == null) first = last = node;
        else {
            last.next = node;
            last = node;
        }
        size++;
    }

    public void addFirst(T item) {
        var node = new Node(item);
        if (first == null) first = last = node;
        else {
            node.next = first;
            first = node;
        }
    }

    public void removeFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        var second = first.next;
        first.next = null;
        first = second;
        size--;
    }

    public void removeLast() {
        if (isEmpty()) throw new NoSuchElementException();
        if (first == last)
            first = last = null;
        else {
            var previousNode = getPrevious(last);
            last = previousNode;
            previousNode.next = null;
        }
        size--;
    }

    private Node getPrevious(Node node) {
        var current = first;
        while (current != null) {
            if (current.next == node) return current;
            current = current.next;
        }
        return null;
    }

    public void reverse() {
        var previous = first;
        var current = first.next;
        while (current != null) {
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        last = first;
        last.next = null;
        first = previous;

    }

    public T getKthFromTheEND(int kth) {
        if(kth > size) return null;
        if(kth == size) return first.data;

        var head = first;
        var tail = first;

        for (int i = 0; i < kth -1; i++) {
            tail = tail.next;
        }

        while (tail != last) {
            head = head.next;
            tail = tail.next;
        }

        return head.data;
    }

    public int indexOf(T item) {
        int index = 0;
        var current = first;
        while (current.next != null) {
            if (current.data == item) return index;
            current = current.next;
            index++;
        }
        if (current.data == item) return index;
        return -1;
    }

    public boolean contains(T item) {
        return indexOf(item) != -1;
    }

    public T[] toList() {
        var array = (T[]) new Object[size];
        var current = first;
        int index = 0;
        while (current != null) {
            array[index++] = current.data;
            current = current.next;
        }
        return array;
    }

    public int size() {
        return size;
    }

    private boolean isEmpty() {
        return first == null;
    }
}
