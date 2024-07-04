package com.dinesh.algorithm.linked_list;

public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList list = new RemoveNthNodeFromEndOfList();
        ListNode one = new ListNode(1);
        one.next = new ListNode(2);
        list.removeNthFromEnd(one, 2);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null)
            return head;
        ListNode current = head;
        ListNode delayed = head;

        int index = 0;

        while(current != null) {
            if(index > n)
                delayed = delayed.next;
            current = current.next;
            index++;
        }

        if (n == index) {
            ListNode next = delayed.next;
            head.next = null;
            return next;
        }

        if(delayed != null && delayed.next != null)
            delayed.next = delayed.next.next;
        else
            head = null;
        return head;
    }
}
