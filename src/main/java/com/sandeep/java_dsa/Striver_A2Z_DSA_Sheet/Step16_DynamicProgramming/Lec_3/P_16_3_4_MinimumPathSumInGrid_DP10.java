package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step16_DynamicProgramming.Lec_3;

import java.util.Arrays;

public class P_16_3_4_MinimumPathSumInGrid_DP10 {

    public static int memoization(int row, int col, int[][] arr, int[][] dp) {
        if (row == 0 && col == 0) {
            return arr[row][col];
        }
        if (row < 0 || col < 0) return 0;
        if (dp[row][col] != -1) return dp[row][col];
        int up = Integer.MAX_VALUE, left = Integer.MAX_VALUE;
        if (row > 0) up = arr[row][col] + memoization(row - 1, col, arr, dp);
        if (col > 0) left = arr[row][col] + memoization(row, col - 1, arr, dp);
        return Math.min(up, left);
    }

    public static int tabulation(int[][] arr) {
        int[][] dp = new int[arr.length][arr[0].length];
        Arrays.stream(dp).forEach(r -> Arrays.fill(r, -1));
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (i == 0 && j == 0) dp[i][j] = arr[i][j];
                else {
                    int right = Integer.MAX_VALUE, down = Integer.MAX_VALUE;
                    if (i > 0) down = arr[i][j] + dp[i - 1][j];
                    if (j > 0) right = arr[i][j] + dp[i][j - 1];
                    dp[i][j] = Math.min(down, right);
                }
            }
        }
        return dp[arr.length - 1][arr[0].length - 1];
    }

    public static int spaceOptimization(int[][] arr) {
        int[] prevRow = new int[arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            int[] currRow = new int[arr[0].length];
            for (int j = 0; j < arr[0].length; j++) {
                if (i == 0 && j == 0) currRow[j] = arr[i][j];
                else {
                    int down = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
                    if (i > 0) down = arr[i][j] + prevRow[j];
                    if (j > 0) right = arr[i][j] + currRow[j - 1];
                    currRow[j] = Math.min(down, right);
                }
            }
            prevRow = currRow;
        }
        return prevRow[arr[0].length - 1];
    }

    public static void main(String[] args) {

        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};

        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[m][n];
        Arrays.stream(dp).forEach(r -> Arrays.fill(r, -1));
        System.out.println("Memoization: " + memoization(m - 1, n - 1, grid, dp));
        System.out.println("Tabulation: " + tabulation(grid));
        System.out.println("Space Optimization: " + spaceOptimization(grid));
    }
}