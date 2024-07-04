package com.dinesh.algorithm.linked_list;

public class AddOneNumberToLinkedList {
    public static void main(String[] args) {
        int[] arr = { 4, 5, 6 };
        ListNode head = ListNode.create(arr);
        addOne(head);
    }
    public static ListNode addOne(ListNode head)
    {
        int[] num = new int[]{ 0 };

        sum(head, num);
        if(num[0] != 0) {
            var node = new ListNode(num[0]);
            node.next = head;
            return node;
        }

        return head;
    }


    public static void sum(ListNode node, int[] rem)
    {
        if(node == null || node.next == null) {
            int sum = node.val + 1;
            node.val = sum % 10;
            rem[0] = sum / 10;
            return;
        }


        sum(node.next, rem);
        int sum = node.val + rem[0];
        node.val = sum % 10;
        rem[0] = sum / 10;
    }

}
