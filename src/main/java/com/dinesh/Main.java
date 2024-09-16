package com.dinesh;

import java.util.*;

public class Main {

    public static void main(String[] args) {
//        commonStrings();


//        int index = 0;
//        while(numbers[index] != -1) {
//
//        }

        int[] numbers = {0, 1, 2, 3, 4, 5, 6, -1};

        int indexOne = 0;
        int indexTwo = 0;

        while (true) {
            indexOne += 1;
            indexTwo += 2;

            if(numbers[indexTwo-1] == -1)
                break;
            if(numbers[indexTwo] == -1)
                break;
        }

        System.out.println("indexOne = " + indexOne);

    }

    private static void commonStrings() {
        String[] names1 = {"one", "two", "three"};
        String[] names2 = {"two", "five", "seven", "three"};

        Map<String, Integer> map = new HashMap<>();

        for(String name: names1)
            map.put(name, map.getOrDefault(name, 0) + 1);

        List<String> result = new ArrayList<>();

        for (String name: names2) {
            if(map.containsKey(name))
                result.add(name);
        }

        System.out.println("result = " + result);
    }


}