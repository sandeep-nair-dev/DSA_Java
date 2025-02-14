package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step16_DynamicProgramming.Lec_2;

import java.util.Arrays;

public class P_16_2_5_HouseRobber_DP_6 {

    /**
     * Similar to previous -> Maximum Sum Of Non Adjacent numbers, but in this since 1st and last element are connected to each other, we'll just split the array to 2 arrays
     * 1. 0 to arr.length-2
     * 2. 1 to arr.length-1
     * and take maximum of the answer from both
     */

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
//        int[] dp = new int[arr.length];
//        Arrays.fill(dp,-1);
        int[] subarr1 = Arrays.copyOfRange(arr, 0, arr.length-1);
        int[] subarr2 = Arrays.copyOfRange(arr, 1, arr.length);
        for(int i=0;i<arr.length;i++){
            if(i!=arr.length-1) subarr1[i]=arr[i];
            if(i!=0) subarr1[i-1]=arr[i];
        }

        int spaceOp1 = spaceOptimized(subarr1);
        int spaceOp2 = spaceOptimized(subarr2);
        System.out.println("Answer: " + Math.max(spaceOp1, spaceOp2));

        // Print the result.
//        System.out.println("Memoization: " + memoization(arr.length-1, arr, dp));
//        System.out.println("Tabulation: " + tabulation(arr));
//        System.out.println("Space Optimized: " + spaceOptimized(arr));

    }
}