package com.dinesh.generics;

import java.util.Arrays;
import java.util.List;

public class LowerBoundedWildcards {
    public static void main(String[] args) {
        // ? Wildcards
        // Lower Bounded Wildcards
        List<Integer> list2 = Arrays.asList(1, 2);
        List<Number> list3 = Arrays.asList(1, 2.0, 1000.34);
        //        list.add(10); // Throws UnsupportedOperationException
        printNumbers(list2);
        printNumbers(list3);
    }

    static void printNumbers(List<? super Integer> list) {
//        list.add(32);
        list.forEach(e -> {
            System.out.println(e.getClass().getName());
            System.out.println(e);
        });
    }
}
