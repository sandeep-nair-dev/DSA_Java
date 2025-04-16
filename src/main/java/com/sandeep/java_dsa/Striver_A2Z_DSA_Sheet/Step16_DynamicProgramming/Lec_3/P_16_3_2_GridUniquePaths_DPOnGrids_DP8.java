package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step16_DynamicProgramming.Lec_3;

import java.util.Arrays;

public class P_16_3_2_GridUniquePaths_DPOnGrids_DP8 {

    /*For Recursion
    T.C -> O(2^(m*n))
    S.C -> (m-1)+(n-1)
    */

    /*
    T.C -> O(m*n)
    S.C -> O((m-1)+(n-1)) + O(m*n)[Recursion stack space]
     */
    public static int memoization(int currRow, int currCol, int[][] dp) {
        if (currRow == 0 && currCol == 0) {
            return 1;
        }
        if (dp[currRow][currCol] != -1) return dp[currRow][currCol];

        int down = currRow > 0 ? memoization(currRow - 1, currCol, dp) : 0;           // or we could also set if(currRow<0 && currCol<0) then return 0;
        int right = currCol > 0 ? memoization(currRow, currCol - 1, dp) : 0;
        return dp[currRow][currCol] = down + right;
    }

    /*
    T.C -> O(m*n)
    S.C -> O(m*n)
    */
    public static int tabulation(int row, int col) {
        int[][] dp = new int[row + 1][col + 1];
        dp[0][0] = 1;
        for (int i = 0; i <= row; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i <= col; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[row][col];
    }

    /*
    T.C -> O(m*n)
    S.C -> O(n)
    */
    public static int spaceOptimization(int row, int col) {
        int[] prevRow = new int[col + 1];
        for (int i = 0; i <= row; i++) {
            int[] currRow = new int[col + 1];
            for (int j = 0; j <= col; j++) {
                if (i == 0 && j == 0) {
                    currRow[j] = 1;
                } else {
                    int up = 0, left = 0;
                    if (i > 0) up = prevRow[j];
                    if (j > 0) left = currRow[j - 1];
                    currRow[j] = up + left;
                }
            }
            prevRow = currRow;
        }
        return prevRow[col];
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 7;
        int[][] dp = new int[m][n];
        Arrays.stream(dp).forEach(r -> Arrays.fill(r, -1));
        System.out.println("Memoization: " + memoization(m - 1, n - 1, dp));
        System.out.println("Tabulation: " + tabulation(m - 1, n - 1));
        System.out.println("Space Optimization: " + spaceOptimization(m - 1, n - 1));
    }
}