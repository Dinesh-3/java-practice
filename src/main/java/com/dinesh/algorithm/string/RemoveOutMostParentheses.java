package com.dinesh.algorithm.string;

/**
 *
 * 1021. Remove Outermost Parentheses
 * https://leetcode.com/problems/remove-outermost-parentheses
 *
 */
public class RemoveOutMostParentheses {
    public String removeOuterParentheses(String s) {
        StringBuilder builder = new StringBuilder();

        int open = 0;

        for(char ch: s.toCharArray()) {
            if(ch == '(') {
                open++;
                if(open > 1)
                    builder.append('(');
            } else {
                if(open > 1)
                    builder.append(')');
                open--;
            }
        }

        return builder.toString();

    }
}
