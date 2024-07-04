package com.dinesh.algorithm.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 130. Surrounded Regions
 * https://leetcode.com/problems/surrounded-regions
 *
 */
public class SurroundedRegions {

    public static void main(String[] args) {
        char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        SurroundedRegions regions = new SurroundedRegions();
        regions.solve(board);

        regions.solveBFS(new char[][]{{'O', 'X', 'O'}, {'X', 'O', 'X'}, {'O', 'X', 'O'}});
    }

    public void solve(char[][] board) {

        int n = board.length;
        int m = board[0].length;

        int[][] visited = new int[n][m];

        for(int i = 0; i < m; i++) {
            if(board[0][i] == 'O' && visited[0][i] == 0)
                dfs(0, i, board, visited, n, m);
        }
        for(int i = 0; i < m; i++) {
            if(board[n-1][i] == 'O' && visited[n-1][i] == 0)
                dfs(n-1, i, board, visited, n, m);
        }

        for(int i = 0; i < n; i++) {
            if(board[i][0] == 'O' && visited[i][0] == 0)
                dfs(i, 0, board, visited, n, m);
        }

        for(int i = 0; i < n; i++) {
            if(board[i][m-1] == 'O' && visited[i][m-1] == 0)
                dfs(i, m-1, board, visited, n, m);
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] == 'O' && visited[i][j] == 0)
                    board[i][j] = 'X';
            }
        }


    }

    public void dfs(int row, int col, char[][] board, int[][] visited, int n, int m) {
        visited[row][col] = 1;

        int[] rowP = { -1, 0, 1, 0 };
        int[] colP = { 0, 1, 0, -1 };

        for(int i = 0; i < 4; i++) {
            int rowIndex = row + rowP[i];
            int colIndex = col + colP[i];

            if(rowIndex >=0 && rowIndex < n && colIndex >= 0 && colIndex < m
                    && visited[rowIndex][colIndex] == 0 && board[rowIndex][colIndex] == 'O'
            ) {
                visited[rowIndex][colIndex] = 1;
                dfs(rowIndex, colIndex, board, visited, n, m);
            }

        }

    }

    class Node {
        int i = 0;
        int j = 0;
        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public void solveBFS(char[][] board) {
        int r = board.length;
        int c = board[0].length;

        Queue<Node> queue = new LinkedList<>();

        for(int i = 0; i < c; i++) {
            if(board[0][i] == 'O')
                queue.add(new Node(0, i));

            if(board[r - 1][i] == 'O')
                queue.add(new Node(r - 1, i));
        }

        for(int i = 0; i < r; i++) {
            if(board[i][0] == 'O')
                queue.add(new Node(i, 0));

            if(board[i][c-1] == 'O')
                queue.add(new Node(i, c-1));
        }

        int[] rowP = { -1, 0, 1, 0 };
        int[] colP = { 0, 1, 0, -1 };;

        while(!queue.isEmpty()) {
            Node node = queue.remove();
            board[node.i][node.j] = '1';

            for(int i = 0; i < rowP.length; i++) {
                int rowIndex = node.i + rowP[i];
                int colIndex = node.j + colP[i];
                if(rowIndex >= 0 && rowIndex < r && colIndex >= 0 && colIndex < c
                        && board[rowIndex][colIndex] == 'O'
                ) {
                    board[rowIndex][colIndex] = '1';
                    queue.add(new Node(rowIndex, colIndex));
                }
            }
        }

        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(board[i][j] == '1')
                    board[i][j] = 'O';
                else
                    board[i][j] = 'X';
            }
        }

    }

}
