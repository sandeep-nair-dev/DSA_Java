package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step16_DynamicProgramming.Lec_3;

import java.util.Arrays;

public class P_16_3_7_3D_DP_NinjaAndHisFriends_DP13 {

    private static int memoizationRoot(int[][] matrix) {
        int[][][] dp = new int[matrix.length][matrix[0].length][matrix[0].length];
        Arrays.stream(dp).forEach(dp2 -> Arrays.stream(dp2).forEach(dp3 -> Arrays.fill(dp3, -1)));
        return memoization(0, 0, matrix[0].length - 1, matrix, dp);
    }

    private static int memoization(int i, int j1, int j2, int[][] arr, int[][][] dp) {
        if (j1 < 0 || j1 >= arr[0].length || j2 < 0 || j2 >= arr[0].length) {
            return (int) -1e8;
        }
        if (i == arr.length - 1) {
            if (j1 == j2) return arr[i][j1];
            else return arr[i][j1] + arr[i][j2];
        }

        if (dp[i][j1][j2] != -1) return dp[i][j1][j2];
        int maxi = Integer.MIN_VALUE;
        for (int d1 = -1; d1 <= 1; d1++) {
            for (int d2 = -1; d2 <= 1; d2++) {
                int ans;
                if (j1 == j2) ans = arr[i][j1] + memoization(i + 1, j1 + d1, j2 + d2, arr, dp);
                else ans = arr[i][j1] + arr[i][j2] + memoization(i + 1, j1 + d1, j2 + d2, arr, dp);
                maxi = Math.max(maxi, ans);
            }
        }
        return dp[i][j1][j2] = maxi;
    }

//    private static int tabulation(int[][] arr){
//        int[][][] dp = new int[arr.length][arr[0].length+1][arr[0].length+1];
//        for(int i=0;i<=arr.length;i++){
//
//        }
//    }

    public static void main(String[] args) {

        int matrix[][] = {{2, 3, 1, 2},
                {3, 4, 2, 2},
                {5, 6, 3, 5}};
        System.out.println("Memoization: " + memoizationRoot(matrix));
//        System.out.println("Tabulation: " + tabulation(matrix));
//        System.out.println("Space Optimization: " + spaceOptimization(matrix));
    }
}