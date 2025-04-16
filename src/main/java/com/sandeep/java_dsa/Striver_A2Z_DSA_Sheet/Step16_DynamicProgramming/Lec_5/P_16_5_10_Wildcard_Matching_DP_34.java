package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step16_DynamicProgramming.Lec_5;

import java.util.Arrays;

public class P_16_5_10_Wildcard_Matching_DP_34 {
    /*
        Basic Recursion
            TC -> exponential
            SC -> O(M+N)
     */

    private static boolean memoizationRoot(String text, String pattern) {
        int[][] dp = new int[text.length()][pattern.length()];
        Arrays.stream(dp).forEach(t -> Arrays.fill(t, -1));
        return memoization(text.length() - 1, pattern.length() - 1, text, pattern, dp);
    }

    /*
        Memoization:
            TC -> O(M*N)
            SC -> O(M*N) + O(M+N){RSS}
     */
    private static boolean memoization(int i, int j, String text, String pattern, int[][] dp) {
        if (i < 0 && j < 0) return true;
        if (j < 0) return false;
        if (i < 0) {
            for (int p = 0; p <= j; p++) {
                if (pattern.charAt(p) != '*') return false;
            }
            return true;
        }

        if (dp[i][j] != -1) {
            return dp[i][j] == 1;
        }
        if (text.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '?') {
            boolean ret = memoization(i - 1, j - 1, text, pattern, dp);
            dp[i][j] = ret ? 1 : 0;
            return ret;
        } else {
            if (pattern.charAt(j) == '*') {
                boolean ret = memoization(i, j - 1, text, pattern, dp) || memoization(i - 1, j, text, pattern, dp);
                dp[i][j] = ret ? 1 : 0;
                return ret;
            } else {
                return false;
            }
        }
    }

    /*
        Tabulation:
            TC -> O(M*N)
            SC -> O(M*N)
     */
    public static boolean tabulation(String text, String pattern) {
        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];

        for (int i = 1; i <= text.length(); i++) {
            dp[i][0] = false;
        }
        for (int j = 1; j <= pattern.length(); j++) {
            boolean flag = true;
            for (int ptr = 0; ptr < j; ptr++) {
                if (pattern.charAt(ptr) != '*') {
                    flag = false;
                    break;
                }
            }
            dp[0][j] = flag;
        }
        dp[0][0] = true;

        for (int i = 1; i <= text.length(); i++) {
            for (int j = 1; j <= pattern.length(); j++) {
                if (text.charAt(i - 1) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '?')
                    dp[i][j] = dp[i - 1][j - 1];
                else {
                    if (pattern.charAt(j - 1) == '*') dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                    else dp[i][j] = false;
                }
            }
        }
        return dp[text.length()][pattern.length()];
    }

    private static boolean spaceOptimization(String text, String pattern) {
        boolean[] prev = new boolean[pattern.length() + 1];
        for (int j = 1; j <= pattern.length(); j++) {
            boolean flag = true;
            for (int p = 0; p < j; p++) {
                if (pattern.charAt(p) != '*') {
                    flag = false;
                    break;
                }
            }
            prev[j] = flag;
        }
        prev[0] = true;

        for (int i = 1; i <= text.length(); i++) {
            boolean[] curr = new boolean[pattern.length() + 1];
            for (int j = 1; j <= pattern.length(); j++) {
                boolean flag = true;
                for (int p = 0; p < j; p++) {
                    if (pattern.charAt(p) != '*') {
                        flag = false;
                        break;
                    }
                }
                curr[j] = flag;
            }
            curr[0] = false;
            for (int j = 1; j <= pattern.length(); j++) {
                if (text.charAt(i - 1) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '?') curr[j] = prev[j-1];
                else {
                    if (pattern.charAt(j - 1) == '*') curr[j] = curr[j - 1] || prev[j];
                    else curr[j] = false;
                }
            }
            prev = curr;
        }
        return prev[pattern.length()];
    }

//    private

    public static void main(String[] args) {

        String s1 = "aa";
        String s2 = "a";

        System.out.println("Memoization: " + (memoizationRoot(s1, s2)));
        System.out.println("Tabulation: " + (tabulation(s1, s2)));
        System.out.println("Space Optimization: " + (spaceOptimization(s1, s2)));
    }
}