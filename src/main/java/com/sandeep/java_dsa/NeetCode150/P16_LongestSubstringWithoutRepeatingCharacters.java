package com.sandeep.java_dsa.NeetCode150;

import java.util.HashMap;
import java.util.HashSet;

public class P16_LongestSubstringWithoutRepeatingCharacters {


    /**
     * TC -> O(n)
     * SC -> O(m)       m-> total number of unique characters in the string
     */
    public static int solutionOptimal(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxCount = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                maxCount = Math.max(maxCount, i - start);
                start = Math.max(start, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
        }
        maxCount = Math.max(maxCount, s.length() - start);
        return maxCount;
    }

    /**
     * TC -> O(n)
     * SC -> O(m)       m-> total number of unique characters in the string
     */
    public static int solutionBetter(String s) {
        HashSet<Character> charSet = new HashSet<>();
        int start = 0;
        int maxCount = 0;
        for (int i = 0; i < s.length(); i++) {
            while (charSet.contains(s.charAt(i))){
                charSet.remove(s.charAt(start));
                start++;
            }
            charSet.add(s.charAt(i));
            maxCount = Math.max(maxCount, i-start+1);
        }
        return maxCount;
    }


    public static void main(String[] args) {
        String s = "abcdefgdijkl";
        System.out.println("Length of longest substring without repeating characters (Better) : " + solutionBetter(s));
        System.out.println("Length of longest substring without repeating characters (Optimal) : " + solutionOptimal(s));
    }
}
