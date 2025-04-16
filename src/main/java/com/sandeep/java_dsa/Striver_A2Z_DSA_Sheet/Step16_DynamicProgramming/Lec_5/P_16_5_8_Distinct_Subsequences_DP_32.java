package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step16_DynamicProgramming.Lec_5;

import java.util.Arrays;

public class P_16_5_8_Distinct_Subsequences_DP_32 {

    /*
        Naive recursion:
            T.C. -> exponential
            S.C. -> O(M+N)
     */

    /*
        Memoization:
            T.C. -> O(M*N)
            S.C. -> O(M*N) + O(M+N){RSS/ASS...Recursive Stack Space/Auxiliary Stack Space}
     */
    public static int memoizationRoot(String s1, String s2){
        int[][] dp = new int[s1.length()][s2.length()];
        Arrays.stream(dp).forEach(t-> Arrays.fill(t,-1));
        return memoization(s1.length()-1, s2.length()-1, s1, s2, dp);
    }

    public static int memoization(int i, int j, String s1, String s2, int[][] dp){
        if(j<0) return 1;
        if(i<0) return 0;

        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)) return dp[i][j]=memoization(i-1, j-1, s1, s2, dp)+memoization(i-1, j, s1, s2, dp);
        else return dp[i][j]=memoization(i-1, j, s1, s2, dp);
    }

    private static int tabulation(String s1, String s2){
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for (int i=0;i<=s1.length();i++) dp[i][0] = 1;
//        for(int j=1;j<=s2.length();j++) dp[0][j]=0;     //bec dp[0][0] will be 1 hence started from j=1...we can o,it this as well because by default all elements will be 0

        for(int i=1;i<=s1.length();i++){
            for(int j=1;j<=s2.length();j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)) dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                else dp[i][j]= dp[i-1][j];
            }
        }
        return dp[s1.length()][s2.length()];
    }

    private static int spaceOptimization(String s1, String s2){
        int[] prevRow = new int[s2.length()+1];
        prevRow[0]=1;
        for(int i=1;i<=s1.length();i++){
            int[] currRow = new int[s2.length()+1];
            currRow[0]=1;
            for (int j=1;j<=s2.length();j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)) currRow[j]=prevRow[j-1]+prevRow[j];
                else currRow[j]=prevRow[j];
            }
            prevRow=currRow;
        }
        return prevRow[s2.length()];
    }

    private static int spaceOptimizationTo1dArray(String s1, String s2){
        int[] prevRow = new int[s2.length()+1];
        for(int i=1;i<=s1.length();i++){
            prevRow[0]=1;
            for(int j=s2.length();j>=1;j--){
                if(s1.charAt(i-1)==s2.charAt(j-1)) prevRow[j]+=prevRow[j-1];
            }
        }
        return prevRow[s2.length()];
    }



    public static void main(String[] args) {

        String s1 = "babgbag";
        String s2 = "bag";

        System.out.println("Memoization: " + memoizationRoot(s1, s2));
        System.out.println("Tabulation: " + tabulation(s1, s2));
        System.out.println("Space Optimization: " + spaceOptimization(s1, s2));
        System.out.println("Space Optimization to 1d array: " + spaceOptimizationTo1dArray(s1, s2));
    }
}