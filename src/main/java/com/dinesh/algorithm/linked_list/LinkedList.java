package com.dinesh.algorithm.linked_list;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class LinkedList<T> {
    public class Node {
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
        if(first == null) {
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }
        size++;
    }

    public void addFirst(T item) {
        var node = new Node(item);
        if(first == null) {
            first = last = node;
        } else {
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


    /*

    L C R
    3 7 8 9

    L == null
    C = 3
    R = 7

    while(current != null) {
        Node next = current.next;
        current.next = l;

        L = C;
        C = next;
    }

    */
    private void reverseIterative() {
        Node left = first;
        Node current = first.next;
        while (current != null) {
            Node next = current.next;

            current.next = left;

            left = current;
            current = next;
        }
        last = first;
        last.next = null;
        first = left;
    }

    //Recursive
    public void reverse() {
        Node head = reverse(first);
        last = first;
        first = head;
    }

    private Node reverse(Node current) {
        if(current == null || current.next == null)
            return current;
        Node newHead = reverse(current.next);
        Node front = current.next;
        current.next = null;
        front.next = current;
        return newHead;
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

    public T getMiddle() {
        var slow = first;
        var fast = first;

        while (fast != last && fast.next != last) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.data;
    }

    public boolean hasCycle() {
        var slow = first;
        var fast = first;

        while (fast != last && fast.next != last) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                return true;
        }

        return false;
    }

    public T[] toList() {
        var array = (T[]) new Object[size];
        var current = first;
        int index = 0;
        while (current != null ) {
            array[index++] = current.data;
            current = current.next;
        }
        return array;
    }

    public Node getHead() {
        return first;
    }

    public int size() {
        return size;
    }

    private boolean isEmpty() {
        return first == null;
    }

}