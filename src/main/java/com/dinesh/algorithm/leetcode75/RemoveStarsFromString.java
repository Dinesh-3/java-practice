package com.dinesh.algorithm.leetcode75;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 2390. Removing Stars From a String
 */
public class RemoveStarsFromString {
    public static void main(String[] args) {

    }

    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();

        for(var ch: s.toCharArray()) {
            if(ch == '*')
                stack.pop();
            else
                stack.push(ch);
        }

        StringBuilder builder = new StringBuilder();

        for (Character character : stack) builder.append(character);

        return builder.toString();
    }
}
