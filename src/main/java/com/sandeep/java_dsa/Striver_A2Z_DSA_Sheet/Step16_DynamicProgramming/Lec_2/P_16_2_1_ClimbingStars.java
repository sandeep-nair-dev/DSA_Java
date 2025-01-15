package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step16_DynamicProgramming.Lec_2;

import java.util.Arrays;

public class P_16_2_1_ClimbingStars {

    public static int memoization(int n, int[] dp) {
        if (n <= 1) return 1;

        if (dp[n] != -1) return dp[n];
        return dp[n] = memoization(n - 1, dp) + memoization(n - 2, dp);
    }


    public static int tabulation(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static int spaceOptimized(int n) {
        int prev2 = 1, prev = 1;
        for (int i = 2; i <= n; i++) {
            int curr = prev2 + prev;
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(memoization(n, dp));
        System.out.println(tabulation(n));
        System.out.println(spaceOptimized(n));
    }
}