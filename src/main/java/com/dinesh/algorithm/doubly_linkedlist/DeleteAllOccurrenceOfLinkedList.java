package com.dinesh.algorithm.doubly_linkedlist;

/**
 *
 * Delete all occurrences of a given key in a doubly linked list
 * https://www.geeksforgeeks.org/problems/delete-all-occurrences-of-a-given-key-in-a-doubly-linked-list
 *
 */
public class DeleteAllOccurrenceOfLinkedList {

    public static void main(String[] args) {
        Node head = Node.create(new int[]{2, 5, 2, 4, 8, 10, 2, 2});
        deleteAllOccurOfX(head, 2);
    }

    static Node deleteAllOccurOfX(Node head, int x) {

        while(head != null && head.data == x) {
            head = head.next;
        }

        if(head == null)
            return null;

        Node current = head;
        while(current != null) {
            Node next = current.next;
            while (next != null && next.data == x) {
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
