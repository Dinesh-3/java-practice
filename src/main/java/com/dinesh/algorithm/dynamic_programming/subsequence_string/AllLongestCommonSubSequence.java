package com.dinesh.algorithm.dynamic_programming.subsequence_string;

import java.util.ArrayList;
import java.util.List;

public class AllLongestCommonSubSequence {
    public List<String> all_longest_common_subsequences(String s, String t) {
        List<String> list = new ArrayList<>();

        StringBuilder builder = new StringBuilder();

        allLCS(s.length()-1, t.length()-1, s, t, list, builder);
        return list;
    }


    private void allLCS(int i1, int i2, String t1, String t2, List<String> list, StringBuilder builder) {


        if(t1.charAt(i1) == t2.charAt(i2)) {
            builder.append(t1.charAt(i1));
            allLCS(i1-1, i2-1, t1, t2, list, builder);
            return;
        }

        allLCS(i1-1, i2, t1, t2, list, builder);
        allLCS(i1, i2-1, t1, t2, list, builder);
    }

}
