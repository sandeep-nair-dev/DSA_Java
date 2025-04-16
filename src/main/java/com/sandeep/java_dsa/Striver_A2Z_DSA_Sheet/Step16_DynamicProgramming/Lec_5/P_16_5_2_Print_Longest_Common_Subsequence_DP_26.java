package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step16_DynamicProgramming.Lec_5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_16_5_2_Print_Longest_Common_Subsequence_DP_26 {

    private static String solutionViaTabulation(String s1, String s2){
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for(int i=0;i<=s1.length();i++){
            dp[i][0]=0;
        }
        for(int i=0;i<=s2.length();i++){
            dp[0][i]=0;
        }
        for(int i=1;i<=s1.length();i++){
            for(int j=1;j<=s2.length();j++){
                if(s1.charAt(i-1)==s2.charAt(j-1))dp[i][j]=1+dp[i-1][j-1];
                else dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        int i=s1.length(), j=s2.length();
        StringBuilder res = new StringBuilder();
        while(i>0 && j>0){
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                res.insert(0, s1.charAt(i - 1));
                i--;
                j--;
            }else{
                if(dp[i-1][j]>dp[i][j-1]) i--;
                else j--;
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {

        String s1 = "abcde";
        String s2 = "bdgek";

        List<String> result = new ArrayList<>();
        System.out.println("LCS(Longest common subsequence): "  +solutionViaTabulation(s1, s2));

    }
}