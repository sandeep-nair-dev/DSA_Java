package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step16_DynamicProgramming.Lec_2;

import java.util.ArrayList;
import java.util.Arrays;

public class P_16_2_3_FrogJumpWithKDistances_DP_4 {

    //T.C. -> O(n*k)
    public static int memoization(int ind, int[] height, int k, int[] dp) {
        if (ind == 0) return 0;
        if (dp[ind] != -1) return dp[ind];
        int minEnergy = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            if (ind >= i) {                //ind-i>=0
                int currEnergy = memoization(ind - i, height, k, dp) + Math.abs(height[ind] - height[ind - i]);
                minEnergy = Math.min(minEnergy, currEnergy);
            }
        }
        return dp[ind] = minEnergy;
    }

    public static int tabulation(int[] height, int k) {
        int[] dp = new int[height.length];
        dp[0] = 0;
        for (int i = 1; i < height.length; i++) {
            int minEnergy = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i >= j) {
                    int currEnergy = dp[i - j] + Math.abs(height[i] - height[i - j]);
                    minEnergy = Math.min(minEnergy, currEnergy);
                }
            }
            dp[i] = minEnergy;
        }
        return dp[height.length - 1];
    }

    // instead of maintaining dp of size n, we can maintain dp array of size k, and as we are adding latest element we can remove the first element
    // not particularly useful because if we have k=n, then in that case no space is optimized
    public static int spaceOptimized(int[] height, int k) {             //Not working at the moment
        ArrayList<Integer> opDp = new ArrayList<>();
        opDp.add(0);
        for (int i = 1; i < height.length; i++) {
            int minEnergy = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i >= j) {
                    System.out.println("i:" + i + "     j:" + j);
                    int currEnergy = opDp.get(((i - j) % k)) + Math.abs(height[i] - height[j]);
                    minEnergy = Math.min(minEnergy, currEnergy);
                }
            }
            opDp.add(minEnergy);
            if(opDp.size()>k) opDp.removeFirst();
        }
        opDp.forEach(System.out::println);
        return opDp.getLast();
    }

    public static void main(String[] args) {
        int[] height = {10, 30, 40, 50, 20};
        int n = height.length;
        int k = 3;
        int[] dp = new int[height.length];
        Arrays.fill(dp, -1);
        System.out.println("Memoization:" + memoization(height.length - 1, height, k, dp));
        System.out.println("Tabulation:" + tabulation(height, k));
        System.out.println("Space Optimized:" + spaceOptimized(height, k));

    }
}