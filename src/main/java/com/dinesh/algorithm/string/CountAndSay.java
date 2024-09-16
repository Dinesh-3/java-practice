package com.dinesh.algorithm.string;

/**
 *
 * 38. Count and Say
 * https://leetcode.com/problems/count-and-say
 *
 */
public class CountAndSay {
    public String countAndSay(int n) {
        if(n <= 0)
            return "";

        String prev = "1";
        for(int i = 1; i < n; i++) {
            StringBuilder builder = new StringBuilder();
            int index = 0;
            while(index < prev.length()) {
                index++;
                int count = 1;
                while(index < prev.length() && prev.charAt(index) == prev.charAt(index-1)) {
                    count++;
                    index++;
                }
                builder.append(count + "" + prev.charAt(index-1));
            }

            prev = builder.toString();
        }


        return prev;
    }
}
