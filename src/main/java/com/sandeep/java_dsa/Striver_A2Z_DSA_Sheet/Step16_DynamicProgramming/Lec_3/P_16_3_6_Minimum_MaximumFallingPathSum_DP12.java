package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step16_DynamicProgramming.Lec_3;

import java.util.Arrays;

public class P_16_3_6_Minimum_MaximumFallingPathSum_DP12 {

    /*
    Simple recurion:
    T.C. -> O(3^n)
    S.C. -> O(n) Recursion stack space
     */

    /*
    Memoization:
        T.C -> O(n*m)
        S.C -> O(n*m){DP array} + O(n)(Recursion Stack Space(RSS)}
     */
    public static int memoizationRoot(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        int[][] dp = new int[m][n];
        Arrays.stream(dp).forEach(r -> Arrays.fill(r, -1));
        int memoizationMinimum = Integer.MAX_VALUE;

        for (int j = 0; j < n; j++) {
            memoizationMinimum = Math.min(memoizationMinimum, memoizationHelper(m - 1, j, arr, dp));
        }
        return memoizationMinimum;
    }

    public static int memoizationHelper(int row, int col, int[][] arr, int[][] dp) {
        if (col < 0 || col >= arr[0].length) return (int) 1e8;
        if (row == 0) {
            return arr[row][col];
        }

        if (dp[row][col] != -1) return dp[row][col];
        int down = arr[row][col] + memoizationHelper(row - 1, col, arr, dp);
        int left = arr[row][col] + memoizationHelper(row - 1, col - 1, arr, dp);
        int right = arr[row][col] + memoizationHelper(row - 1, col + 1, arr, dp);
        return dp[row][col] = Math.min(left, Math.min(down, right));
    }


    /*
    Tabulation:
            T.C. ->  O(n*m) + O(n)
            S.C. -> O(n*m)
     */
    public static int tabulation(int[][] arr) {

        int m = arr.length;
        int n = arr[0].length;
        int[][] dp = new int[m][n];

        for (int j = 0; j < n; j++) {
            dp[0][j] = arr[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int left = Integer.MAX_VALUE;
                int right = Integer.MAX_VALUE;
                if (j < n - 1) left = arr[i][j] + dp[i - 1][j + 1];
                int down = arr[i][j] + dp[i - 1][j];
                if (j > 0) right = arr[i][j] + dp[i - 1][j - 1];
                dp[i][j] = Math.min(left, Math.min(down, right));
            }
        }
        int mini = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            mini = Math.min(mini, dp[m - 1][j]);
        }
        return mini;
    }

    /*
    Space Optimization:
        T.C. -> O(m*n)
        S.C -> O(n)
     */
    public static int spaceOptimization(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        int[] prevRow = arr[0].clone();
        for (int i = 1; i < m; i++) {
            int[] currRow = new int[n];
            for (int j = 0; j < n; j++) {
                int left = Integer.MAX_VALUE;
                int right = Integer.MAX_VALUE;
                int down = arr[i][j] + prevRow[j];
                if (j > 0) left = arr[i][j] + prevRow[j - 1];
                if (j < n - 1) right = arr[i][j] + prevRow[j + 1];
                currRow[j] = Math.min(left, Math.min(down, right));
            }
            prevRow = currRow;
        }

        int mini = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            mini = Integer.min(mini, prevRow[j]);
        }
        return mini;
    }

    public static void main(String[] args) {
        int[][] matrix = {{2, 1, 3}, {6, 5, 4}, {7, 8, 9}};

        System.out.println("Memoization: " + memoizationRoot(matrix));
        System.out.println("Tabulation: " + tabulation(matrix));
        System.out.println("Space Optimization: " + spaceOptimization(matrix));
    }
}
