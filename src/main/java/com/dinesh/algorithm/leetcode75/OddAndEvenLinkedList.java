package com.dinesh.algorithm.leetcode75;

/**
 * 328. Odd Even Linked List
 */
public class OddAndEvenLinkedList {
    public class Node {
        int val;
        Node next;
        Node() {}
        Node(int val) { this.val = val; }
        Node(int val, Node next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {

    }

    public Node oddEvenList(Node head) {
        var odd = head;
        var evenHead = head.next;
        var even = evenHead;
        while (even != null) {
            odd.next = odd.next.next;
            odd = odd.next;

            even.next = even.next.next;
            even = even.next;
        }

        odd.next = evenHead;
        return head;
    }

}
