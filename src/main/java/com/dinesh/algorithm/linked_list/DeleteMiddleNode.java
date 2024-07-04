package com.dinesh.algorithm.linked_list;

public class DeleteMiddleNode {
    public static void main(String[] args) {
        DeleteMiddleNode node = new DeleteMiddleNode();
        int[] arr = { 1,3,4,7,1,2,6 };
        ListNode head = ListNode.create(arr);
        node.deleteMiddle(head);
    }
    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null)
            return null;
        ListNode slow = head;
        ListNode fast = head.next.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if(slow.next != null)
            slow.next = slow.next.next;

        return head;
    }
}
