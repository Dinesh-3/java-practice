package com.dinesh.algorithm.string;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    static Map<Character, Integer> map = new HashMap<>();
    static {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public static void main(String[] args) {
        String s = "MCMXCIV";

        RomanToInteger roman = new RomanToInteger();
        roman.romanToInt(s);

    }

    public int romanToInt(String s) {
        int sum = 0;

        for(int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            char prevChar = s.charAt(i-1);
            if((i - 1) >= 0) {
                if(ch == 'V' && prevChar == 'I') {
                    sum += 4;
                    i++;
                } else if(ch == 'X' && prevChar == 'I') {
                    sum += 9;
                    i++;
                } else if(ch == 'L' && prevChar == 'X') {
                    sum += 40;
                    i++;
                } else if(ch == 'C' && prevChar == 'X') {
                    sum += 90;
                    i++;
                } else if(ch == 'D' && prevChar== 'C') {
                    sum += 400;
                    i++;
                } else if(ch == 'M' && prevChar == 'C') {
                    sum += 900;
                    i++;
                } else {
                    sum += map.get(ch);
                }
            } else {
                sum += map.get(ch);
            }
        }

        return sum;
    }
}
