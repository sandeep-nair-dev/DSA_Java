package com.sandeep.java_dsa.NeetCode150;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class P21_ValidParentheses {

    private static boolean checkValidParentheses2(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> closeToOpenMapping = new HashMap<>();
        closeToOpenMapping.put(')', '(');
        closeToOpenMapping.put(']', '[');
        closeToOpenMapping.put('}', '{');
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (!closeToOpenMapping.containsKey(curr)) {
                stack.push(curr);
            } else {

                if (!stack.isEmpty() && stack.peek() == closeToOpenMapping.get(curr)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private static boolean checkValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == '(' || curr == '[' || curr == '{') {
                stack.push(curr);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.peek();
                if ((curr == ')' && top == '(') || (curr == ']' && top == '[') || (curr == '}' && top == '{')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "([{}])";
        System.out.println(checkValidParentheses2(s));
    }
}
