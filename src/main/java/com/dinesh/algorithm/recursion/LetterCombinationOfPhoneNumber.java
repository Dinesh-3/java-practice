package com.dinesh.algorithm.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 17. Letter Combinations of a Phone Number
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 *
 */
public class LetterCombinationOfPhoneNumber {
    private static String[] pads = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        generate(0, digits, builder, result);
        return result;
    }

    private void generate(int index, String digits, StringBuilder builder, List<String> result) {
        if(index == digits.length()) {
            String comb = builder.toString();
            if(!comb.isEmpty())
                result.add(comb);
            return;
        }

        String letters = pads[Integer.parseInt(digits.charAt(index) + "")];
        for(int i = 0; i < letters.length(); i++) {
            builder.append(letters.charAt(i));
            generate(index + 1, digits, builder, result);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}
