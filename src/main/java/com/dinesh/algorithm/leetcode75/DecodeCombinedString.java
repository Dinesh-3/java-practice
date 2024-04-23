package com.dinesh.algorithm.leetcode75;
import java.util.*;
/**
 * 394. Decode String
 */
public class DecodeCombinedString {

    public static void main(String[] args) {
        decodeString("3[a]2[bc]");
    }

    public static String decodeString(String s) {
        Stack<Character> stack = new Stack<>();

        for(var ch: s.toCharArray()) {
            if(ch == ']') {
                StringBuilder letters = new StringBuilder();
                while(stack.peek() != '[')
                    letters.insert(0, stack.pop());
                stack.pop();

                StringBuilder digit = new StringBuilder();
                while(!stack.isEmpty() && Character.isDigit(stack.peek()))
                    digit.insert(0, stack.pop());

                StringBuilder repeated = new StringBuilder();
                repeated.append(String.valueOf(letters).repeat(Math.max(0, Integer.parseInt(digit.toString()))));

                for(var lt: repeated.toString().toCharArray())
                    stack.push(lt);

            } else {
                stack.push(ch);
            }
        }

        StringBuilder builder = new StringBuilder();

        for (Character character : stack) builder.append(character);

        return builder.toString();

    }
}
