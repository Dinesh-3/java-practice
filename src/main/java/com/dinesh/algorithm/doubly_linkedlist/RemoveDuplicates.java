package com.dinesh.algorithm.doubly_linkedlist;

/**
 * Remove duplicates from a sorted doubly linked list
 * https://www.geeksforgeeks.org/problems/remove-duplicates-from-a-sorted-doubly-linked-list
 */
public class RemoveDuplicates {
    Node removeDuplicates(Node head){
        if(head == null)
            return null;

        Node current = head;

        while(current != null) {
            Node next = current.next;
            while(next != null && current.data == next.data) {
                next = next.next;
            }
            if(next != null)
                next.prev = current;
            current.next = next;
            current = next;

        }

        return head;


    }
}
