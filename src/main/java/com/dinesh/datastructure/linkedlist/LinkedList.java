package com.dinesh.datastructure.linkedlist;

import java.util.Arrays;
import java.util.NoSuchElementException;

 class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

}

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
    public void reverse() {
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
        var array = (T[]) new Object[size + 1];
        var current = first;
        int index = 0;
        while (current != null ) {
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

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            list.addLast(i);
        }
        ListNode one = new ListNode(-9);
        ListNode two = new ListNode(5);

        int[] list1 = {3};
        int[] list2 = {7};

        ListNode current = one;

        for (int i = 0; i < list1.length; i++) {
            current.next = new ListNode(list1[i]);
            current = current.next;
        }

        current = two;
        for (int i = 0; i < list2.length; i++) {
            current.next = new ListNode(list2[i]);
            current = current.next;
        }

//        list.mergeTwoLists(one, two);
        System.out.println(Arrays.toString(list.toList()));
    }
}
