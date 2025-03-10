package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step16_DynamicProgramming.Lec_6;

import java.util.Arrays;

public class P_16_6_2_BuyandSellStock_II_DP_36 {

    private static int memoizationRoot(int[] arr) {
        int[][] dp = new int[arr.length + 1][2];
        Arrays.stream(dp).forEach(t -> Arrays.fill(t, -1));
        return memoization(0, arr, dp, 1);
    }

    /*
        Memoization:
            TC -> O(N*2)
            SC -> O(N*2)+O(N)
     */
    private static int memoization(int ind, int[] arr, int[][] dp, int canBuy) {
        if (ind == arr.length) return 0;

        if(dp[ind][canBuy]!=-1) return dp[ind][canBuy];
        int profit = 0;
        if (canBuy==1) {
            profit=Math.max(-arr[ind] + memoization(ind + 1, arr, dp, 0), memoization(ind + 1, arr, dp, 1));
        } else {
            profit=Math.max(arr[ind] + memoization(ind + 1, arr, dp, 1), memoization(ind + 1, arr, dp, 0));
        }
        return dp[ind][canBuy]=profit;
    }

    /*
        Tabulation:
            TC -> O(N*2)
            SC -> O(N*2)
     */
    private static int tabulation(int[] arr){
        int[][] dp = new int[arr.length+1][2];
        dp[arr.length][0]=0;
        dp[arr.length][1]=0;

        for(int i=arr.length-1;i>=0;i--){
            dp[i][1] = Math.max(-arr[i]+dp[i+1][0], dp[i+1][1]);
            dp[i][0]=Math.max(arr[i]+dp[i+1][1], dp[i+1][0]);
        }

        return dp[0][1];
    }

    /*
        Space Optimization:
            TC -> O(N*2)
            SC -> O(2)
     */
    private static int spaceOptimization(int[] arr){
        int[] ahead = new int[2];
//        ahead[0]=0;
//        ahead[1]=0;

        for(int i=arr.length-1;i>=0;i--){
            int[] curr = new int[2];
            curr[1]=Math.max(-arr[i]+ahead[0], ahead[1]);
            curr[0]=Math.max(arr[i]+ahead[1], ahead[0]);
            ahead=curr;
        }
        return ahead[1];
    }

    // we can also user 4 variables instead of arr[2] and arr[2];\
    private static int spaceOptimizationUsingVariables(int[] arr){
        int aheadCannotBuy=0, aheadCanBuy=0, currCannotBuy=0, currCanBuy=0;
//        ahead[0]=0;
//        ahead[1]=0;

        for(int i=arr.length-1;i>=0;i--){

            currCanBuy=Math.max(-arr[i]+aheadCannotBuy, aheadCanBuy);
            currCannotBuy=Math.max(arr[i]+aheadCanBuy, aheadCannotBuy);
            aheadCanBuy=currCanBuy;
            aheadCannotBuy=currCannotBuy;
        }
        return aheadCanBuy;
    }

    public static void main(String[] args) {

        int[] arr = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println("Memoization: " + memoizationRoot(arr));
        System.out.println("Tabulation: " + tabulation(arr));
        System.out.println("Space Optimization: " + spaceOptimization(arr));
        System.out.println("Space Optimization Using Variables: " + spaceOptimizationUsingVariables(arr));

    }
}