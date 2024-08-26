package com.dinesh.algorithm.linked_list;

public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int N = 3;
        RemoveNthNodeFromEndOfList list = new RemoveNthNodeFromEndOfList();
        ListNode head = ListNode.create(arr);
        list.removeNthFromEnd(head, N);
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
