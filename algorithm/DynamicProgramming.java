package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class DynamicProgramming {
    public static void main(String[] args) {
        boolean[][] grid = {
                { true, true, true, true },
                { true, true, true, true },
                { true, true, true, true },
                { true, true, true, true },
        };
//        boolean[][] grid = {
//                { true, true },
//                { false, true },
//        };
//        int possiblePaths = countAllPossiblePath(grid, 0, 0);
//        System.out.println("possiblePaths = " + possiblePaths);

        List<String> strings = letterCombinations("23");
        System.out.println("strings = " + strings);

    }

    public static int countAllPossiblePath(boolean[][] grid, int row, int col) {
        System.out.println("row = " + row + " " + "col = " + col);
        if(!validSquare(grid, row, col)) return 0;
        if(isAtEnd(grid, row, col)) return 1;
        return countAllPossiblePath(grid, row + 1, col) + countAllPossiblePath(grid, row, col + 1);
    }

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        String[] combination = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        result.add("");
        for (int digitIndex = 0; digitIndex < digits.length(); digitIndex++)
        {
            List<String> temp = new ArrayList<>();
            String characters = combination[digits.charAt(digitIndex) - '0'];
            for (int charIndex = 0; charIndex < characters.length();charIndex++)
                for (String value : result) temp.add(value + characters.charAt(charIndex));
            result = temp;
        }
        if(result.get(0).equals("")) result.remove(0);
        return result;
    }


    private static boolean isAtEnd(boolean[][] grid, int row, int col) {
        return grid.length - 1 == row && grid[0].length -1 == col;
    }

    private static boolean validSquare(boolean[][] grid, int row, int col) {
        var valid = (row <= grid.length - 1  && col <= grid[0].length -1 ) && (grid[row][col]);
        return valid;
    }
}
