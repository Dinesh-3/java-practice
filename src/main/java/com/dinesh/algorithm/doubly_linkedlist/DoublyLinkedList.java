package com.dinesh.algorithm.doubly_linkedlist;

public class DoublyLinkedList {
    void addNode(Node head_ref, int pos, int data)
    {
        Node node = new Node(data);

        Node current = head_ref;
        for(int i = 0; i < pos; i++) {
            current = current.next;
            if(current == null)
                return;
        }

        Node next = current.next;

        current.next = node;

        node.prev = current;
        node.next = next;

        if(next != null)
            next.prev = node;
    }

}
