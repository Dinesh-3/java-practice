package com.dinesh.algorithm.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1926. Nearest Exit from Entrance in Maze
 */
public class NearestExitFromEntranceMaze {
    public static void main(String[] args) {
        char[][] arr = {
                {'+','.','+','+','+','+','+'},
                {'+','.','+','.','.','.','+'},
                {'+','.','+','.','+','.','+'},
                {'+','.','.','.','+','.','+'},
                {'+','+','+','+','+','.','+'}};
        int[] entrance = { 0,1 };

        var maze = new NearestExitFromEntranceMaze();
        maze.nearestExit(arr, entrance);
    }
    class Pair {
        int i;
        int j;
        int distance;
        public Pair(int i, int j, int distance) {
            this.i = i;
            this.j = j;
            this.distance = distance;
        }
    }
    public int nearestExit(char[][] maze, int[] entrance) {
        int row = maze.length;
        int col = maze[0].length;

        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(entrance[0], entrance[1], 0));
        maze[entrance[0]][entrance[1]] = '+';

        int[][] paths = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

        while(!queue.isEmpty()) {
            Pair pair = queue.remove();
            for(int[] path: paths) {
                int rowIndex = pair.i + path[0];
                int colIndex = pair.j + path[1];
                if(rowIndex >= 0 && rowIndex < row
                        && colIndex >= 0 && colIndex < col
                        && maze[rowIndex][colIndex] == '.') {
                    maze[rowIndex][colIndex] = '+';
                    var newPair = new Pair(rowIndex, colIndex, pair.distance + 1);
                    if(isEnd(newPair, maze))
                        return newPair.distance;
                    queue.add(newPair);
                }
            }
        }
        return -1;

    }

    private boolean isEnd(Pair pair, char[][] maze) {
        int row = maze.length;
        int col = maze[0].length;
        return pair.i == 0 || pair.i == row - 1 || pair.j == 0 || pair.j == col - 1;
    }
}
