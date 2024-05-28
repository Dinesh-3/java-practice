package com.dinesh.algorithm.sliding_window;

/**
 *
 * 1358. Number of Substrings Containing All Three Characters
 * https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
 *
 * https://www.youtube.com/watch?v=xtqN4qlgr8s
 */
public class NumberOfSubstringContainerAllThreeCharacters {

    public static void main(String[] args) {
        NumberOfSubstringContainerAllThreeCharacters containerAllThreeCharacters = new NumberOfSubstringContainerAllThreeCharacters();
        containerAllThreeCharacters.numberOfSubstrings("abcabc");
    }
    public int numberOfSubstrings(String s) {

        int[] lastSees = { -1, -1, -1 };

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            lastSees[s.charAt(i) - 'a'] = i;
            if(lastSees[0] != -1 && lastSees[1] != -1 && lastSees[2] != -1) // optional condition
                count += (1 + Math.min(lastSees[0], Math.min(lastSees[1],lastSees[2])));
        }
        System.out.println("count = " + count);
        return count;
    }
}
