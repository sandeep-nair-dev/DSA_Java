package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step16_DynamicProgramming.Lec_5;

public class P_16_5_3_Longest_Common_Substring_DP_27 {

    private static int tabulation(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        int ans = 0;
        for (int i = 0; i <= s1.length(); i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= s2.length(); i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 0;           //since we are checking substring, we dont need to rely on any common before the previous element if previous element doesn't matches, hence 0
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }

    private static int spaceOptimization(String s1, String s2) {
        int[] prevRow = new int[s2.length() + 1];
        int ans = 0;
        for (int i = 1; i <= s1.length(); i++) {
            int[] currRow = new int[s2.length() + 1];
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    currRow[j] = prevRow[j - 1] + 1;
                } else {
                    currRow[j] = 0;
                }
                ans = Math.max(ans, currRow[j]);
            }
            prevRow = currRow;
        }
        return ans;
    }

    public static void main(String[] args) {
        String s1 = "ABCDGH";
        String s2 = "ACDGHR";
        System.out.println("Length of Longest Common Substring (Tabulation): " + tabulation(s1, s2));
        System.out.println("Length of Longest Common Substring (Space Optimization): " + spaceOptimization(s1, s2));
    }
}