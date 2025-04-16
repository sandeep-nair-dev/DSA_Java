package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step16_DynamicProgramming.Lec_5;

public class P_16_5_7_Shortest_Common_Supersequence_DP_31 {


    //In this we are finding the common subsequence then traversing both strings and getting the resultant string
//    private static String findShortestCommonSupersequence(String s1, String s2){
//        String common = longestSubsequence(s1, s2);
//        StringBuilder ans = new StringBuilder();
//        int p1=0, p2=0, pc=0;
//
//        while(pc<common.length()){
//            while(p1<s1.length() && s1.charAt(p1)!=common.charAt(pc)){
//                ans.append(s1.charAt(p1));
//                p1++;
//            }
//            while(p2<s2.length() && s2.charAt(p2)!=common.charAt(pc)){
//                ans.append(s2.charAt(p2));
//                p2++;
//            }
//            ans.append(common.charAt(pc));
//            pc++;
//            p1++;
//            p2++;
//        }
//        while(p1<s1.length()){
//            ans.append(s1.charAt(p1));
//            p1++;
//        }
//        while(p2<s2.length()){
//            ans.append(s2.charAt(p2));
//            p2++;
//        }
//        return ans.toString();
//    }

    //here we find the answer directly while traversing the dp table, we take elements in ans even if s1.charAt(i)!=s2.charAt(j)
    /*
        T.C. -> O(m*n)
        S.C. -> O(m*n)
     */
    private static String longestSubsequence(String s1, String s2){
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for(int i=0;i<=s1.length();i++) dp[i][0]=0;
        for(int i=0;i<=s2.length();i++) dp[0][i]=0;
        for(int i=1;i<=s1.length();i++){
            for(int j=1;j<=s2.length();j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)) dp[i][j]=1+dp[i-1][j-1];
                else dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        StringBuilder ans = new StringBuilder();
        int i=s1.length(), j=s2.length();
        while (i > 0 && j > 0) {
            if (s1.charAt(i-1)==s2.charAt(j-1)) {
                ans.insert(0, s1.charAt(i-1));
                i--;
                j--;
            }
            else{
                if(dp[i][j-1]>dp[i-1][j]) {
                    ans.insert(0, s2.charAt(j-1));
                    j--;
                }
                else {
                    ans.insert(0, s1.charAt(i-1));
                    i--;
                }
            }
        }
        while(i>0){
            ans.insert(0, s1.charAt(i-1));
            i--;
        }
        while(j>0){
            ans.insert(0, s2.charAt(j-1));
            j--;
        }
        return ans.toString();
    }

    public static void main(String[] args) {

        String s1 = "abac";
        String s2 = "cab";

        System.out.println("Shortest Common Supersequence: " + longestSubsequence(s1, s2));
    }
}