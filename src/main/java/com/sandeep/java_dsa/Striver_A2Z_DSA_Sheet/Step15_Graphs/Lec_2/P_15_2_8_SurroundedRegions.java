package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step15_Graphs.Lec_2;

import java.util.Arrays;

public class P_15_2_8_SurroundedRegions {

    private static void dfs(int row, int col, char[][] board, int[][] vis, int[] drow, int[] dcol, int m, int n) {
        vis[row][col] = 1;

        for (int i = 0; i < 4; i++) {
            int r = row + drow[i];
            int c = col + dcol[i];
            if (r >= 0 && r < m && c >= 0 && c < n && vis[r][c] == 0 && board[r][c]=='O') {
                dfs(r, c, board, vis, drow, dcol, m, n);
            }
        }
    }

    public static char[][] boardAfterSurround(char[][] board) {
        int[] drow = {0, -1, 0, 1};
        int[] dcol = {-1, 0, 1, 0};
        int m = board.length;
        int n = board[0].length;

        int[][] vis = new int[m][n];
        char[][] result = new char[m][n];

        for (int i = 0; i < m; i++) {
            if (vis[i][0] == 0 && board[i][0]=='O') {
                dfs(i, 0, board, vis, drow, dcol, m, n);
            }
            if (vis[i][n - 1] == 0 && board[i][n - 1]=='O') {
                dfs(i, n - 1, board, vis, drow, dcol, m, n);
            }
        }

        for (int j = 0; j < n; j++) {
            if (vis[0][j] == 0 && board[0][j]=='O') {
                dfs(0, j, board, vis, drow, dcol, m, n);
            }
            if (vis[m - 1][j] == 0 && board[m - 1][j]=='O') {
                dfs(m - 1, j, board, vis, drow, dcol, m, n);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (vis[i][j] == 1) {
                    result[i][j] = 'O';
                } else {
                    result[i][j] = 'X';
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        System.out.println(Arrays.deepToString(boardAfterSurround(board)));
    }
}
