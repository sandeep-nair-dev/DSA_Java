package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step16_DynamicProgramming.Lec_4;

import java.util.Arrays;

public class P_16_4_9_CoinChange2_DP_22 {


    private static int memoizationRoot(int[] arr, int target) {
        int[][] dp = new int[arr.length][target + 1];
        Arrays.stream(dp).forEach(t -> Arrays.fill(t, -1));
        return memoization(arr.length - 1, arr, target, dp);
    }

    private static int memoization(int ind, int[] arr, int target, int[][] dp) {
        if (ind == 0) {
            if (target % arr[0] == 0) return 1;
            else return 0;
        }

        if (dp[ind][target] != -1) return dp[ind][target];
        int notPick = memoization(ind - 1, arr, target, dp);
        int pick = 0;
        if (arr[ind] <= target) pick = memoization(ind, arr, target - arr[ind], dp);

        return dp[ind][target] = pick + notPick;
    }

    private static int tabulation(int[] arr, int target) {
        int[][] dp = new int[arr.length][target + 1];
        for (int i = 0; i <= target; i++) {
            if (i % arr[0] == 0) dp[0][i] = 1;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j <= target; j++) {
                int notPick = dp[i - 1][j];
                int pick = 0;
                if (arr[i] <= j) pick = dp[i][j - arr[i]];
                dp[i][j] = pick + notPick;
            }
        }
        return dp[arr.length - 1][target];
    }

    private static int spaceOptimization(int[] arr, int target) {
        int[] prevRow = new int[target + 1];
        for (int i = 0; i <= target; i++) {
            if (i % arr[0] == 0) prevRow[i] = 1;
        }
        for (int i = 1; i < arr.length; i++) {
            int[] currRow = new int[target + 1];
            for (int j = 0; j <= target; j++) {
                int notPick = prevRow[j];
                int pick = 0;
                if (arr[i] <= j) pick = currRow[j - arr[i]];
                currRow[j] = pick + notPick;
            }
            prevRow = currRow;
        }
        return prevRow[target];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 5};
        int target = 5;

        System.out.println("Memoization: " + memoizationRoot(arr, target));
        System.out.println("Tabulation: " + tabulation(arr, target));
        System.out.println("Space Optimization: " + spaceOptimization(arr, target));
    }
}