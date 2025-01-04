package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step5_Strings.Lec_1;

public class P5_1_1_RemoveOutermostParentheses {
    public String removeOuterParentheses(String s) {
        int open = 0;
        String ans="";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '(' && open++>0) ans+=s.charAt(i);
            else if(s.charAt(i) == ')' && open-->1) ans+=s.charAt(i);
        }
        return ans;

    }
}
