package com.dinesh.generics;

import java.util.ArrayList;
import java.util.List;

public class Example {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList();
        numbers.add(1);
//        numbers.add("2");
        System.out.println("numbers.get(0) = " + numbers.get(0));
//        for (Object number : numbers) {
//            System.out.println((String) number);
//        }

        //        Comparable number = 10;
//        number.compareTo("10");
        Comparable<Integer> number = 10;
        Integer num = 3;
        int NNN = num.compareTo(3);
        System.out.println("number.getClass() = " + number.getClass());

        System.out.println(number.compareTo(9));

    }
}
