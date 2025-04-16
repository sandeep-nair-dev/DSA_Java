package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step9_StackAndQueues.Lec_1;

import java.util.Stack;

public class P_9_1_8_ImplementMinStack {
    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    //Approach 1: SC -> O(2*n)
    static class MinStack1 {
        Stack<Pair> stack = new Stack<>();

        public void push(int val) {
            int min = val;
            if (!stack.isEmpty()) {
                min = Math.min(stack.peek().y, val);
            }
            stack.push(new Pair(val, min));
        }

        public int pop() {
            Pair top = stack.peek();
            stack.pop();
            return top.x;
        }

        public int top() {
            return stack.peek().x;
        }

        public int getMin() {
            return stack.peek().y;
        }
    }

    //Approach 2; SC -> O(n)
    //TODO: Failing for negative numbers
    static class Minstack2 {
        Stack<Long> stack = new Stack<>();
        Long minValue;

        public Minstack2() {
            minValue = Long.MAX_VALUE;
        }

        public void push(int val) {
            Long value = (long) val;
            if (stack.isEmpty()) {
                minValue = value;
                stack.push(value);
            } else {
                if (value < minValue) {
                    minValue = value;
                    stack.push((2 * value) - minValue);
                } else {
                    stack.push(value);
                }
            }
        }

        public int pop() {
            if (stack.empty()) return -1;
            Long val = stack.pop();
            Long result = val;
            if (val <= minValue) {
                result = minValue;
                minValue = 2 * minValue - val;
            }
            return result.intValue();
        }

        public int top() {
            Long val = stack.peek();
            if (val < minValue) {
                return minValue.intValue();
            }
            return val.intValue();
        }

        public int getMin() {
            return minValue.intValue();
        }
    }

    public static void main(String[] args) {
//        MinStack1 stack = new MinStack1();
        Minstack2 stack = new Minstack2();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        System.out.println(stack.getMin());
        System.out.println(stack.pop());
        System.out.println(stack.top());
        System.out.println(stack.getMin());
//        System.out.println("The top element is " + stack.top());
//        System.out.println("Minimum element: " + stack.getMin());
    }
}
