package com.dinesh.algorithm.linked_list;

/**
 *
 * 138. Copy List with Random Pointer
 * https://leetcode.com/problems/copy-list-with-random-pointer
 *
 */
public class CloneLinkedListWithRandomPointer {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.next = new Node(2);
        root.next.next = new Node(3);
        root.next.next.next = new Node(4);

        var list = new CloneLinkedListWithRandomPointer();
        list.copyRandomList(root);
    }

    public Node copyRandomList(Node head) {
        Node current = head;

        while(current != null) {
            Node next = current.next;
            current.next = new Node(current.val);
            current = next;
        }

        // Node newHead = head.next;
        // Node newCurr = newHead;
        // current = head;

        // while(current != null) {
        //     newCurr.random = current.random.next;
        //     current = current.next.next;
        //     newCurr.next = newCurr.next.next;
        //     newCurr = newCurr.next;
        // }

        return head;

    }
}
