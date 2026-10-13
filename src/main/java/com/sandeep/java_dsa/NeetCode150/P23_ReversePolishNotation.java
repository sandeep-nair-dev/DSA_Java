package com.sandeep.java_dsa.NeetCode150;

import java.util.Stack;

public class P23_ReversePolishNotation {

    static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String s : tokens) {
            switch (s) {
                case "+" -> stack.push(stack.pop() + stack.pop());
                case "-" -> {
                    int op2 = stack.pop();
                    int op1 = stack.pop();
                    stack.push(op1 - op2);
                }
                case "*" -> stack.push(stack.pop() * stack.pop());
                case "/" -> {
                    int op2 = stack.pop();
                    int op1 = stack.pop();
                    stack.push(op1 / op2);
                }
                default -> stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] tokens = new String[]{"4", "13", "5", "/", "+"};
        System.out.println(evalRPN(tokens));
    }
}
