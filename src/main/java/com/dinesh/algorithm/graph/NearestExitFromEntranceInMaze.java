package com.dinesh.algorithm.graph;

import java.util.*;

public class NearestExitFromEntranceInMaze {
    public static void main(String[] args) {
        String[][] maze = {{"+","+",".","+"},{".",".",".","+"},{"+","+","+","."}};

        int[] entrance = {1,2};

        Map<String, List<String>> edges = new HashMap<>();

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if(Objects.equals(maze[i][j], ".")) {
                    if(edges.containsKey(i+""))
                        edges.get(i+"").add(j+"");
                    else
                    {
                        List<String> list = new ArrayList<>();
                        list.add(j+"");
                        edges.put(i+"", list);
                    }
                }

            }
        }


    }
}
