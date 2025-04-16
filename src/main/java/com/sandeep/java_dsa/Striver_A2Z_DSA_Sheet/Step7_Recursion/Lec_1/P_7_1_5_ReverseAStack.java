package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step7_Recursion.Lec_1;

import java.util.Stack;

public class P_7_1_5_ReverseAStack {
    //method 1: copy s to new stack and then pop from new and push to original stack
    public static void reverse1(Stack<Integer> s) {
        // add your code here
        Stack<Integer> s2 = (Stack<Integer>) s.clone();
        s.removeAllElements();
        while (!s2.isEmpty()) {
            s.push(s2.pop());
        }
    }

    //method2: pop from stack and push elements to an arraylist, now parse the arraylist and push back to stack

    //method3: Using recursion
    public static void reverse3Recursion(Stack<Integer> s) {
        if (s.size() == 1) return;
        Integer poppedValue = s.pop();
        reverse3Recursion(s);
        Stack<Integer> temp = new Stack<>();
        while (!s.isEmpty()) temp.push(s.pop());
        s.push(poppedValue);
        while (!temp.isEmpty()) s.push(temp.pop());
    }


    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();

        s.push(41);
        s.push(3);
        s.push(32);
        s.push(2);
        s.push(11);
        System.out.println(s);
//        System.out.println(directMethod(s));
//        Stack<Integer> s1 = method2(s);
        reverse3Recursion(s);
        System.out.println(s);
    }
}
