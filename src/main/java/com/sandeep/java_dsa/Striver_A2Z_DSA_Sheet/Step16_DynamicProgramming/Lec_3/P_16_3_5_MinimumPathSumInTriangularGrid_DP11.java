package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step16_DynamicProgramming.Lec_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_16_3_5_MinimumPathSumInTriangularGrid_DP11 {

    public static int memoization(int row, int col, List<List<Integer>> arr, int [][]dp){
        if(row==arr.size()-1 ){
            return arr.get(row).get(col);
        }
        if(dp[row][col]!=-1) return dp[row][col];
        int left = arr.get(row).get(col)+memoization(row+1, col,arr, dp);
        int right = arr.get(row).get(col)+memoization(row+1, col+1, arr, dp);
        return dp[row][col]=Math.min(left, right);
    }

    public static int tabulation(List<List<Integer>> arr){
        int m = arr.size();
        int n = arr.getLast().size();
        int[][] dp = new int[m][n];

        for(int i=m-1;i>=0;i--){
            for(int j=i;j>=0;j--){
                if(i==m-1){
                    dp[i][j] = arr.get(i).get(j);
                }else{
                    dp[i][j] = arr.get(i).get(j) + Math.min(dp[i+1][j], dp[i+1][j+1]);
                }
            }
        }
        return dp[0][0];
    }

    public static int spaceOptimization(List<List<Integer>> arr){
        int m = arr.size();
        int n = arr.getLast().size();
        int[] aheadRow = new int[n];
        for(int i=m-1;i>=0;i--){
            int[] currRow = new int[i+1];
            for(int j=i;j>=0;j--){
                if(i==m-1){
                    currRow[j]=arr.get(i).get(j);
                }
                else{
                    currRow[j]=arr.get(i).get(j) + Math.min(aheadRow[j], aheadRow[j+1]);
                }
            }
            aheadRow = currRow;
        }
        return aheadRow[0];
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(List.of(2));
        triangle.add(List.of(3,4));
        triangle.add(List.of(6,5,7));
        triangle.add(List.of(4,1,8,3));

        int n = triangle.size();
        int m = triangle.getLast().size();
        int[][] dp = new int[m][n];
        Arrays.stream(dp).forEach(r -> Arrays.fill(r, -1));
        System.out.println("Memoization: " + memoization(0, 0, triangle, dp));
        System.out.println("Tabulation: " + tabulation(triangle));
        System.out.println("Space Optimization: " + spaceOptimization(triangle));
    }
}