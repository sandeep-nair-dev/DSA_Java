package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step16_DynamicProgramming.Lec_4;

import java.util.Arrays;

public class P_16_4_1_SubsetSumEqualToTarget_DP_14 {

    /*
    Normal Recursion
    T.C. -> O(2^n)
    S.C. -> O(n) {RSS}
     */

    /*
    Memoization:
    T.C. -> O(n * target)
    S.C. -> O(n * target) + O(n){RSS}
     */
    public static boolean memoizationRoot(int[] arr, int target) {
        int[][] dp = new int[arr.length][target + 1];
        Arrays.stream(dp).forEach(r -> Arrays.fill(r, -1));
        return memoization(arr.length - 1, target, arr, dp);
    }

    public static boolean memoization(int ind, int target, int[] arr, int[][] dp) {
        if (target == 0) return true;
        if (ind == 0) return arr[0] == target;

        if (dp[ind][target] != -1) return dp[ind][target] == 1 ? Boolean.TRUE : Boolean.FALSE;
        boolean notPick = memoization(ind - 1, target, arr, dp);
        boolean pick = false;
        if (target >= arr[ind]) pick = memoization(ind - 1, target - arr[ind], arr, dp);
        boolean result = pick || notPick;
        dp[ind][target] = result == Boolean.TRUE ? 1 : 0;
        return result;
    }

    /*
    Tabulation:
    T.C -> O(n * target)
    S.C -> O(n * target)
     */
    public static boolean tabulation(int[] arr, int target) {
        boolean[][] dp = new boolean[arr.length][target + 1];
        Arrays.stream(dp).forEach(r -> Arrays.fill(r, Boolean.FALSE));
        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = Boolean.TRUE;
        }
        if (arr[0] <= target) dp[0][arr[0]] = Boolean.TRUE;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= target; j++) {
                boolean notPick = dp[i - 1][j];
                boolean pick = Boolean.FALSE;
                if (arr[i] <= j) pick = dp[i - 1][j - arr[i]];
                dp[i][j] = pick || notPick;
            }
        }
        return dp[arr.length - 1][target];
    }

    /*
    Space Optimization:
    T.C -> O(n * target)
    S.C -> O(target)
     */
    public static boolean spaceOptimization(int[] arr, int target) {
        boolean[] prevRow = new boolean[target + 1];
        Arrays.fill(prevRow, Boolean.FALSE);
        prevRow[0] = Boolean.TRUE;
        if (arr[0] <= target) prevRow[arr[0]] = Boolean.TRUE;
        for (int i = 1; i < arr.length; i++) {
            boolean[] currRow = new boolean[target + 1];
            currRow[0]=Boolean.TRUE;
            for (int j = 1; j <= target; j++) {
                boolean notPick = prevRow[j];
                boolean pick = Boolean.FALSE;
                if (j >= arr[i]) pick = prevRow[j - arr[i]];
                currRow[j] = pick || notPick;
            }
            prevRow = currRow;
        }
        return prevRow[target];
    }

    public static void main(String[] args) {

        int[] arr = {78, 78, 10, 70, 61, 57, 31, 56, 35, 44, 25, 8, 28, 31, 47, 21, 45, 39, 41, 35, 33, 24, 41, 36, 66, 68, 11, 58, 45, 71, 58, 78, 78, 16, 13};
        int k = 61;
        int n = arr.length;

        System.out.println("Memoization: " + memoizationRoot(arr, k));
        System.out.println("Tabulation: " + tabulation(arr, k));
        System.out.println("Space Optimization: " + spaceOptimization(arr, k));

    }
}