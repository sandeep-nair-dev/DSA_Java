package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step16_DynamicProgramming.Lec_2;

import java.lang.reflect.Array;
import java.util.Arrays;

public class P_16_2_4_MaximumSumOfNonAdjacentElements_DP_5 {

    public static int memoization(int ind, int[] arr, int[] dp){
        if(ind==0) return arr[0];
        else if(ind<0) return 0;

        if(dp[ind]!=-1) return dp[ind];

        int pick = arr[ind]+memoization(ind-2, arr, dp);
        int notPick = memoization(ind-1, arr, dp);
        return dp[ind]=Math.max(pick, notPick);
    }

    public static int tabulation(int[] arr){
        int[] dp = new int[arr.length];
        dp[0]=arr[0];
        for(int i=1;i<arr.length;i++){
            int pick = arr[i];                  // what if there are only 2 elements and 2nd element greater that 1st, like [1,2]..int this for i==1, pick will be we pick the element hence it will be 2
            if(i>1) pick+=dp[i-2];
            int notPick = dp[i-1];
            dp[i]=Math.max(pick, notPick);
        }
        return dp[arr.length-1];
    }

    public static int spaceOptimized(int[] arr){
        int prev2=0, prev=arr[0];
        for(int i=1;i<arr.length;i++){
            int pick=arr[i]+prev2;      // it should also be pick=arr[i] and if(pick>1) then pick+=prev2, but since prev2=0 therefore doesn't make much difference
            int notPick = prev;
            int curr = Math.max(pick, notPick);
            prev2=prev;
            prev=curr;
        }
        return prev;
    }

    public static void main(String[] args) {

        int[] arr = {2, 1, 4, 9};
        int[] dp = new int[arr.length];
        Arrays.fill(dp,-1);

        // Call the solve function to find the maximum possible sum.

        // Print the result.
        System.out.println("Memoization: " + memoization(arr.length-1, arr, dp));
        System.out.println("Tabulation: " + tabulation(arr));
        System.out.println("Space Optimized: " + spaceOptimized(arr));

    }
}