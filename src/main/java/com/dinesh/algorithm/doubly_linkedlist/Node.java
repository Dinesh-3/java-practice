package com.dinesh.algorithm.doubly_linkedlist;

public class Node {
    int data;
    Node next,prev;

    public Node(int data) {
        this.data = data;
    }

    public static Node create(int[] arr) {
        if(arr == null || arr.length == 0)
            return null;
        Node head = new Node(arr[0]);

        Node prev = null;
        Node current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new Node(arr[i]);
            current.prev = prev;
            prev = current;
            current = current.next;
        }
        return head;
    }

}
