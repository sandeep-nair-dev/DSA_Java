package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step9_StackAndQueues.Lec_2;

import java.util.Stack;

public class P_9_2_6_InfixToPrefix {

    public static int getPriority(char c) {
        return switch (c) {
            case '^' -> 3;
            case '*', '/' -> 2;
            case '+', '-' -> 1;
            default -> -1;
        };
    }

    public static String reverseStringAndConvertParenthesis(String string) {
        char[] s = string.toCharArray();
        int i = 0, j = s.length - 1;
        while (i != j) {
            if (s[i] == '(') {
                s[i] = ')';
            } else if (s[i] == ')') {
                s[i] = '(';
            }

            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
        return new String(s);
    }

    public static String convertInfixToPrefix(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder ans = new StringBuilder();
        s = reverseStringAndConvertParenthesis(s);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                ans.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    ans.append(stack.pop());
                }
                stack.pop();
            } else {
                if (c == '^') {
                    while (!stack.isEmpty() && getPriority(c) <= getPriority(stack.peek())) {
                        ans.append(stack.pop());
                    }
                } else {
                    while (!stack.isEmpty() && getPriority(c) < getPriority(stack.peek())) {
                        ans.append(stack.pop());
                    }
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }
        return reverseStringAndConvertParenthesis(ans.toString());
    }

    public static void main(String[] args) {
        String exp = "(A+B)*C-D+F";
        System.out.println("Infix expression: " + exp);
        System.out.println("Prefix expression: " + convertInfixToPrefix(exp));
    }
}
