package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step9_StackAndQueues.Lec_1;

import java.util.Stack;

public class P_9_1_4_ImplementQueueUsingStack {
    static class Approach1 {        //push operation is expensive than pop and top

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        void push(int x) {
            while (!s1.empty()) {
                s2.push(s1.pop());
            }
            s1.push(x);
            while (!s2.empty()) {
                s1.push(s2.pop());
            }
        }

        int pop() {
            return s1.pop();
        }

        int peek() {
            return s1.peek();
        }

        int size() {
            return s1.size();
        }
    }

    static class Approach2 {        // pop and top expensive as compared to push
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        void push(int x) {
            s1.push(x);
        }

        int pop() {
            if (s2.empty()) {
                while (!s1.empty()) {
                    s2.push(s1.pop());
                }
            }
            return s2.pop();
        }

        int peek() {
            if (s2.empty()) {
                while (!s2.empty()) {
                    s2.push(s1.pop());
                }
            }
            return s2.peek();
        }

        int size() {
            return s2.size() + s1.size();
        }

    }

    public static void main(String args[]) {
//        Approach1 q = new Approach1();
        Approach2 q = new Approach2();
        q.push(3);
        q.push(4);
        System.out.println("The element popped is " + q.pop());
        q.push(5);
        System.out.println("The top element is " + q.peek());
        System.out.println("The size of the queue is " + q.size());

    }
}
