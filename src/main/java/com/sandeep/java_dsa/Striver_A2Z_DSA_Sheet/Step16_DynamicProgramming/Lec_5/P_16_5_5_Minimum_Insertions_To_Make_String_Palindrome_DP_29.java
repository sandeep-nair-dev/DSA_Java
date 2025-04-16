package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step16_DynamicProgramming.Lec_5;

import java.util.Arrays;

public class P_16_5_5_Minimum_Insertions_To_Make_String_Palindrome_DP_29 {


    private static int minInsertionsToMakePalindrome(String s){
        String reversed = new StringBuilder(s).reverse().toString();
        int longestCommonSubseqLength = spaceOptimization(s, reversed);
        return s.length()-longestCommonSubseqLength;
    }

    private static int spaceOptimization(String s1, String s2){
        int[] prevRow = new int[s2.length()+1];
        Arrays.fill(prevRow, 0);
        for(int i=1;i<=s1.length();i++){
            int[] currRow = new int[s2.length()+1];
            for(int j=1;j<=s2.length();j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)) currRow[j]=1+prevRow[j-1];
                else currRow[j]=Math.max(currRow[j-1],prevRow[j]);
            }
            prevRow=currRow;
        }
        return prevRow[s2.length()];
    }

    public static void main(String[] args) {
        String s="leetcode";
        System.out.println("Minimum insertions to make string palindrome: " + minInsertionsToMakePalindrome(s));
    }
}