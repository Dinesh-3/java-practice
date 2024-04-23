package com.dinesh.algorithm.leetcode75;
import java.util.*;
public class EqualRowAndColumnPair {
    public static void main(String[] args) {

    }

    public int equalPairs(int[][] grid) {
        Map<String, Integer> rowSet = new HashMap<>();
        Map<String, Integer> columnSet = new HashMap<>();

        for(int i = 0; i < grid.length; i++) {
            StringBuilder builder = new StringBuilder();
            for(int j = 0; j < grid.length; j++) {
                if(j == grid.length - 1)
                    builder.append(grid[i][j]);
                else
                    builder.append(grid[i][j] + '_');
            }
            String key = builder.toString();
            rowSet.put(key, rowSet.getOrDefault(key, 0) + 1);
        }

        for(int i = 0; i < grid.length; i++) {
            StringBuilder builder = new StringBuilder();
            for(int j = 0; j < grid.length; j++) {
                if(j == grid.length - 1)
                    builder.append(grid[j][i]);
                else
                    builder.append(grid[j][i] + '_');
            }
            String key = builder.toString();
            columnSet.put(key, columnSet.getOrDefault(key, 0) + 1);
        }

        int count = 0;
        for(var entry: rowSet.entrySet()) {
            String key = entry.getKey();
            if(columnSet.containsKey(key))
                count += rowSet.get(key) * columnSet.get(key);
        }

        return count;
    }
}
