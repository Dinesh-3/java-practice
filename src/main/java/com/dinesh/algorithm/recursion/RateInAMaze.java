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

class RateInAMaze {

    static class Path {
        int i;
        int j;
        char move;

        public Path(int i, int j, char move) {
            this.i = i;
            this.j = j;
            this.move = move;
        }

        public static Path[] getPaths() {
            Path[] paths = { new Path(1,0,'D'), new Path(0,1,'R'), new Path(-1,0,'U'), new Path(0,-1,'L') };
            return paths;
        }
    }

    public ArrayList<String> findPath(int[][] mat) {
        ArrayList<String> res = new ArrayList<>();

        int row = mat.length;
        int col = mat[0].length;

        if(mat[0][0] == 0 || mat[row-1][col-1] == 0)
            return res;
        dfs(0, 0, new StringBuilder(), res, mat);

        return res;
    }

    private void dfs(int i, int j, StringBuilder builder, ArrayList<String> res, int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        if(i == (row-1) && j == (col-1)) {
            res.add(builder.toString());
            return;
        }

        Path[] paths = Path.getPaths();

        if(mat[i][j] == 1)
            mat[i][j] = -1;
        for(Path path: paths) {
            int r = i + path.i;
            int c = j + path.j;

            if(r < row && c < col && r >= 0 && c >= 0 && mat[r][c] == 1) {
                builder.append(path.move);
                dfs(r, c, builder, res, mat);
                builder.deleteCharAt(builder.length()-1);
            }
        }

        if(mat[i][j] == -1)
            mat[i][j] = 1;
    }
}
