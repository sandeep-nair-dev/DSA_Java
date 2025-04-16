package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step16_DynamicProgramming.Lec_6;

import java.util.Arrays;

public class P_16_6_5_BuyandSellStocksWithCooldown_DP_39 {

    /*
        Recursion:
            TC -> exponential
            SC -> O(N){RSS}
     */

    /*
        Memoization:
            TC -> O(N*2) ~= O(N)
            SC -> O(N*2) + O(N){RSS}
     */
    private static int memoizationRoot(int[] arr) {
        int[][] dp = new int[arr.length + 1][2];
        Arrays.stream(dp).forEach(t -> Arrays.fill(t, -1));
        return memoization(0,1, arr, dp);
    }

    private static int memoization(int ind, int canBuy, int[] arr, int[][] dp){
        if(ind>=arr.length) return 0;

        if(dp[ind][canBuy]!=-1) return dp[ind][canBuy];
        int profit;
        if(canBuy==1)
            profit = Math.max(-arr[ind]+memoization(ind+1, 0, arr, dp), memoization(ind+1, 1, arr, dp));
        else
            profit = Math.max(arr[ind]+memoization(ind+2, 1, arr, dp), memoization(ind+1, 0, arr, dp));
        return dp[ind][canBuy]=profit;
    }

    /*
        Tabulation:
            TC -> O(N*2) ~= O(N)
            SC -> O(N*2)
     */
    private static int tabulation(int[] arr) {
        int[][] dp = new int[arr.length + 1][2];
        for (int i = arr.length - 1; i >= 0; i--) {
            dp[i][1] = Math.max(-arr[i] + dp[i + 1][0], dp[i + 1][1]);
            int sellingProfit = arr[i] + ((i + 2) <= arr.length ? dp[i + 2][1] : 0);
            dp[i][0] = Math.max(sellingProfit, dp[i + 1][0]);
        }
        return dp[0][1];
    }

    /*
        Space Optimization:
            TC -> O(N*2) ~= O(N)
            SC -> O(2*3) == O(6) ~= O(1)
     */
    private static int spaceOptimization(int[] arr) {
        int[] ahead1 = new int[2];
        int[] ahead2 = new int[2];
        int[] curr = new int[2];
        for (int i = arr.length - 1; i >= 0; i--) {
            curr[1] = Math.max(-arr[i] + ahead1[0], ahead1[1]);
            curr[0] = Math.max(arr[i]+ahead2[1], ahead1[0]);
            System.arraycopy(ahead1, 0, ahead2, 0, 2);
            System.arraycopy(curr, 0, ahead1, 0, 2);
        }
        return ahead1[1];
    }

    public static void main(String[] args) {

        int[] arr = new int[]{1,2,3,0,2};
        System.out.println("Memoization: " + memoizationRoot(arr));
        System.out.println("Tabulation: " + tabulation(arr));
        System.out.println("Space Optimization: " + spaceOptimization(arr));
    }
}