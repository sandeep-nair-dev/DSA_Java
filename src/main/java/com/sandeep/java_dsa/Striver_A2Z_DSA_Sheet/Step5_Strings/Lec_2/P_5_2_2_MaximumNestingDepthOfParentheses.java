package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step5_Strings.Lec_2;

public class P_5_2_2_MaximumNestingDepthOfParentheses {
    public int maxDepth(String s) {
        int depth = 0;
        int maxDepth = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') depth++;
            else if (ch == ')') depth--;

            if (depth > maxDepth) maxDepth = depth;
        }

        return maxDepth;
    }
}
