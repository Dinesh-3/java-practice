package com.dinesh.algorithm.linked_list;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        return reverse(head);
    }

    private ListNode reverse(ListNode node) {
        if(node == null || node.next == null)
            return node;

        ListNode last = reverse(node.next);
        ListNode front = node.next;
        node.next = null;
        front.next = node;
        return last;
    }
}
