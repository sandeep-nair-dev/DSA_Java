package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step16_DynamicProgramming.Lec_6;

import java.util.Arrays;

public class P_16_6_6_BuyandSellStocksWithTransactionFee_DP_40 {

    private static int memoizationRoot(int[] arr, int fee) {
        int[][] dp = new int[arr.length + 1][2];
        Arrays.stream(dp).forEach(t -> Arrays.fill(t, -1));
        return memoization(0, 1, fee, arr, dp);
    }

    private static int memoization(int ind, int canBuy, int fee, int[] arr, int[][] dp) {
        if (ind == arr.length)
            return 0;

        if (dp[ind][canBuy] != -1)
            return dp[ind][canBuy];
        int profit;
        if (canBuy == 1)
            profit = Math.max(-arr[ind] + memoization(ind + 1, 0, fee, arr, dp),
                    memoization(ind + 1, canBuy, fee, arr, dp));
        else
            profit = Math.max(arr[ind] - fee + memoization(ind + 1, 1, fee, arr, dp),
                    memoization(ind + 1, canBuy, fee, arr, dp));
        return dp[ind][canBuy] = profit;
    }

    private static int tabulation(int[] arr, int fee) {
        int[][] dp = new int[arr.length + 1][2];
        for (int ind = arr.length - 1; ind >= 0; ind--) {
            dp[ind][1] = Math.max(-arr[ind] + dp[ind + 1][0], dp[ind + 1][1]);
            dp[ind][0] = Math.max(arr[ind] - fee + dp[ind + 1][1], dp[ind + 1][0]);
        }
        return dp[0][1];
    }

    private static int spaceOptimization(int[] arr, int fee) {
        int[] ahead = new int[2];
        int[] curr = new int[2];
        for (int ind = arr.length - 1; ind >= 0; ind--) {
            curr[1] = Math.max(-arr[ind] + ahead[0], ahead[1]);
            curr[0] = Math.max(arr[ind] - fee + ahead[1], ahead[0]);
            ahead = curr;
        }
        return ahead[1];
    }

    private static int spaceOptimizationVariables(int[] arr, int fee) {
        int currCanBuy = 0, currCantBuy = 0, aheadCantBuy = 0, aheadCanBuy = 0;
        for (int ind = arr.length - 1; ind >= 0; ind--) {
            currCanBuy = Math.max(-arr[ind] + aheadCantBuy, aheadCanBuy);
            currCantBuy = Math.max(arr[ind] - fee + aheadCanBuy, aheadCantBuy);
            aheadCantBuy = currCantBuy;
            aheadCanBuy = currCanBuy;
        }
        return aheadCanBuy;
    }

    public static void main(String[] args) {

        int[] arr = new int[]{1, 3, 2, 8, 4, 9};
        int fee = 2;
        System.out.println("Memoization: " + memoizationRoot(arr, fee));
//        System.out.println("Tabulation: " + tabulation(arr));
//        System.out.println("Space Optimization: " + spaceOptimization(arr));

    }
}