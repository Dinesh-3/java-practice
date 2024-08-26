package com.dinesh.algorithm.recursion;

import java.util.ArrayList;

/**
 *
 * Rat in a Maze Problem - I
 * https://www.geeksforgeeks.org/problems/rat-in-a-maze-problem
 *
 *
 * https://takeuforward.org/data-structure/rat-in-a-maze/
 * https://www.youtube.com/watch?v=bLGZhJlt4y0
 *
 */
public class RateInAMaze {
    class Path {
        int i;
        int j;
        char dir;
        public Path(int i, int j, char dir) {
            this.i = i;
            this.j = j;
            this.dir = dir;
        }
    }

    public ArrayList<String> findPath(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;

        ArrayList<String> result = new ArrayList<>();

        int[][] visited = new int[row][col];
        if(mat[0][0] == 1)
            generatePaths(0, 0, "", result, mat, visited);
        return result;

    }

    private void generatePaths(int i, int j, String path, ArrayList<String> result, int[][] mat, int[][] visited) {
        int row = mat.length;
        int col = mat[0].length;

        if(i >= row - 1 && j >= col - 1) {
            result.add(path);
            return;
        }

        Path[] paths = { new Path(1,0, 'D'), new Path(0,-1, 'L'), new Path(0,1, 'R'), new Path(-1,0, 'U'),};

        visited[i][j] = 1;

        for(Path dir: paths) {
            int rowIndex = i + dir.i;
            int colIndex = j + dir.j;
            if(rowIndex >= 0 && rowIndex < row && colIndex >= 0 && colIndex < col
                    && mat[rowIndex][colIndex] == 1 && visited[rowIndex][colIndex] == 0)
                generatePaths(i+dir.i, j+dir.j, path + dir.dir, result, mat, visited);

        }

        visited[i][j] = 0;

    }

}
