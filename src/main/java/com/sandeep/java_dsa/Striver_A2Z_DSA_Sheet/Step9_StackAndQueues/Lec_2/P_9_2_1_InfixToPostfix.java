package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step9_StackAndQueues.Lec_2;

import java.util.Stack;

public class P_9_2_1_InfixToPostfix {

    public static int getPriority(char c) {
        return switch (c) {
            case '^' -> 3;
            case '*', '/' -> 2;
            case '+', '-' -> 1;
            default -> -1;
        };
    }

    public static String convertInfixToPostfix(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {       //can use Character.isLetterOrDigit(c)
                ans.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    ans.append(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && getPriority(c) <= getPriority(stack.peek())) {
                    ans.append(stack.pop());
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String exp = "a+b*(c^d-e)";
        System.out.println("Infix expression: " + exp);
        System.out.println("Postfix expression: " + convertInfixToPostfix(exp));
    }
}
