package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step16_DynamicProgramming.Lec_5;

import java.util.Arrays;

public class P_16_5_1_Longest_Common_Subsequence_DP_25 {

    /*
        Brute Force-> Calculate all subsequences of s1 and s2 and then take the longest common
        T.C -> O(2^m + 2^n)
     */

    /*
        Memoization:
            T.C. -> O(m*n)
            S.C. -> O(m*n) + O(m+n){Auxiliary space/Recursive stack space: in case of no match, tree branches to 2 in which in one we remove one element from s1 and one from s2, so longest length from root is going to be m+n, therefore O(m+n)
     */
    private static int memoizationRoot(String s1, String s2) {
        int[][] dp = new int[s1.length()][s2.length()];
        Arrays.stream(dp).forEach(t -> Arrays.fill(t, -1));
        return memoization(s1.length() - 1, s2.length() - 1, s1, s2, dp);
    }

    private static int memoization(int ind1, int ind2, String s1, String s2, int[][] dp) {
        if (ind1 < 0 || ind2 < 0) return 0;

        if (dp[ind1][ind2] != -1) return dp[ind1][ind2];
        if (s1.charAt(ind1) == s2.charAt(ind2)) {
            return dp[ind1][ind2] = 1 + memoization(ind1 - 1, ind2 - 1, s1, s2, dp);
        }
        return dp[ind1][ind2] = Math.max(memoization(ind1 - 1, ind2, s1, s2, dp), memoization(ind1, ind2 - 1, s1, s2, dp));
    }

    /*
        Tabulation:
            T.C. -> O(m*n)
            S.C. -> O(m*n)
     */
    private static int tabulation(String s1, String s2) {
        // to accommodate for -1 index, we do shifting of index, so index 0 is treated as -1, 1 is treated as 0, n is treated as n-1 and so on
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= s2.length(); j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[s1.length()][s2.length()];
    }

    /*
        Space Optimization:
            T.C. -> O(m*n)
            S.C. -> O(n+n) = O(2n)
     */
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

    public static void main(String[] args) {

        String s1 = "acd";
        String s2 = "ced";

        System.out.println("Memoization: " + memoizationRoot(s1, s2));
        System.out.println("Tabulation: " + tabulation(s1, s2));
        System.out.println("Space Optimization: " + spaceOptimization(s1, s2));
    }
}
