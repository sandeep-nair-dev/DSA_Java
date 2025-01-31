package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step16_DynamicProgramming.Lec_2;

import java.util.Arrays;

public class P_16_2_2_FrogJump_DP_3 {

    public static int memoization(int ind, int[] arr, int[] dp) {
        if (ind == 0) return 0;
        if (dp[ind] != -1) return dp[ind];
        int oneJump = memoization(ind - 1, arr, dp) + Math.abs(arr[ind] - arr[ind - 1]);
        int twoJump = Integer.MAX_VALUE;
        if (ind > 1) {
            twoJump = memoization(ind - 2, arr, dp) + Math.abs(arr[ind] - arr[ind - 2]);
        }
        return dp[ind] = Math.min(oneJump, twoJump);
    }

    public static int tabulation(int[] arr) {
        int[] dp = new int[arr.length + 1];
        dp[0] = 0;
        for (int i = 1; i <= arr.length - 1; i++) {
            int oneStep = dp[i - 1] + Math.abs(arr[i - 1] - arr[i]);
            int twoStep = Integer.MAX_VALUE;
            if (i > 1) twoStep = dp[i - 2] + Math.abs(arr[i - 2] - arr[i]);
            dp[i] = Math.min(oneStep, twoStep);
        }
        return dp[arr.length - 1];
    }

    public static int spaceOptimization(int[] arr) {
        int prev2 = 0, prev = 0;
        for (int i = 1; i <= arr.length - 1; i++) {
            int oneStep = prev + Math.abs(arr[i - 1] - arr[i]);
            int twoStep = Integer.MAX_VALUE;
            if (i > 1) twoStep = prev2 + Math.abs(arr[i - 2] - arr[i]);
            int curr = Math.min(oneStep, twoStep);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }

    public static void main(String[] args) {

        int[] height = {30, 10, 60, 10, 60, 50};
        int[] dp = new int[height.length + 1];
        Arrays.fill(dp, -1);
        System.out.println(memoization(height.length - 1, height, dp));
        System.out.println(tabulation(height));
        System.out.println(spaceOptimization(height));
    }
}