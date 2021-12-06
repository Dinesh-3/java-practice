package algorithm;

import java.util.HashMap;
import java.util.Map;

public class Practise {
    public static void main(String[] args) {
        BalancedParentheses parentheses = new BalancedParentheses();
        boolean valid = parentheses.isValid("[[()]{[()]}]");
        System.out.println("valid = " + valid);

        int n = 100_000;
        int totalPaths = countTotalPaths(n, 0, 0, new int[n+1][n+1]);
        System.out.println("totalPaths = " + totalPaths);

        Map<String, Object> pressure = new HashMap<>();
        pressure.put("blood", "normal");
        pressure.put("oxygen", "normal");

        Map<String, Object> bio = new HashMap<>();
        bio.put("blood", "B+");
        bio.put("age", "21");
        bio.put("pressure", pressure);

        Map<String, Object> map = new HashMap<>();
        map.put("first_name", "Dinesh");
        map.put("last_name", "I");
        map.put("bio", bio);
        map.put("email", "dinesh@gmail.com");

        System.out.println("map = " + map);

        readHashMap(map, "");

    }

    private static Object readHashMap(Map<String, Object> map, String name) {
        for (String key : map.keySet()) {
            String path = name == "" ? key : name + " -> " + key;
            if(map.get(key) instanceof Map) readHashMap((Map<String, Object>) map.get(key), path);
            else System.out.println(path + " = " + map.get(key));
        }
        return null;
    }

    private static int countTotalPaths(int n, int row, int column, int[][] mem) {
        if(row > n || column > n) return 0;
        if(row == n && column == n) return 1;
        if(mem[row][column] == 0){
            mem[row][column] = countTotalPaths(n,row+1, column, mem) + countTotalPaths(n, row, column+1, mem);
        }

        return mem[row][column];
    }

    private static void countMaxOccurringDigit() {
        char[] chars = ("afssjzzz").toCharArray();

        int[] counts = new int[26];
        int maxIndex = 0;
        for(char item: chars)
            if(++counts[item - 97] > counts[maxIndex])
                maxIndex = item - 97;

        System.out.println( (char) (maxIndex + 97) + " = " + counts[maxIndex]);
    }
}
