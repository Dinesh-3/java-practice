package com.dinesh.algorithm.linked_list;

public class SortLinkedList012 {
    class Node
    {
        int data;
        Node next;
        Node(int data)
        {
            this.data = data;
            next = null;
        }
    }
    static Node segregate(Node head) {
        Node ones = null;
        Node twos = null;
        Node threes = null;

        Node onesEnd = null;
        Node twosEnd = null;
        Node threesEnd = null;

        Node current = head;

        while(current != null) {
            Node next = current.next;
            if(current.data == 0) {
                if(ones == null){
                    ones = current;
                    onesEnd = ones;
                } else {
                    onesEnd.next = current;
                    onesEnd = onesEnd.next;
                }

            }

            if(current.data == 1) {
                if(twos == null){
                    twos = current;
                    twosEnd = twos;
                } else {
                    twosEnd.next = current;
                    twosEnd = twosEnd.next;
                }

            }

            if(current.data == 2) {
                if(threes == null){
                    threes = current;
                    threesEnd = threes;
                } else {
                    threesEnd.next = current;
                    threesEnd = threesEnd.next;
                }

            }

            current = next;

        }

        if(onesEnd != null)
            onesEnd.next = twos;

        if(twosEnd != null)
            twosEnd.next = threes;
        else if(onesEnd != null)
            onesEnd.next = threes;

        if(threesEnd != null)
            threesEnd.next = null;



        if(ones == null && twos == null)
            return threes;

        if(ones == null)
            return twos;


        return ones;

    }

}
