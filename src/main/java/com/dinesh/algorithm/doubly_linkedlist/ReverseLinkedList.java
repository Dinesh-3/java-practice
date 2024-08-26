package com.dinesh.algorithm.doubly_linkedlist;

/**
 *
 * Reverse a Doubly Linked List
 * https://www.geeksforgeeks.org/problems/reverse-a-doubly-linked-list
 *
 * https://takeuforward.org/data-structure/reverse-a-doubly-linked-list/
 * https://www.youtube.com/watch?v=u3WUW2qe6ww
 *
 */
public class ReverseLinkedList {
    public static Node reverseDLL(Node  head)
    {
        if(head == null)
            return head;

        if(head.next == null)
            return head;


        Node prev = null;
        Node current = head;

        while(current != null) {

            prev = current.prev;

            current.prev = current.next;
            current.next = prev;

            current = current.prev;
        }

        return prev.prev;

    }
}
