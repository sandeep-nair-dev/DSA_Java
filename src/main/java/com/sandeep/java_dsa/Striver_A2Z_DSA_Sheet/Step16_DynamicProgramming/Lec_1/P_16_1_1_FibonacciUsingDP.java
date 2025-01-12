package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step16_DynamicProgramming.Lec_1;

import java.util.Arrays;

public class P_16_1_1_FibonacciUsingDP {
    public static int memoization(int n, int[] dp) {
        if (n <= 1) return n;

        if (dp[n] != -1) return dp[n];
        return dp[n] = memoization(n - 1, dp) + memoization(n - 2, dp);
    }


    public static int tabulation(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static int spaceOptimization(int n) {
        int prev2 = 0, prev = 1;
        for (int i = 2; i <= n; i++) {
            int curr = prev2 + prev;
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }

    public static void main(String[] args) {
        int n = 20;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(memoization(n, dp));
        System.out.println(tabulation(n));
        System.out.println(spaceOptimization(n));
    }


}
