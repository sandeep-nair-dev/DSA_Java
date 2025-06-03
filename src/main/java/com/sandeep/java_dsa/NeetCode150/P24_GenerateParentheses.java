package com.sandeep.java_dsa.NeetCode150;

import java.util.ArrayList;
import java.util.List;

public class P24_GenerateParentheses {

    public static void recursion(int openCount, int closedCount, String s, int k, ArrayList<String> result){
        if(openCount==k && closedCount==k){
            result.add(s);
            return;
        }

        if(openCount<k){
            recursion(openCount+1, closedCount, s+"(", k, result);
        }

        if(closedCount<openCount){
            recursion(openCount, closedCount+1, s+")",k,result);
        }
    }

    public static List<String> generateParentheses(int k){
        ArrayList<String> result = new ArrayList<>();
        recursion(0,0,"",k,result);
        return result;
    }

    public static void main(String[] args) {
        int k=3;
        System.out.println("Result: " + generateParentheses(k));

    }
}
