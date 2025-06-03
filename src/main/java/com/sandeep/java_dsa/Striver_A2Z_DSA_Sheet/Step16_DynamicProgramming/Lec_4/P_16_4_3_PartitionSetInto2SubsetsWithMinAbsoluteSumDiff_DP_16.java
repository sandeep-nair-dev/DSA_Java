package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step16_DynamicProgramming.Lec_4;

import java.util.Arrays;

public class P_16_4_3_PartitionSetInto2SubsetsWithMinAbsoluteSumDiff_DP_16 {
    /*
     Provided solutionOptimal works only in case of positive elements....
     For the leetcode problem, it might have negative elements too and requires the size of subsets to be equal, so a different solutionOptimal will be used
     */


    public static boolean[] tabulation(int[] arr, int target) {
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
        return dp[arr.length - 1];
    }

    public static boolean[] spaceOptimization(int[] arr, int target) {
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
        return prevRow;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 7};
        int totalSum = 0;
        for (int i : arr) totalSum += i;

        boolean[] lastRow = spaceOptimization(arr, totalSum);
        int mini = Integer.MAX_VALUE;
        for (int sum1 = 0; sum1 < lastRow.length; sum1++) {
            if (lastRow[sum1]) {
                int sum2 = totalSum - sum1;
                mini = Math.min(mini, Math.abs(sum2 - sum1));
            }
        }

        System.out.println("Resultant minimum absolute sum: " + mini);


//        System.out.println("Memoization: " + memoizationRoot(arr));
//        System.out.println("Tabulation: " + tabulation(arr, targetSum));
//        System.out.println("Space Optimization: " + spaceOptimization(arr, targetSum));

    }
}