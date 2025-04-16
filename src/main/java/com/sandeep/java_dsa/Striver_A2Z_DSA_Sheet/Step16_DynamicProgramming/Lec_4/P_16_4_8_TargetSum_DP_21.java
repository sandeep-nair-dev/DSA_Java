package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step16_DynamicProgramming.Lec_4;

import java.util.Arrays;

public class P_16_4_8_TargetSum_DP_21 {

    private static int bruteForce(int ind, int[] arr, int target) {
        if (ind < 0) return target == 0 ? 1 : 0;

        int positive = bruteForce(ind - 1, arr, target - arr[ind]);
        int negative = bruteForce(ind - 1, arr, target + arr[ind]);

        return positive + negative;
    }

    private static int memoizationRoot(int[] arr, int target) {
        int[][] dp = new int[arr.length][target + 1];
        Arrays.stream(dp).forEach(t -> Arrays.fill(t, -1));
        return memoization(arr.length - 1, arr, target, dp);
    }

    private static int memoization(int ind, int[] arr, int target, int[][] dp) {
        if (ind == 0) {
            if (target == 0 && arr[0] == 0) return 2;
            if (target == 0 || arr[0] == target) return 1;
            return 0;
        }

        if (dp[ind][target] != -1) return dp[ind][target];
        int notPick = memoization(ind - 1, arr, target, dp);
        int pick = 0;
        if (arr[ind] <= target) pick = memoization(ind - 1, arr, target - arr[ind], dp);

        return dp[ind][target] = pick + notPick;
    }

    private static int tabulation(int[] arr, int target) {
        int[][] dp = new int[arr.length][target + 1];
        if (arr[0] == 0) dp[0][0] = 2;
        else dp[0][0] = 1;
        if (arr[0] != 0 && arr[0] <= target) dp[0][arr[0]] = 1;

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j <= target; j++) {
                int notPick = dp[i - 1][j];
                int pick = 0;
                if (arr[i] <= j) pick = dp[i - 1][j - arr[i]];
                dp[i][j] = pick + notPick;
            }
        }
        return dp[arr.length - 1][target];
    }

    private static int spaceOptimization(int[] arr, int target) {
        int[] prevRow = new int[target + 1];
        if (arr[0] == 0) prevRow[0] = 2;
        else prevRow[0] = 1;
        if (arr[0] != 0 && arr[0] <= target) prevRow[arr[0]] = 1;
        for (int i = 1; i < arr.length; i++) {
            int[] currRow = new int[target + 1];
            for (int j = 0; j <= target; j++) {
                int notPick = prevRow[j];
                int pick = 0;
                if (arr[i] <= j) pick = prevRow[j - arr[i]];
                currRow[j] = pick + notPick;
            }
            prevRow = currRow;
        }
        return prevRow[target];
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 1};
        int target = 3;

//        int[] arr = {100};
//        int target = -200;

        int totalSum = 0;
        for (int i : arr) totalSum += i;
        if(target+totalSum<0 || (target+totalSum)%2==1){
            System.out.println("Not possible, hence result:0");
            System.exit(1);
        }
        int newTarget = (target + totalSum) / 2;
        System.out.println("Memoization: " + memoizationRoot(arr, newTarget));
        System.out.println("Tabulation: " + tabulation(arr, newTarget));
        System.out.println("Space Optimization: " + spaceOptimization(arr, newTarget));
    }
}