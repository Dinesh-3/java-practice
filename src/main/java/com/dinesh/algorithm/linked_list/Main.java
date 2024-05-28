package com.dinesh.algorithm.linked_list;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        list.reverse();
        System.out.println("reversed = " + Arrays.toString(list.toList()));

    }

}
