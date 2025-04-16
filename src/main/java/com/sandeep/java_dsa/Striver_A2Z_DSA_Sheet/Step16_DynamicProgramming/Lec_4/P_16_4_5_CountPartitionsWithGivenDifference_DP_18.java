package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step16_DynamicProgramming.Lec_4;

import java.util.Arrays;
import java.util.List;

public class P_16_4_5_CountPartitionsWithGivenDifference_DP_18 {

    public static int memoizationRoot(int[] arr, int target) {
        int[][] dp = new int[arr.length][target + 1];
        Arrays.stream(dp).forEach(r -> Arrays.fill(r, -1));
        return memoization(arr.length - 1, target, arr, dp);
    }

    public static int memoization(int ind, int target, int[] arr, int[][] dp) {
        if (ind == 0) {
            if (target == 0 && arr[0] == 0) return 2;
            if (target == 0 || target == arr[0]) return 1;
            return 0;
        }

        if (dp[ind][target] != -1) return dp[ind][target];
        int notPick = memoization(ind - 1, target, arr, dp);
        int pick = 0;
        if (arr[ind] <= target) pick = memoization(ind - 1, target - arr[ind], arr, dp);
        return dp[ind][target] = pick + notPick;
    }

    public static int tabulation(int[] arr, int target){
        int n = arr.length;
        int[][] dp = new int[n][target+1];
        if(arr[0]==0) dp[0][0] = 2;
        else dp[0][0]=1;
        if(arr[0]!=0 && arr[0]<=target) dp[0][arr[0]]=1;
        for(int i=1;i<n;i++){
            for(int j=0;j<=target;j++){
                int notPick = dp[i-1][j];
                int pick = 0;
                if(arr[i]<=j) pick = dp[i-1][j-arr[i]];
                dp[i][j] = pick+notPick;
            }
        }
        return dp[n-1][target];
    }

    public static int spaceOptimization(int[] arr, int targetSum){
        int[] prevRow = new int[targetSum+1];
        if(arr[0]==0) prevRow[0]=2;
        else prevRow[0]=1;
        if(arr[0]!=0 && arr[0]<=targetSum) prevRow[arr[0]]=1;
        for(int i=1;i<arr.length;i++){
            int[] currentRow = new int[targetSum+1];
            for(int j=0;j<=targetSum;j++){
                int notPick = prevRow[j];
                int pick = 0;
                if(arr[i]<=j) pick = prevRow[j-arr[i]];
                currentRow[j] = pick+notPick;
            }
            prevRow=currentRow;
        }
        return prevRow[targetSum];
    }


    public static void main(String[] args) {

        int[] arr = {5, 2, 6, 4};
        int targetSum = 3;

        int totalSum = 0;
        for (int i : arr) totalSum += i;
        if (totalSum - targetSum < 0 || (totalSum - targetSum) % 2 == 1){
            System.out.println("0 ways to partition to get difference in sum as " + targetSum);
            System.exit(1);
        }
        /*
            sum1-sum2=targetSum;     where sum1>sum2;
            (totalSum-sum2)-sum2 = targetSum
            totalSum-targetSum = 2*sum2;
            sum2=(totalSum-targetSum)/2;
         */
        System.out.println("Memoization: " + memoizationRoot(arr, (totalSum - targetSum) / 2));
        System.out.println("Tabulation: " + tabulation(arr, (totalSum-targetSum)/2));
        System.out.println("Space Optimization: " + spaceOptimization(arr, (totalSum-targetSum)/2));

    }
}