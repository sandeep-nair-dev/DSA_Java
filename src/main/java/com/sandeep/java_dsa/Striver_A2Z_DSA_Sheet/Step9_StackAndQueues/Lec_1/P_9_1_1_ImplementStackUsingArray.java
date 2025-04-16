package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step9_StackAndQueues.Lec_1;

public class P_9_1_1_ImplementStackUsingArray {
    int size = 1000;
    int top = -1;
    int stack[] = new int[size];

    void push(int x) {
        if (top >= size) {
            System.out.println("Stack is full");
            System.exit(1);
        }
        top++;
        stack[top] = x;
    }

    int pop() {
        if (top < 0) {
            System.out.println("Empty Stack");
            System.exit(1);
        }
        int result = stack[top];
        top--;
        return result;
    }

    int top() {
        if (top < 0) {
            System.out.println("Empty Stack");
            System.exit(1);
        }
        return stack[top];
    }

    int size() {
        return top + 1;
    }
}
