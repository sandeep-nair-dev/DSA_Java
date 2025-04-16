package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step16_DynamicProgramming.Lec_3;

import java.util.Arrays;

public class P_16_3_3_GridUniquePaths2_DP9 {

    public static int memoization(int row, int col, int[][] arr, int[][] dp) {
        if (row < 0 || col < 0 || arr[row][col] == 1) return 0;
        if (row == 0 && col == 0) return 1;

        if (dp[row][col] != -1) return dp[row][col];

        return dp[row][col] = memoization(row - 1, col, arr, dp) + memoization(row, col - 1, arr, dp);
    }

    public static int tabulation(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) dp[i][j] = 0;
                else if (i == 0 && j == 0) dp[i][j] = 1;
                else {
                    int up = 0, left = 0;
                    if (i > 0) up = dp[i - 1][j];
                    if (j > 0) left = dp[i][j - 1];
                    dp[i][j] = up + left;
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static int spaceOptimization(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        int[] prevRow = new int[n];
        for (int i = 0; i < m; i++) {
            int[] currRow = new int[n];
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) currRow[j] = 0;
                else if (i == 0 && j == 0) currRow[j] = 1;
                else {
                    int up = 0, left = 0;
                    if (i > 0) up = prevRow[j];
                    if (j > 0) left = currRow[j - 1];
                    currRow[j] = up + left;
                }
            }
            prevRow = currRow;
        }
        return prevRow[n - 1];
    }

    public static void main(String[] args) {
        int[][] maze = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        int m = maze.length;
        int n = maze[0].length;
        int[][] dp = new int[m][n];
        Arrays.stream(dp).forEach(r -> Arrays.fill(r, -1));
        System.out.println("Memoization: " + memoization(m - 1, n - 1, maze, dp));
        System.out.println("Tabulation: " + tabulation(maze));
        System.out.println("Space Optimization: " + spaceOptimization(maze));
    }
}