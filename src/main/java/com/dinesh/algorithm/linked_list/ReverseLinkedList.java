package com.dinesh.algorithm.linked_list;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        return reverse(head);
    }

    private ListNode reverse(ListNode node) {
        if(node == null || node.next == null)
            return node;

        ListNode last = reverse(node.next);
        ListNode next = node.next;
        node.next = null;
        next.next = node;
        return last;
    }
}
