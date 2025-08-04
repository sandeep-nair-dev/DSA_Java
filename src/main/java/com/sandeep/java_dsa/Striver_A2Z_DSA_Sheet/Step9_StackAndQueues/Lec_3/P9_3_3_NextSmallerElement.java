package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step9_StackAndQueues.Lec_3;

import java.util.Arrays;
import java.util.Stack;

/**
 * <h5><b>Next Smaller Element</b></h5>
 * <p>
 * Given an array of integers {@code arr}, your task is to find the Next Smaller Element (NSE) for every element in the array.
 * <p>
 * The Next Smaller Element for an element {@code x} is defined as the first element to the right of {@code x} that is smaller than {@code x}.
 * <br>
 * If there is no smaller element to the right, then the NSE is {@code -1}.
 * <p>
 * <b>Example 1:</b><br>
 * Input: {@code arr = [4, 8, 5, 2, 25]}<br>
 * Output: {@code [2, 5, 2, -1, -1]}<br>
 * Explanation:<br>
 * - 4 → 2<br>
 * - 8 → 5<br>
 * - 5 → 2<br>
 * - 2 → no smaller element → -1<br>
 * - 25 → no smaller element → -1
 * <p>
 * <b>Example 2:</b><br>
 * Input: {@code arr = [10, 9, 8, 7]}<br>
 * Output: {@code [9, 8, 7, -1]}<br>
 * Explanation:<br>
 * Each element’s next right neighbor is smaller.
 */

public class P9_3_3_NextSmallerElement {

    /**
     * - Traverse right to left
     * - while stack is not empty and top of stack is >= current element ->> pop from stack
     * - if stack is not empty, the nse is the top of stack and if stack is empty, no nge hence -1
     *
     * TC-> O(2N)   2N because N for traversing the array and at most N for removing elements in the stack
     * SC-> O(N)
     */
    private static int[] findNextSmaller(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }

            result[i] = !stack.isEmpty() ? stack.peek() : -1;
            stack.push(arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 8, 5, 2, 25};
        System.out.println(Arrays.toString(findNextSmaller(arr)));
    }
}
