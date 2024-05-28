package com.dinesh.algorithm.linked_list;

public class ReverseNodeInKGroup {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public static void main(String[] args) {
        ReverseNodeInKGroup group = new ReverseNodeInKGroup();

        ListNode head = new ListNode(1);
        ListNode node = head;
        int[] numbers = { 2,3,4,5 };
        for (int number : numbers) {
            node.next = new ListNode(number);
            node = node.next;
        }

        ListNode result = group.reverseKGroup(head, 1);

    }

    public ListNode reverseKGroup(ListNode head, int k) {
        int size = getSize(head);

        ListNode prev = null;
        ListNode current = head;

        ListNode start = head;
        ListNode prevStart = null;

        for(int i = 0; i < size / k; i++) {
            int index = 0;
            while(index < k && current != null) {
                ListNode front = current.next;
                current.next = prev;
                prev = current;
                current = front;
                index++;
            }
            if(i == 0)
                head = prev;
            else if(prevStart != null) {
                prevStart.next = prev;
            }
            prevStart = start;
            start = current;
            prev = null;
        }

        if(current != null)
            prevStart.next = current;

        return head;

    }

    private int getSize(ListNode head) {
        if(head == null)
            return 0;

        ListNode slow = head;
        ListNode fast = head;
        ListNode lastNode = fast.next;
        int size = 1;

        while(fast != null && fast.next != null) {
            if(fast.next.next == null) {
                lastNode = fast.next;
                size+= 1;
            } else {
                size+= 2;
            }
            fast = fast.next.next;
        }
        return size;
    }
}
