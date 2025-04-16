package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step16_DynamicProgramming.Lec_6;

import java.util.Arrays;

public class P_16_6_4_BuyandStockSell_IV_DP_38 {

    /*
        Solution used in DP_37, i.e. previous question can also be used here, we are just trying herer with the different approach to solve the question
        Here we'll not be having different for transactions and buy, since once buy we cant sell and total 2 transactions allowed, we bifurcate the transactions as
        B   S   B   S
        0   1   2   3
        Hence, if transaction is even it is buy otherwise it is sell

        Since in this questions there can be k transactions, the total transactions we take will be 2*transactions...i.e., one transaction = 1 buy + 1 sell
     */
        /*
        Recursion:
            TC -> exponential
            SC -> O(N){RSS}
     */


    /*
        Memoization: n is no of elements in array and k is the number of transactions allowed at max
            TC -> O(n*2*k)
            SC -> O(n*2*k) + O(N){RSS}
     */

    private static int memoizationRoot(int[] arr, int maxTransactionsAllowed) {
        int[][] dp = new int[arr.length + 1][(maxTransactionsAllowed*2)+1];
        Arrays.stream(dp).forEach(t-> Arrays.fill(t, -1));
        return memoization(0, arr, dp, 0, maxTransactionsAllowed);
    }

    private static int memoization(int ind, int[] arr, int[][] dp, int transaction, int maxTransactionAllowed){
        if(ind==arr.length || transaction>=maxTransactionAllowed*2) return 0;

        if(dp[ind][transaction]!=-1) return dp[ind][transaction];
        int profit;

        if(transaction%2==0) profit = Math.max(-arr[ind]+ memoization(ind+1, arr, dp, transaction+1, maxTransactionAllowed), memoization(ind+1, arr, dp, transaction, maxTransactionAllowed));
        else profit = Math.max(arr[ind]+ memoization(ind+1, arr, dp, transaction+1, maxTransactionAllowed), memoization(ind+1, arr, dp, transaction, maxTransactionAllowed));
        return dp[ind][transaction] = profit;
    }

    private static int tabulation(int[] arr, int maxTransactionsAllowed){
        int[][] dp = new int[arr.length+1][(maxTransactionsAllowed*2)+1];
        for(int ind = arr.length-1;ind>=0;ind--){
            for(int transaction=(maxTransactionsAllowed*2)-1;transaction>=0;transaction--){
                int profit;
                if(transaction%2==0) profit = Math.max(-arr[ind]+dp[ind+1][transaction+1], dp[ind+1][transaction]);
                else profit = Math.max(arr[ind]+dp[ind+1][transaction+1], dp[ind+1][transaction]);
                dp[ind][transaction]=profit;
            }
        }
        return dp[0][0];
    }

    private static int spaceOptimization(int[] arr, int maxTransactionsAllowed){
        int[] ahead = new int[maxTransactionsAllowed*2+1];
        int[] curr = new int[maxTransactionsAllowed*2+1];
        for(int ind=arr.length-1;ind>=0;ind--){
            for(int transac = 2*maxTransactionsAllowed-1;transac>=0;transac--){
                int profit;
                if(transac%2==0) profit = Math.max(-arr[ind]+ahead[transac+1], ahead[transac]);
                else profit = Math.max(arr[ind]+ahead[transac+1], ahead[transac]);
                curr[transac] = profit;
            }
            ahead = curr;
        }
        return ahead[0];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,1,4,5,2,9,7};

        System.out.println("Memoization: " + memoizationRoot(arr,2));
        System.out.println("Tabulation: " + tabulation(arr, 2));
        System.out.println("Space Optimization: " + spaceOptimization(arr,2));

    }
}