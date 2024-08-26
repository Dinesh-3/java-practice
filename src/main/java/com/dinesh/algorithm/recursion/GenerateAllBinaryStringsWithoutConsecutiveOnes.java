package com.dinesh.algorithm.recursion;

public class GenerateAllBinaryStringsWithoutConsecutiveOnes {
    public static void main(String[] args) {
        int len = 4;
        char[] chars = new char[len];
        chars[0] = '0';
        printAllSubStrings(1, chars);
        chars[0] = '1';
        printAllSubStrings(1, chars);
    }

    private static void printAllSubStrings(int i, char[] chars) {
        if(i >= chars.length) {
            System.out.println(new String(chars));
            return;
        }

        if(chars[i-1] == '0') {
            chars[i] = '0';
            printAllSubStrings(i+1, chars);
            chars[i] = '1';
            printAllSubStrings(i+1, chars);
        }

        if(chars[i-1] == '1') {
            chars[i] = '0';
            printAllSubStrings(i+1, chars);
        }
    }
}
