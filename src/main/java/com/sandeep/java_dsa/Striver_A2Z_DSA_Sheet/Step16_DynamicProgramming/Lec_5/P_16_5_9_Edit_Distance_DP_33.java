package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step16_DynamicProgramming.Lec_5;

import java.util.Arrays;

public class P_16_5_9_Edit_Distance_DP_33 {
    /*
        Basic Recursion:
            TC -> exponential..around 3^M * 3^N
            SC -> O(M+N)
     */


    private static int memoizationRoot(String s1, String s2){
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        Arrays.stream(dp).forEach(t-> Arrays.fill(t, -1));
        return memoization(s1.length()-1, s2.length()-1, s1, s2, dp);
    }

    /*
        Memoization:
            TC -> O(M*N)
            SC -> O(M*N) + O(M+N) {RSS}
     */
    private static int memoization(int i, int j, String s1, String s2, int[][] dp){
        if(i<0) return j+1;     //means s1 has exhausted, so to make s1=s2, we perform insert operation for each remaining character in s2
        if(j<0) return i+1;     //means s2 has exhausted, so to make s1=s2, we perform delete operation for each remaining character in s1

        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)) return dp[i][j]=memoization(i-1, j-1, s1, s2, dp);
        else {
            int insertion = 1+memoization(i, j-1, s1, s2, dp);
            int deletion = 1+ memoization(i-1, j, s1, s2, dp);
            int replace = 1+memoization(i-1, j-1, s1, s2, dp);
            return dp[i][j]= Math.min(insertion, Math.min(deletion, replace));
            // or 1+ Math.min(memoization(i, j-1, s1, s2, dp), Math.min(memoization(i-1, j, s1, s2, dp),memoization(i-1, j-1, s1, s2, dp)));
        }
    }

    private static int tabulation(String s1, String s2){
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for(int i=0;i<=s1.length();i++) dp[i][0]=i;
        for(int j=0;j<=s2.length();j++) dp[0][j]=j;

        for(int i=1;i<=s1.length();i++){
            for(int j=1;j<=s2.length();j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)) dp[i][j]=dp[i-1][j-1];
                else dp[i][j]=1+Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1]));
            }
        }
        return dp[s1.length()][s2.length()];
    }

    private static int spaceOptimization(String s1, String s2){
        int[] prevRow = new int[s2.length()+1];
        for(int j=0;j<=s2.length();j++) prevRow[j]=j;
        for(int i=1;i<=s1.length();i++){
            int[] currRow = new int[s2.length()+1];
            currRow[0]=i;
            for(int j=1;j<=s2.length();j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)) currRow[j]=prevRow[j-1];
                else currRow[j] = 1+ Math.min(currRow[j-1], Math.min(prevRow[j], prevRow[j-1]));
            }
            prevRow=currRow;
        }
        return prevRow[s2.length()];
    }

    public static void main(String[] args) {
        String s1 = "horse";
        String s2 = "ros";

        System.out.println("Minimum operations to be done (Memoization): " + memoizationRoot(s1, s2));
        System.out.println("Minimum operations to be done (Tabulation): " + tabulation(s1, s2));
        System.out.println("Minimum operations to be done (Space Optimization): " + spaceOptimization(s1, s2));
    }
}