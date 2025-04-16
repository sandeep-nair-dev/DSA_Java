package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step16_DynamicProgramming.Lec_6;

import java.lang.reflect.Array;
import java.util.Arrays;

public class P_16_6_3_BuyandSellStocks_III_DP_37 {

    /*
        Recursion:
            TC -> exponential
            SC -> O(N){RSS}
     */


    /*
        Memoization:
            TC -> O(N*2*3)              -> 2 is the maxTransactionsAllowed, hence can have 3 states, 0,1,2
            SC -> O(N*2*3) + O(N){RSS}
     */
    private static int memoizationRoot(int[] arr, int maxTransactionsAllowed) {
        int[][][] dp = new int[arr.length + 1][2][maxTransactionsAllowed+1];
        Arrays.stream(dp).forEach(t -> Arrays.stream(t).forEach(p-> Arrays.fill(p, -1)));
        return memoization(0, arr, dp, 1, maxTransactionsAllowed);
    }

    private static int memoization(int ind, int[] arr, int[][][] dp, int canBuy, int transactionCap){
        if(ind==arr.length||transactionCap==0) return 0;

        if(dp[ind][canBuy][transactionCap]!=-1) return dp[ind][canBuy][transactionCap];
        int profit;
        if(canBuy==1){
            profit= Math.max(-arr[ind]+memoization(ind+1, arr, dp, 0, transactionCap), memoization(ind+1, arr, dp, 1, transactionCap));
        }else{
            profit= Math.max(arr[ind]+memoization(ind+1, arr, dp, 1,  transactionCap-1), memoization(ind+1, arr, dp, 0, transactionCap));
        }
        return dp[ind][canBuy][transactionCap]=profit;
    }


    /*
        Tabulation:
            TC -> O(N*2*3)              -> 2 is the maxTransactionsAllowed, hence can have 3 states, 0,1,2
            SC -> O(N*2*3)
     */
    private static int tabulation(int[] arr, int transactionCap){
        int[][][] dp = new int[arr.length+1][2][transactionCap+1];
//        for(int ind=0;ind<=arr.length;ind++){             //when cap is 0 return 0
//            dp[ind][0][0]=0;
//            dp[ind][1][0]=0;
//        }
//
//        for(int buy=0;buy<=1;buy++){                      //when ind==arr.length, return 0
//            for(int cap=0;cap<=transactionCap;cap++){
//                dp[arr.length][buy][cap]=0;
//            }
//        }
        for(int i=arr.length-1;i>=0;i--){
            for(int canBuy=0;canBuy<=1;canBuy++){
                for(int cap=1;cap<=transactionCap;cap++){
                    int profit;
                    if(canBuy==1){
                        profit = Math.max(-arr[i]+dp[i+1][0][cap],dp[i+1][1][cap]);
                    }else{
                        profit = Math.max(arr[i]+dp[i+1][1][cap-1], dp[i+1][0][cap]);
                    }
                    dp[i][canBuy][cap]=profit;
                }
            }
        }
        return dp[0][1][2];
    }


    /*
        Memoization:
            TC -> O(N*2*3)              -> 2 is the maxTransactionsAllowed, hence can have 3 states, 0,1,2
            SC -> O(2*3) ~= O(1)
     */
    private static int spaceOptimization(int[] arr, int transactionCap){
        int[][] ahead = new int[2][transactionCap+1];
        int[][] curr = new int[2][transactionCap+1];

        for(int i=arr.length-1;i>=0;i--){
            for(int canBuy=0;canBuy<=1;canBuy++){
                for(int cap=1;cap<=transactionCap;cap++){
                    int profit;
                    if(canBuy==1){
                        profit = Math.max(-arr[i]+ahead[0][cap], ahead[1][cap]);
                    }else{
                        profit = Math.max(arr[i]+ahead[1][cap-1], ahead[0][cap]);
                    }
                    curr[canBuy][cap]=profit;
                }
            }
            ahead=curr;
        }
        return ahead[1][2];
    }

    /*
      ----------Another approach---------------
      Here we'll not be having different for transactions and buy, since once buy we cant sell and total 2 transactions allowed, we bifurcate the transactions as
        B   S   B   S
        0   1   2   3
        Hence, if transaction is even it is buy otherwise it is sell
     */
    //Done in next problem i.e., DP-37



    public static void main(String[] args) {

        int[] arr = new int[]{2,1,4,5,2,9,7};
//        System.out.println(func(arr));
        System.out.println("Memoization: " + memoizationRoot(arr,2));
        System.out.println("Tabulation: " + tabulation(arr, 2));
        System.out.println("Space Optimization: " + spaceOptimization(arr,2));
    }
}