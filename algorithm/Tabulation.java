package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Tabulation {
    public static void main(String[] args) {
//        String name = "Dinesh";
//        String substring = name.substring(1, 3);
//        System.out.println("substring = " + substring);

        int row = 5;
        int column = 5;
        int possibleWays = gridTraveler(row, column);
        System.out.println("possibleWays = " + possibleWays);
        int[] numbers = {3, 4, 5, 7};
        int targetSum = 20;

        boolean canSum = canSum(targetSum, numbers);
        System.out.println("canSum = " + canSum);

        List<Integer> howSum = howSum(targetSum, numbers);
        System.out.println("howSum = " + howSum);

        List<Integer> bestSum = bestSum(targetSum, numbers);
        System.out.println("bestSum = " + bestSum);

        String[] combinations = {"ab", "abc", "cd", "def", "abcd"};
        boolean canConstruct = canConstruct("abc", combinations);
        System.out.println("canConstruct = " + canConstruct);

//        int countConstruct = countConstruct("abcd", combinations);
//        System.out.println("countConstruct = " + countConstruct);
        List<List<String>> allConstruct = allConstruct("abcd", combinations);
        System.out.println("allConstruct = " + allConstruct);
    }

    private static int gridTraveler(int row, int column) {
        int[][] table = new int[row+1][column+1];
        table[1][1] = 1;
        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= column; j++) {
                int current = table[i][j];
                if(i+1 <= row) table[i+1][j] += current;
                if(j+1 <= column) table[i][j+1] += current;
            }
        }
        return table[row][column];
    }

    private static boolean canSum(int target, int[] numbers){
        boolean[] table = new boolean[target+1];
        table[0] = true;
        for (int i = 0; i < target+1; i++) {
            if(table[i]) {
                for (int number : numbers) {
                    if(i+number < target+1)table[i + number] = true;
                }
            }
        }
        return table[target];
    }

    private static List<Integer> howSum(int target, int[] numbers){
        List<List<Integer>> table = new ArrayList<>();
        for (int i = 0; i < target + 1; i++) {
            table.add(null);
        }
        table.set(0, new ArrayList<>());
        System.out.println("table = " + table);
        for (int i = 0; i < target+1; i++) {
            if(table.get(i) != null) {
                for (int number : numbers) {
                    if(i+number < target+1){
                        table.set(i + number, new ArrayList<>(table.get(i)));
                        table.get(i+number).add(number);
                    };
                }
            }
        }
        System.out.println("table = " + table);
        return table.get(target);
    }
    private static List<Integer> bestSum(int target, int[] numbers){
        List<List<Integer>> table = new ArrayList<>();
        for (int i = 0; i < target + 1; i++) {
            table.add(null);
        }
        table.set(0, new ArrayList<>());
        for (int i = 0; i < target+1; i++) {
            if(table.get(i) != null) {
                for (int number : numbers) {
                    int sumIndex = i + number;
                    if( sumIndex < target+1){
                        List<Integer> combination = new ArrayList<>(table.get(i));
                        combination.add(number);
                        if(table.get(sumIndex) == null || table.get(sumIndex).size() > combination.size()){
                            table.set(sumIndex, combination);
                        }
                    };
                }
            }
        }
        System.out.println("table = " + table);
        return table.get(target);
    }

    private static boolean canConstruct(String target, String[] words){
        boolean[] table = new boolean[target.length() + 1];
        table[0] = true;
        for (int i = 0; i <= target.length(); i++) {
            if (table[i]) {
                for (String word : words) {
                    if(i + word.length() <= table.length){
                        String substring = target.substring(i, i + word.length()-1);
                        System.out.println("substring = " + substring);
                        if (substring.equals(word)) {
                            table[i + word.length()] = true;
                        }
                    }
                }
            }
        }

        return table[target.length()];
    }

    private static int countConstruct(String target, String[] words){
        int[] table = new int[target.length() + 1];
        table[0] = 1;
        for (int i = 0; i <= target.length(); i++) {
            for (String word : words) {
                if(target.substring(i, i+ words.length).equals(word)){
                    table[i + word.length()] = table[i];
                }
            }

        }

        return table[target.length()];
    }

    private static List<List<String>> allConstruct(String target, String[] words){
        List<List<List<String>>> table = new ArrayList<>();
        for (int i = 0; i < target.length() + 1; i++) {
            table.add(new ArrayList<>());
        }
        table.get(0).add(new ArrayList<>());

        System.out.println("table = " + table);
        for (int i = 0; i <= target.length(); i++) {
//            if(table.get(i) != null){
                for (String word : words) {
                    if(target.substring(i, i+ words.length).equals(word)){
                        List<List<String>> lists = table.get(i).stream().peek(sub -> sub.add(word)).collect(Collectors.toList());
//                        table.get(i + word.length()).add(lists);
                    }
//                }
            }
        }

        return table.get(target.length());
    }
}
