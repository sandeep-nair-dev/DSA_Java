package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step7_Recursion.Lec_1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Stack;

public class P_7_1_4_SortAStack {
    public static Stack<Integer> directMethod(Stack<Integer> s) {
        s.sort(Comparator.naturalOrder());
        return s;
    }

    public static Stack<Integer> method2(Stack<Integer> s) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (!s.isEmpty()) arrayList.add(s.pop());
        arrayList.sort(Comparator.naturalOrder());
        arrayList.forEach(s::push);
        return s;
    }

    // Using Recursion
    public static Stack<Integer> method3Recursive(Stack<Integer> s) {
        if (s.size() == 1) return s;
        Integer poppedValue = s.pop();
        s = method3Recursive(s);
        Stack<Integer> temp2 = new Stack<>();
        while (!s.isEmpty() && poppedValue < s.peek()) {
            temp2.push(s.pop());
        }
        s.push(poppedValue);
        while (!temp2.isEmpty()) {
            s.push(temp2.pop());
        }
        return s;
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
        Stack<Integer> s1 = method3Recursive(s);
        System.out.println(s1);
        System.out.println(s1.peek());
    }
}
