package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step5_Strings.Lec_1;

public class P5_1_3_LargestOddNumberInAString {
    public String largestOddNumber(String num) {
        for (int i = num.length() - 1; i >= 0; i--) {
            if (Character.getNumericValue(num.charAt(i)) % 2 != 0) {
                return num.substring(0, i + 1);
            }
        }
        return "";
    }
}
