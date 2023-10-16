package com.dinesh.algorithm.backtracking;

import java.util.HashSet;
import java.util.Set;

public class Backtracking {

    private static char[][] words = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'F'},
    };

    public static void main(String[] args) {


        boolean isWordExist = isWordPresent("AED");
        System.out.println("isWordExist = " + isWordExist);
    }

    private static boolean isWordPresent(String word) {

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[0].length; j++) {
                if(depthFirstSearch(i, j, word, 0))
                    return true;
            }
        }

        return false;
    }

    private static boolean depthFirstSearch(int i, int j, String word, int index) {
        if(index >= words.length)
            return true;

        Set<String> set = new HashSet<>();
        if(
            i < 0 || j < 0 ||
            words.length <= i ||
            words[0].length <= j ||
            words[i][j] != word.charAt(index) ||
            set.contains(i + "," + j)
        )
            return false;

        set.add(i + "," + j);

        index++;
        boolean result = (
                depthFirstSearch(i + 1, j, word, index) ||
                depthFirstSearch(i - 1, j, word, index) ||
                depthFirstSearch(i, j + 1, word, index) ||
                depthFirstSearch(i, j - 1, word, index)
                );
        set.remove(i + "," + j);
        return result;
    }
}
