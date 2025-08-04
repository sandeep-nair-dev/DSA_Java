package com.sandeep.java_dsa.NeetCode150;

/**
 * <h5><b>Permutation in String</b></h5>
 * <p>
 * You are given two strings {@code s1} and {@code s2}.
 * <br>
 * Return {@code true} if {@code s2} contains a permutation of {@code s1}, or {@code false} otherwise.
 * That means if a permutation of {@code s1} exists as a substring of {@code s2}, then return {@code true}.
 * <p>
 * Both strings consist only of lowercase English letters.
 * <p>
 * <b>Example 1:</b><br>
 * Input: {@code s1 = "abc"}, {@code s2 = "lecabee"}<br>
 * Output: {@code true}<br>
 * Explanation: The substring {@code "cab"} is a permutation of {@code "abc"} and is present in {@code "lecabee"}.
 * <p>
 * <b>Example 2:</b><br>
 * Input: {@code s1 = "abc"}, {@code s2 = "lecaabee"}<br>
 * Output: {@code false}
 * <p>
 * <b>Constraints:</b><br>
 * {@code 1 <= s1.length, s2.length <= 1000}
 */

public class P18_PermutationInString {

    public static boolean checkPermutationExist(String s1, String s2){
        if(s1.length()>s2.length()) return false;
        int[] countS1 = new int[26];
        int[] countS2 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            countS1[s1.charAt(i) - 'a']++;
            countS2[s2.charAt(i) - 'a']++;
        }

        int matches=0;
        for(int i=0;i<26;i++){
            if(countS1[i]==countS2[i]){
                matches++;
            }
        }

        int l=0;
        int r=s1.length();
        while (r<s2.length()){
            if(matches==26) return true;

            int index = s2.charAt(r)-'a';
            countS2[index]++;
            if(countS1[index]==countS2[index]){
                matches++;
            }else if(countS1[index]+1==countS2[index]){
                matches--;
            }

            index = s2.charAt(l)-'a';
            countS2[index]--;
            if(countS1[index]==countS2[index]){
                matches++;
            }else if(countS1[index]-1==countS2[index]){
                matches--;
            }
            l++;
            r++;
        }
        return matches==26;
    }

    public static void main(String[] args) {
        String s1 ="abc";
        String s2 = "lecabee";

        System.out.println("Is Permutation valid: " + checkPermutationExist(s1, s2));
    }
}
