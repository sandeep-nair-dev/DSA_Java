package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step9_StackAndQueues.Lec_1;

import java.util.Stack;

public class P_9_1_7_CheckForBalancedParenthesis {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                Character peek = stack.peek();
                if ((c == ')' && peek == '(') || (c == ']' && peek == '[') || (c == '}' && peek == '{')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {

        String s = "[";
        if (isValid(s))
            System.out.println("True");
        else
            System.out.println("False");
    }
}
