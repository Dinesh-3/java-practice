package com.dinesh.algorithm.leetcode75;

public class ReverseLinkedList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {
        ListNode head = getNode(new int[]{1,2,3,4,5});

        //ListNode listNode = reverseList(head);
        ListNode reverseListRecursion = reverseListRecursion(head);

    }

    //[1,2]
    private static ListNode reverseListRecursion(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode newHead = reverseListRecursion(head);
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }

    private static ListNode getNode(int[] ints) {
        ListNode head = new ListNode(ints[0]);

        ListNode current = head;
        for (int i = 1; i < ints.length; i++) {
            current.next = new ListNode(ints[i]);
            current = current.next;
        }
        return head;
    }

    public static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode previous = null;
        ListNode current = head;

        while(current != null) {
            ListNode front = current.next;
            current.next = previous;
            previous = current;
            current = front;
        }
        return previous;
    }
}
