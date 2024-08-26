package com.dinesh.generics;

import java.util.ArrayList;
import java.util.List;

public class LowerBoundedWildcardExample {
    public static void addNumbers(List<? super Integer> list) {
        for (int i = 1; i <= 5; i++) {
            list.add(i);
        }
    }

    public static void main(String[] args) {
        List<Number> numberList = new ArrayList<>();
        List<Integer> integerList = new ArrayList<>();
        List<Object> objectList = new ArrayList<>();

        addNumbers(integerList);
        addNumbers(numberList);
        addNumbers(objectList);

        System.out.println(numberList);
        System.out.println(objectList);
    }
}
