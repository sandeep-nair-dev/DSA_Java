package com.sandeep.java_dsa.NeetCode150;


import java.util.HashMap;
import java.util.HashSet;

/**
 * <h5><b>Longest Repeating Character Replacement</b></h5>
 * You are given a string {@code s} consisting of only uppercase English characters and an integer {@code k}.
 * You can choose up to {@code k} characters of the string and replace them with any other uppercase English character.
 * <p>
 * After performing at most {@code k} replacements, return the length of the longest substring
 * which contains only one distinct character.
 * <p>
 * <b>Example 1:</b><br>
 * Input: {@code s = "XYYX"}, {@code k = 2}<br>
 * Output: {@code 4}<br>
 * Explanation: Either replace the 'X's with 'Y's, or replace the 'Y's with 'X's.
 * <p>
 * <b>Example 2:</b><br>
 * Input: {@code s = "AAABABB"}, {@code k = 1}<br>
 * Output: {@code 5}
 * <p>
 * <b>Constraints:</b><br>
 * {@code 1 <= s.length <= 1000}<br>
 * {@code 0 <= k <= s.length}
 */

public class P17_LongestRepeatingCharacterReplacement {

    public static int solutionBrute(String s, int k){
        int maxlength=0;
        for(int i=0;i<s.length();i++){
            HashMap<Character, Integer> map = new HashMap<>();
            int maxFreq = 0;
            for(int j=i;j<s.length();j++){
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0)+1);
                maxFreq = Math.max(maxFreq, map.get(s.charAt(j)));
                if((j-i+1)-maxFreq <=k){
                    maxlength = Math.max(maxlength, j-i+1);
                }
            }
        }
        return maxlength;
    }

    /**
     * TC-> O(m*n)
     * SC-> O(m)
     * m is total no of unique characters in the string
     *
     * For each unique character we are traversing the whole array to check at each point windowSize - maxFreqCount <k and if yes then we are considering that for result otherwise we are moving the letf pointer and if character at left pointer is current pointer then decreasing the count too;
     */
    public static int solutionOptimal(String s, int k){
        int res=0;
        HashSet<Character> set = new HashSet<>();
        for(char ch:s.toCharArray()){
            set.add(ch);
        }

        for(char ch: set){
            int count=0;
            int l=0;
            for(int r=0;r<s.length();r++){
                if(s.charAt(r)==ch){
                    count++;
                }

                while ((r-l+1) - count >k){
                    if(s.charAt(l)==ch) {
                        count--;
                    }
                    l++;
                }

                res = Math.max(res, r-l+1);
            }
        }
        return res;
    }

    public static int solutionOptimalButLessIntuitive(String s, int k){
        int result=0;
        int l=0, r=0;
        HashMap<Character, Integer> map = new HashMap<>();
        while(r<s.length()){
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r),0)+1);
            int count = map.values().stream().max((a, b)-> b-a).get();
            while ((r-l+1)-count>k){
                map.put(s.charAt(l), map.getOrDefault(s.charAt(l),0)-1);
                l++;
                result = Math.max(result, r-l+1);
            }
            r++;
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "ABBB";
        int k=2;
        System.out.println("Longest Repeating Character Replacement (Brute): " + solutionBrute(s,k));
        System.out.println("Longest Repeating Character Replacement (Optimal): " + solutionOptimal(s,k));
        System.out.println("Longest Repeating Character Replacement (Optimal): " + solutionOptimalButLessIntuitive(s,k));
    }
}
