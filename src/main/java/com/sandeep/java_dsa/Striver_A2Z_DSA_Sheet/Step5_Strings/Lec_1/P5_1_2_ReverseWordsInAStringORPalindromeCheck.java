package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step5_Strings.Lec_1;

public class P5_1_2_ReverseWordsInAStringORPalindromeCheck {
    public String reverseWords(String s) {
        String ans = "";
        s = s.trim();
        int start = s.length();
        for (int i = s.length() - 1; i >= 0; i--) {
            if ((s.charAt(i) == ' ' && s.charAt(i + 1) != ' ') || i == 0) {
                ans += (i == 0) ? s.substring(i, start) : s.substring(i + 1, start);
                start = i;
                if (i != 0) ans += ' ';
            } else if (s.charAt(i) == ' ') {
                start = i;
            }
        }
        return ans;
    }
}
