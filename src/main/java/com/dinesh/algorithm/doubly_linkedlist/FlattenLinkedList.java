package com.dinesh.algorithm.doubly_linkedlist;

/**
 *
 * Flattening a Linked List
 * https://www.geeksforgeeks.org/problems/flattening-a-linked-list
 *
 */
public class FlattenLinkedList {
    public class Node {
        int data;
        Node next;
        Node bottom;

        public Node(int data) {
            this.data = data;
        }

    }

    Node flatten(Node root) {
        if(root == null || root.next == null)
            return root;
        Node prev = flatten(root.next);

        return merge(root, prev);
    }

    private Node merge(Node left, Node right) {
        if(left != null)
            left.next = null;
        if(right != null)
            right.next = null;

        Node root = new Node(-1);

        Node current = root;

        while(left != null && right != null) {
            if(left.data < right.data) {
                current.bottom = left;
                left = left.bottom;
            } else {
                current.bottom = right;
                right = right.bottom;
            }

            current = current.bottom;
            current.bottom = null;
        }

        if(left != null)
            current.bottom = left;
        if(right != null)
            current.bottom = right;

        return root.bottom;

    }

}
