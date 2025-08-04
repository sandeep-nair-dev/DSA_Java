package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step9_StackAndQueues.Lec_3;

import java.util.Arrays;
import java.util.Stack;

public class P9_3_2_NextGreaterElement2 {


    /**
     * <p>
     * This is case of circular array. So we create a hypothetical circular array by appending the same array in front line.<p>
     * 1 2 3 4 3 1 2 3 4 3  <p>
     * We dont create new array, we just start from (2*n)-1 and for getting that index element we do index%n.
     *<p>
     *     For bruteforce, we go to every element and from the element check next greater element till i+n-1;
     *     For optimized, we use monotonic stack.
     * And in monotonic stack, procedure is same as next greater element just that we only take ans store the values in result of indexes who are less than n, for we only need that elements next greater element.(i < n)
     */

    private static int[] findNextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int[] res = new int[nums.length];
        for (int i = (2 * n) - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i % n] >= stack.peek()) {
                stack.pop();
            }
            if (i < nums.length) {
                res[i] = stack.isEmpty() ? -1 : stack.peek();
            }
            stack.push(nums[i % n]);
        }
        while (!stack.isEmpty() && nums[nums.length - 1] >= stack.peek()) stack.pop();
        res[nums.length - 1] = stack.isEmpty() ? -1 : stack.peek();
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 3};
        System.out.println(Arrays.toString(findNextGreaterElements(nums)));
    }
}
