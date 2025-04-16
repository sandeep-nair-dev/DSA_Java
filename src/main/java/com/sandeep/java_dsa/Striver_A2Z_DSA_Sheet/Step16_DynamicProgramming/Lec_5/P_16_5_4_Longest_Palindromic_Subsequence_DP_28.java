package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step16_DynamicProgramming.Lec_5;

import java.util.Arrays;

public class P_16_5_4_Longest_Palindromic_Subsequence_DP_28 {

    private static int tabulation(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) dp[i][0] = 0;
        for (int i = 0; i <= s2.length(); i++) dp[0][i] = 0;

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) dp[i][j] = 1 + dp[i - 1][j - 1];
                else dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }

        return dp[s1.length()][s2.length()];
    }

    private static int spaceOptimization(String s1, String s2) {
        int[] prevRow = new int[s2.length() + 1];
        Arrays.fill(prevRow, 0);
        for (int i = 1; i <= s1.length(); i++) {
            int[] currRow = new int[s2.length() + 1];
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) currRow[j] = 1 + prevRow[j - 1];
                else currRow[j] = Math.max(currRow[j - 1], prevRow[j]);
            }
            prevRow = currRow;
        }
        return prevRow[s2.length()];
    }

    private static String tabulationWithSubsequence(String s1, String s2) {
        StringBuilder ans = new StringBuilder();
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) dp[i][0] = 0;
        for (int i = 0; i <= s2.length(); i++) dp[0][i] = 0;

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) dp[i][j] = 1 + dp[i - 1][j - 1];
                else dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }

        int i = s1.length(), j = s2.length();
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                ans.append(s1.charAt(i - 1));
                i--;
                j--;
            } else {
                if (dp[i - 1][j] > dp[i][j - 1]) i--;
                else j--;
            }
        }
        return ans.toString();
    }

    private static String longestPalindromicSubsequence(String s) {
        String reversed = new StringBuilder(s).reverse().toString();
        return tabulationWithSubsequence(s, reversed);
    }

    public static void main(String[] args) {

        String s = "bbbab";
        System.out.println("Longest Palindromic subsequence length: " + tabulation(s, new StringBuilder(s).reverse().toString()));
        System.out.println("Longest Palindromic subsequence length: " + spaceOptimization(s, new StringBuilder(s).reverse().toString()));
        System.out.println("Longest Palindromic subsequence: " + longestPalindromicSubsequence(s));
    }
}