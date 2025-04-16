package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step7_Recursion.Lec_2;

import java.util.ArrayList;
import java.util.List;

public class P_7_2_2_GenerateParantheses {

    public static void recursion(String str, int open, int closed, int n, ArrayList<String> res) {
        if (open == n && closed == n) {
            res.add(str);
        }
        if (open < n) {
            recursion(str + "(", open + 1, closed, n, res);
        }
        if (closed < open) {
            recursion(str + ")", open, closed + 1, n, res);
        }
    }

    public static List<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<>();
        recursion("", 0, 0, n, result);
        return result;
    }

    public static void main(String[] args) {
        List<String> strings = generateParenthesis(25);
        System.out.println(strings);
    }
}