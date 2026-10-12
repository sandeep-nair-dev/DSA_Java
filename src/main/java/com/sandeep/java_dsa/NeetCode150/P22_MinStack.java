package com.sandeep.java_dsa.NeetCode150;

import java.util.Stack;

public class P22_MinStack {
    Stack<int[]> minStack;

    public P22_MinStack() {
        minStack = new Stack<>();
    }

    public void push(int value) {
        int min = minStack.isEmpty() ? value : Math.min(value, minStack.peek()[1]);
        minStack.push(new int[]{value, min});
    }

    public void pop() {
        minStack.pop();
    }

    public int top() {
        return minStack.peek()[0];
    }

    public int getMin() {
        return minStack.peek()[1];
    }

    //--------------------------------------------2nd approach
    long min;

    Stack<Long> minStack2;

    public void push2(int value) {
        if (minStack.isEmpty()) {
            minStack2.push(0L);
            min = value;
        } else {
            minStack2.push(value - min);
            if (value < min) min = value;
        }
    }

    public void pop2() {
        if(minStack2.isEmpty()) return;
        long popped = minStack2.pop();
        if(popped<0) min=min-popped;
    }

    public int top2() {
        long top = minStack2.peek();
        if(top>0){
            return (int) (top+min);
        }else{
            return (int) min;
        }
    }

    public int getMin2() {
        return (int) min;
    }
}
