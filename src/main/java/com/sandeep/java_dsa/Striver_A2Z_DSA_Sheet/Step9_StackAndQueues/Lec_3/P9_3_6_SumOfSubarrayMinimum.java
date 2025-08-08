package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step9_StackAndQueues.Lec_3;

import java.util.Stack;

public class P9_3_6_SumOfSubarrayMinimum {
    static int mod = (int) (1e9 + 7);

    private static int sumOfSubarrayMinimum_Bruteforce(int[] arr) {
        int sum = 0;
        int mod = 1000000007;
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            for (int j = i; j < arr.length; j++) {
                min = Math.min(min, arr[j]);
                sum = (sum + min) % mod;
            }
        }
        return sum;
    }

    /**
     * In this approach instead of calculating minimum for every sub array, we calculate each elements contribution as minimum.
     * So contribution = no. of arrays in which the element is minimum * element  (If element 2 is minimum in 5 sub arrays then contribution=5*2=10)
     * Where no. of arrays in which the element is minimum = (No. of elements between the element and previous smaller element) * (No. of elements between the element and next smaller element)
     * if no pse, we set -1 and if no nse we set arr.length
     * so we calculate pse and nse, and use it
     * <p>
     * Edge case: [1,1]...in this if we use the formula we get wrong answer because [1,1] is considered as sub arrays of both 1's. So to avoid this, we only use one of the following:
     * Either if no nse then set as n or if no pse then set as -1
     *
     *
     * TC-> O(5N)
     * SC-> O(5N)
     */

    private static int[] findNextSmallerElementIndexes(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] nextSmallerElementIndex = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                stack.pop();
            }
            nextSmallerElementIndex[i] = !stack.isEmpty() ? stack.peek() : arr.length;
            stack.push(i);
        }
        return nextSmallerElementIndex;
    }

    private static int[] findPrevSmallerElementIndexes(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] prevSmallerElementIndex = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {                    // if no nse we take n hence in pse we dont take -1, we take the index of prev smaller or equal element, and that is why arr[i]<arr[stack.peek()]
                stack.pop();
            }
            prevSmallerElementIndex[i] = !stack.isEmpty() ? stack.peek() : -1;
            stack.push(i);
        }
        return prevSmallerElementIndex;
    }

    private static int sumOfSubArrayMinimum_Optimal(int[] arr) {

        int[] prevSmallerElementIndex = findPrevSmallerElementIndexes(arr);
        int[] nextSmallerElementIndex = findNextSmallerElementIndexes(arr);
        int minSum = 0;

        for (int i = 0; i < arr.length; i++) {
            int left = i - prevSmallerElementIndex[i];
            int right = nextSmallerElementIndex[i] - i;
            minSum = (int) (minSum + ((long) left * right * arr[i]) % mod) % mod;
        }
        return minSum;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        System.out.println(sumOfSubarrayMinimum_Bruteforce(arr));
        System.out.println(sumOfSubArrayMinimum_Optimal(arr));
    }
}
