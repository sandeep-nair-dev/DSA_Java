package com.sandeep.java_dsa.NeetCode150;

import java.util.Stack;

public class P27_LargestRectangleInHistogram {
    public static int largestRectangleArea_brute1(int[] heights) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            int currMin = Integer.MAX_VALUE;
            for (int j = i; j < heights.length; j++) {
                currMin = Math.min(currMin, heights[j]);
                max = Math.max(max, currMin * (j - i + 1));
            }
        }
        return max;
    }

    public static int largestRectangleArea_brute2(int[] heights) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            int l = i, r = i;
            while (l > 0 && heights[l - 1] >= heights[i]) {
                l--;
            }
            while (r > 0 && r < heights.length - 1 && heights[r + 1] >= heights[i]) {
                r++;
            }
            max = Math.max(max, heights[i] * (r - l + 1));

        }
        return max;
    }

    /*
    TC-> O(n)
    SC -> O(n)
     */
    public static int largestRectangleArea_stackOnePass(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            int prevIndex = i;
            while (!stack.isEmpty() && heights[i] < stack.peek()[0]) {
                int[] top = stack.pop();
                max = Math.max(max, (i - top[1]) * top[0]);
                prevIndex = top[1];
            }
            stack.push(new int[]{heights[i], prevIndex});
        }
        while (!stack.isEmpty()) {
            int[] top = stack.pop();
            max = Math.max(max, (heights.length - top[1]) * top[0]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] heights = new int[]{2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea_brute1(heights));
        System.out.println(largestRectangleArea_brute2(heights));
        System.out.println(largestRectangleArea_stackOnePass(heights));
    }
}
