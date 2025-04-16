package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step16_DynamicProgramming.Lec_4;

import java.util.Arrays;

public class P_16_4_2_PartitionEqualSubsetSum_DP_15 {

    public static boolean memoizationRoot(int[] arr, int targetSum) {
        int[][] dp = new int[arr.length][targetSum + 1];
        Arrays.stream(dp).forEach(r -> Arrays.fill(r, -1));
        return memoization(arr.length - 1, arr, targetSum, dp);
    }

    public static boolean memoization(int ind, int[] arr, int target, int[][] dp) {
        if (target == 0) return true;
        if (ind == 0) return arr[0] == target;

        if (dp[ind][target] != -1) return dp[ind][target] == 1;
        boolean notPick = memoization(ind - 1, arr, target, dp);
        boolean pick = false;
        if (target >= arr[ind]) pick = memoization(ind - 1, arr, target - arr[ind], dp);
        boolean result = pick || notPick;
        dp[ind][target] = result ? 1 : 0;
        return result;
    }

    public static boolean tabulation(int[] arr, int target) {
        boolean[][] dp = new boolean[arr.length][target + 1];
        Arrays.stream(dp).forEach(r -> Arrays.fill(r, false));
        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = true;
        }
        if (arr[0] <= target) dp[0][arr[0]] = true;

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= target; j++) {
                boolean notPick = dp[i - 1][j];
                boolean pick = false;
                if (j >= arr[i]) pick = dp[i - 1][j - arr[i]];
                dp[i][j] = pick || notPick;
            }
        }
        return dp[arr.length - 1][target];
    }

    public static boolean spaceOptimization(int[] arr, int target) {
        boolean[] prevRow = new boolean[target + 1];
        prevRow[0] = true;
        if (arr[0] <= target) prevRow[arr[0]] = true;
        for (int i = 1; i < arr.length; i++) {
            boolean[] currRow = new boolean[target + 1];
            Arrays.fill(currRow, false);
            for (int j = 1; j <= target; j++) {
                boolean notPick = prevRow[j];
                boolean pick = false;
                if (j >= arr[i]) pick = prevRow[j - arr[i]];
                currRow[j] = pick || notPick;
            }
            prevRow = currRow;
        }
        return prevRow[target];
    }

    public static void main(String[] args) {

        int[] arr = {1, 5, 11, 5};

        boolean result;
        int totalSum = 0;
        for (int j : arr) totalSum += j;

        if (totalSum % 2 != 0) {
            result = false;
            System.out.println("Not possible");
        } else {
            int targetSum = totalSum / 2;


            System.out.println("Memoization: " + memoizationRoot(arr, targetSum));
            System.out.println("Tabulation: " + tabulation(arr, targetSum));
            System.out.println("Space Optimization: " + spaceOptimization(arr, targetSum));
        }
    }
}