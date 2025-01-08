package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step5_Strings.Lec_1;

import java.util.Arrays;

public class P5_1_4_LongestCommonPrefix {

    public String longestCommonPrefixWay2(String[] strs) {
        //Clever way--> sort lexicographically, in this way, the common prefix would be there in first as well as last string, in this way we only need to compare between these 2 strings
        String ans = "";
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];
        for (int i = 0; i < Math.min(first.length(), last.length()); i++) {
            if (first.charAt(i) != last.charAt(i)) {
                return ans;
            }
            ans += first.charAt(i);
        }
        return ans;
    }

    public String longestCommonPrefixWay1(String[] strs) {
        String ans = "";
        int mini = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            mini = Math.min(mini, strs[i].length());
        }
        for (int i = 0; i < mini; i++) {
            boolean common = true;
            char character = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != character) {
                    common = false;
                }
            }
            if (common) {
                ans += character;
            } else {
                break;
            }
        }
        return ans;
    }
}
