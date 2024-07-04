package com.dinesh.algorithm.recursion;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    public static void main(String[] args) {
        String input = "ABC";

        List<String> sets = new ArrayList<>();
        int length = input.length();

        for (int i = 0; i < (1 << length); i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < length; j++)
                if((i & 1 << j) != 0) // Checking i'th bit is set or not
                    builder.append(input.charAt(j));
            sets.add(builder.toString());
        }

        System.out.println("sets = " + sets);

    }
}
