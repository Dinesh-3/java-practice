package com.dinesh.algorithm.leetcode75;

/**
 * 2095. Delete the Middle Node of a Linked List
 */
public class DeleteMiddleNodeInLinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode deleteMiddle(ListNode head) {
        if(head.next == null)
            return null;
        ListNode slowPrev = head;
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null &&fast.next != null) {
            slowPrev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(slow != null)
            slowPrev.next = slowPrev.next.next;
        return head;
    }
}
