package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step9_StackAndQueues.Lec_1;

import java.util.Stack;

/**
 * <h3><b>Problem Statement:</b></h3>
 *<p>Check Balanced Parentheses. Given string str containing just the characters '(', ')', '{', '}', '[' and ']', check if the input string is valid and return true if the string is balanced otherwise return false.<br>
 *
 * Note: string str is valid if:<br>
 *
 * Open brackets must be closed by the same type of brackets.<br>
 * Open brackets must be closed in the correct order.<br><br>
 * Example 1:<br>
 *
 * Input: str = “( )[ { } ( ) ]”<br>
 *
 * Output: True<br>
 *
 * Explanation: As every open bracket has its corresponding
 * close bracket. Match parentheses are in correct order
 * hence they are balanced.<br>
 * Example 2:<br>
 *
 * Input: str = “[ ( )”<br>
 *
 * Output: False<br>
 *
 * Explanation: As ‘[‘ does not have ‘]’ hence it is
 * not valid and will return false.<br></p>
 */
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
