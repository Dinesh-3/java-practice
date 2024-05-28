package com.dinesh.algorithm.linked_list;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class DetectCycle {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        boolean isLoop = false;
        while( fast != null && fast.next != null ) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                isLoop = true;
                break;
            }
        }

        if(!isLoop)
            return null;

        slow = head;
        while( fast != null ) {
            if(slow == fast)
                return slow;
            slow = slow.next;
            fast = fast.next;

        }

        return null;
    }
}