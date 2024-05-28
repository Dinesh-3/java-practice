package com.dinesh.algorithm.linked_list;

/**
 *
 * 234. Palindrome Linked List
 * https://leetcode.com/problems/palindrome-linked-list/
 */
public class CheckIsPalindrome {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public boolean isPalindrome(ListNode head) {
        if(head == null)
            return false;
        if(head.next == null)
            return true;
        ListNode slow = head;
        ListNode fast = head;

        ListNode prev = null;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;

            ListNode front = slow.next;
            slow.next = prev;
            prev = slow;
            slow = front;
        }

        if(fast != null)
            slow = slow.next;
        System.out.println(slow.val);
        System.out.println(prev.val);
        while(slow != null) {
            if(slow.val != prev.val)
                return false;
            slow = slow.next;
            prev = prev.next;
        }

        return true;
    }

    public ListNode oddEvenList(ListNode head) {
        int index = 0;

        if(head == null || head.next == null)
            return head;

        ListNode odd = head;
        ListNode firstEven = head.next;
        ListNode even = firstEven;
        while(even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }

        odd.next = firstEven;

        return head;
    }

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k <= 0)
            return head;
        ListNode slow = head;
        ListNode fast = head;
        ListNode lastNode = fast;
        int index = 0;

        while(fast != null && fast.next != null) {
            if(fast.next.next == null) {
                lastNode = fast.next;
                index+= 1;
            } else {
                index+= 2;
            }

            fast = fast.next.next;
        }

        if(index + 1 == k)
            return head;

        if(fast != null)
            lastNode = fast;

        int module = k % (index+1);

        System.out.println(index);
        System.out.println(module);

        slow = head;
        fast = head;

        int fasIndex = 0;
        module = (index+1) % 2 == 0 ? module - 1 : module;
        while(fasIndex < module) {
            fast = fast.next;
            fasIndex+= 1;
        }
        System.out.println(fasIndex);
        System.out.println(fast.val);

        ListNode newHead = fast.next;
        fast.next = null;
        lastNode.next = head;

        return newHead;

    }
}
