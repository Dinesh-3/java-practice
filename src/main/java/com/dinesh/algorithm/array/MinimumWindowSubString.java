package com.dinesh.algorithm.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MinimumWindowSubString {
    public static void main(String[] args) {
        String input = "ddaaabbca";
        String t = "abc";

        int[] map = new int[256];
        for (char ch : t.toCharArray())
            map[ch]++;

        int minLength = Integer.MAX_VALUE;
        int startIndex = -1;

        int targetCount = t.length();

        int leftIndex = 0;
        int rightIndex = 0;

        int count = 0;

        while (rightIndex < input.length()) {
            char ch = input.charAt(rightIndex);
            if(map[ch] > 0)
                count++;
            map[ch]--;
            while (count == targetCount && leftIndex < rightIndex ) {
                var leftChar = input.charAt(leftIndex);

                int newLength = rightIndex - leftIndex + 1;

                if(newLength < minLength)
                {
                    minLength = newLength;
                    startIndex = leftIndex;
                }
                map[leftChar]--;
                if(map[leftChar] > 0)
                    count--;
                leftIndex++;
            }

            rightIndex++;
        }

        //String result = startIndex == -1 ? "" : input.substring(startIndex,  );

//        System.out.println("result = " + result);

    }
}
