package com.dinesh.algorithm.linked_list;

/**
 *
 * https://www.youtube.com/watch?v=8ocB7a_c-Cc
 *
 * https://leetcode.com/problems/sort-list
 */
public class SortLinkedList {
    public static void main(String[] args) {
        SortLinkedList list = new SortLinkedList();
        ListNode node = ListNode.create(new int[]{4, 2, 1, 3});
        ListNode result = list.sortList(node);
    }
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalf = slow.next;
        slow.next = null;

        ListNode first = sortList(head);
        ListNode second = sortList(secondHalf);

        return mergeNodes(first, second);

    }

    private ListNode mergeNodes(ListNode first, ListNode second) {
        ListNode current = null;
        if(first.val < second.val) {
            current = first;
            first = first.next;
        } else {
            current = second;
            second = second.next;
        }
        ListNode head = current;
        while(first != null && second != null) {
            if(first.val < second.val) {
                current.next = first;
                first = first.next;
            } else {
                current.next = second;
                second = second.next;
            }
            current = current.next;
            current.next = null;
        }

        while(first != null) {
            current.next = first;
            first = first.next;
            current = current.next;
            current.next = null;
        }

        while(second != null) {
            current.next = second;
            second = second.next;
            current = current.next;
            current.next = null;
        }

        return head;
    }
}
