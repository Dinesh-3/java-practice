package com.dinesh.algorithm.leetcode75;

/**
 * 2130. Maximum Twin Sum of a Linked List
 * https://www.youtube.com/watch?v=doj95MelfSA
 */
public class MaximumTwinSumOfLinkedList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {
        ListNode list = getNode(new int[]{5,4,2,1});
        System.out.println("list = " + list);

        pairSum(list);
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

    public static int pairSum(ListNode head) {

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;
        ListNode current = head;
        while (prev != slow) {
            ListNode front = current.next;
            current.next = prev;
            prev = current;
            current = front;
        }

        int max = Integer.MIN_VALUE;

        while (current != null) {
            max = Math.max(current.val + prev.val, max);
            current = current.next;
            prev = prev.next;
        }

        return max;
    }

}
