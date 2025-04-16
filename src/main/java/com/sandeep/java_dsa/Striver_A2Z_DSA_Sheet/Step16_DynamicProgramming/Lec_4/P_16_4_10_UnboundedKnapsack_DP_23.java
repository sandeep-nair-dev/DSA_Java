package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step16_DynamicProgramming.Lec_4;

import java.util.Arrays;

public class P_16_4_10_UnboundedKnapsack_DP_23 {

    private static int memoizationRoot(int[] val, int[] wt, int capacity) {
        int[][] dp = new int[wt.length][capacity + 1];
        Arrays.stream(dp).forEach(t -> Arrays.fill(t, -1));
        return memoization(wt.length - 1, val, wt, capacity, dp);
    }

    private static int memoization(int ind, int[] val, int[] wt, int capacity, int[][] dp) {
        if (ind == 0) {
            return val[0] * (capacity / wt[0]);
        }

        if (dp[ind][capacity] != -1) return dp[ind][capacity];
        int notPick = memoization(ind - 1, val, wt, capacity, dp);
        int pick = Integer.MIN_VALUE;
        if (wt[ind] <= capacity) pick = val[ind] + memoization(ind, val, wt, capacity - wt[ind], dp);
        return dp[ind][capacity] = Math.max(pick, notPick);
    }

    private static int tabulation(int[] val, int[] wt, int capacity){
        int[][] dp = new int[wt.length][capacity+1];
        for(int i=0;i<=capacity;i++){
            dp[0][i]=(i/wt[0])*val[0];
        }
        for(int i=1;i<wt.length;i++){
            for(int j=0;j<=capacity;j++){
                int notPick = dp[i-1][j];
                int pick = Integer.MIN_VALUE;
                if(wt[i]<=j) pick = val[i]+dp[i][j-wt[i]];
                dp[i][j] = Math.max(pick, notPick);
            }
        }
        return dp[wt.length-1][capacity];
    }

    private static int spaceOptimization(int[] val, int[] wt, int capacity){
        int[] prevRow = new int[capacity+1];
        for(int i=0;i<=capacity;i++){
            prevRow[i]=(i/wt[0])*val[0];
        }
        for(int i=1;i<wt.length;i++){
            int[] currRow = new int[capacity+1];
            for (int j=0;j<=capacity;j++){
                int notPick = prevRow[j];
                int pick = Integer.MIN_VALUE;
                if(wt[i]<=j) pick = val[i]+currRow[j-wt[i]];
                currRow[j]=Math.max(pick, notPick);
            }
            prevRow=currRow;
        }
        return prevRow[capacity];
    }


    public static void main(String[] args) {
        int[] val = new int[]{9, 10, 3, 3, 7, 4, 7};
        int[] wt = new int[]{2, 3, 7, 4, 9, 1, 6};
        int capacity = 3;
        System.out.println("Memoization: " + memoizationRoot(val, wt, capacity));
        System.out.println("Tabulation: " + tabulation(val, wt, capacity));
        System.out.println("Space Optimization: " + spaceOptimization(val, wt, capacity));
    }
}