package com.dinesh.algorithm.sliding_window;

public class MinimumWindowSubsequence {
    static String minWindow(String str1, String str2) {
        int sl = str1.length();
        int tl = str2.length();

        String result = "";
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < sl; i++) {
            if(str1.charAt(i) == str2.charAt(0)) {
                int k = i;
                int j = 0;

                while(k < sl && j < tl) {
                    if(str1.charAt(k) == str2.charAt(j))
                        j++;
                    k++;
                }

                String newString = str1.substring(i, k);

                if(j == tl && newString.length() < min ) {
                    min = newString.length();
                    result = newString;
                }

            }

        }

        return result;

    }

    public static void main(String[] args) {
        MinimumWindowSubsequence mws = new MinimumWindowSubsequence();
        String S = "abcdebdde";
        String T = "bde";
        System.out.println(mws.minWindow(S, T));
    }

}
