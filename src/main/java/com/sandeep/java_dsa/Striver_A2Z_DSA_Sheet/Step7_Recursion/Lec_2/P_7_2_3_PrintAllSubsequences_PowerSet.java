package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step7_Recursion.Lec_2;

import java.util.ArrayList;
import java.util.List;

public class P_7_2_3_PrintAllSubsequences_PowerSet {


    public static List<String> powerSetUsingBitManipulation(String s) {
        int n = s.length();
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i <= (1 << n) - 1; i++) {               // i<= (2^n -1)
            StringBuilder subStr = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    subStr.append(s.charAt(j));
                }
            }
            result.add(subStr.toString());
        }
        return result;
    }

    // Using recursion
    public static void recursion(int index, String input, String subseq, ArrayList<String> res) {
        if (index >= input.length()) {
            res.add(subseq);
            return;
        }

        subseq += input.charAt(index);
        recursion(index + 1, input, subseq, res);
        subseq = subseq.substring(0, subseq.length() - 1);
        recursion(index + 1, input, subseq, res);
        System.out.println();
    }

    public static List<String> powerSet(String s) {
        ArrayList<String> result = new ArrayList<>();
        recursion(0, s, "", result);
        return result;
    }

    public static void main(String[] args) {
        String string = "abc";
        List<String> strings = powerSet(string);
        List<String> stringsUsingBits = powerSetUsingBitManipulation(string);
        System.out.println(strings);
        System.out.println(stringsUsingBits);
    }
}
