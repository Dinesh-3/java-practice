package com.dinesh.algorithm.recursion;

import java.util.ArrayList;
import java.util.List;


/**
 * 22. Generate Parentheses
 * https://leetcode.com/problems/generate-parentheses
 * https://www.youtube.com/watch?v=WW1rYrR3tTI
 */
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        StringBuilder builder = new StringBuilder();
        List<String> result = new ArrayList<>();
        generate(0,0,n,result, "");
        return result;
    }

    private static void generate(int open, int close, int n, List<String> result, String ps) {
        if(ps.length() == n*2) {
            result.add(ps);
            return;
        }

        if(open < n)
            generate(open+1,close,n,result, ps + '(');

        if(close < open)
            generate(open,close+1,n,result, ps + ')');

    }
}
