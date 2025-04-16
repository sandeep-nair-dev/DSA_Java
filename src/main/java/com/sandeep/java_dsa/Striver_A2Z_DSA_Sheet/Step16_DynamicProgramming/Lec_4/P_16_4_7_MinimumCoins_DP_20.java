package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step16_DynamicProgramming.Lec_4;

import java.util.Arrays;

public class P_16_4_7_MinimumCoins_DP_20 {

    /*
        Normal Brute Force Recursion
        T.C. -> exponential...i.e. >O(2^n) because here each element can me taken more than two times
        S.C. -> O(target) because in worst case we can take 1 and trigger recursion so recursion stack space
     */


    private static int memoizationRoot(int[] arr, int target) {
        int[][] dp = new int[arr.length][target + 1];
        Arrays.stream(dp).forEach(t -> Arrays.fill(t, -1));
        return memoization(arr.length - 1, target, arr, dp);
    }

    /*
        Memoization:
        T.C. -> O(N*T)
        S.C. -> O(N*T) + O(T){RSS}
     */
    private static int memoization(int ind, int target, int[] arr, int[][] dp) {
        if (ind == 0) {
            if (target % arr[0] == 0) return target / arr[0];
            else return (int) 1e9;
        }

        if (dp[ind][target] != -1) return dp[ind][target];

        int notPick = memoization(ind - 1, target, arr, dp);
        int pick = Integer.MAX_VALUE;
        if (arr[ind] <= target) pick = 1 + memoization(ind, target - arr[ind], arr, dp);

        return dp[ind][target] = Math.min(pick, notPick);
    }

    /*
        Memoization:
        T.C. -> O(N*T)
        S.C. -> O(N*T)
     */
    private static int tabulation(int[] arr, int target) {
        int[][] dp = new int[arr.length][target + 1];
        for (int j = 0; j <= target; j++) {
            if (j % arr[0] == 0) dp[0][j] = j / arr[0];
            else dp[0][j] = (int) 1e9;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j <= target; j++) {
                int notPick = dp[i - 1][j];
                int pick = (int) 1e9;
                if (arr[i] <= j) pick = 1 + dp[i][j - arr[i]];
                dp[i][j] = Math.min(pick, notPick);
            }
        }
        return dp[arr.length - 1][target];
    }

    public static int spaceOptimization(int[] arr, int target) {
        int[] prevRow = new int[target + 1];
        int[] currRow = new int[target + 1];
        for (int j = 0; j <= target; j++) {
            if (j % arr[0] == 0) prevRow[j] = j / arr[0];
            else prevRow[j] = (int) 1e9;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j <= target; j++) {
                int notPick = prevRow[j];
                int pick = (int) 1e9;
                if (arr[i] <= j) pick = 1 + currRow[j - arr[i]];
                currRow[j] = Math.min(pick, notPick);
            }
            prevRow = currRow;
        }
        return prevRow[target];
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 5};
        int T = 11;

        int memoizationResult = memoizationRoot(arr, T);
        int tabulationResult = tabulation(arr, T);
        int spaceOptimizationResult = spaceOptimization(arr, T);
        System.out.println("Memoization: " + (memoizationResult >= 1e9 ? -1 : memoizationResult));
        System.out.println("Tabulation: " + (tabulationResult >= 1e9 ? -1 : tabulationResult));
        System.out.println("Space Optimization: " + (spaceOptimizationResult >= 1e9 ? -1 : spaceOptimizationResult));
    }
}