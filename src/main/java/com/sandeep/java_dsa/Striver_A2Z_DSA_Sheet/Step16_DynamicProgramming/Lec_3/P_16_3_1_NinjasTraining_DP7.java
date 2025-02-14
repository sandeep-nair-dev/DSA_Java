package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step16_DynamicProgramming.Lec_3;

import java.util.Arrays;

public class P_16_3_1_NinjasTraining_DP7 {

    // T.C -> O(N*4)*3
    //S.C -> O(N)+O(N*4)            O(N) is the recursion stack space
    private static int memoization(int ind, int lastTask, int[][] arr, int[][] dp) {
        if (ind == 0) {
            int maxi = Integer.MIN_VALUE;
            for (int i = 0; i < 3; i++) {
                if (i != lastTask) maxi = Math.max(maxi, arr[0][i]);
            }
            return maxi;
        }

        if (dp[ind][lastTask] != -1) return dp[ind][lastTask];

        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < 3; i++) {
            if (i != lastTask) maxi = Math.max(maxi, arr[ind][i] + memoization(ind - 1, i, arr, dp));
        }
        return dp[ind][lastTask] = maxi;
    }

    //T.C -> O(N*4*3)
    //S.C -> O(N*4)
    private static int tabulation(int[][] arr) {
        int[][] dp = new int[arr.length][4];
        for (int i = 0; i < 4; i++) {
            int maxi = 0;
            for (int j = 0; j < 3; j++) {
                if (i != j) maxi = Math.max(maxi, arr[0][j]);
            }
            dp[0][i] = maxi;
        }

        for (int day = 1; day < arr.length; day++) {
            for (int last = 0; last < 4; last++) {
                dp[day][last] = 0;
                for (int task = 0; task < 3; task++) {
                    if (task != last) dp[day][last] = Math.max(dp[day][last], dp[day - 1][task] + arr[day][task]);
                }
            }
        }
        return dp[arr.length - 1][3];
    }


    //S.C -> O(N*4*3)
    //T.C -> O(4)
    private static int spaceOptimization(int[][] arr){
        int[] prev = new int[4];
        for(int i=0;i<4;i++){
            prev[i]=0;
            for(int j=0;j<3;j++){
                if(i!=j) prev[i]=Math.max(prev[i], arr[0][j]);
            }
        }

        for(int day=1;day<arr.length;day++){
            int[] curr = new int[4];
            for(int last=0;last<4;last++){
                curr[last]=0;
                for(int task=0;task<3;task++){
                    if(task!=last) curr[last] = Math.max(curr[last], arr[day][task] + prev[task]);
                }
            }
//            int[] temp = prev.clone();
            prev=curr;
//            curr = temp.clone();
        }
        return prev[3];
    }

    public static void main(String args[]) {
        // Define the points for each activity on each day
        int[][] points = {{1, 2, 5},
                {3, 1, 1},
                {3, 3, 3}};

        int n = points.length; // Get the number of days
        int[][] dp = new int[points.length][4];
        Arrays.stream(dp).forEach(t -> Arrays.fill(t, -1));
        System.out.println("Memoization: " + memoization(points.length - 1, 3, points, dp));
        System.out.println("Tabulation: " + tabulation(points));
        System.out.println("Space Optimized: " + spaceOptimization(points));

    }
}