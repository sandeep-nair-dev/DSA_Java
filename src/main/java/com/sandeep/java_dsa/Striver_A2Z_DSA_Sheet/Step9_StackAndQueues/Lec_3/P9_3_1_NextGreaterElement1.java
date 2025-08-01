package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step9_StackAndQueues.Lec_3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * <h5><b>496. Next Greater Element I</b></h5>
 * <p>
 * The next greater element of some element {@code x} in an array is the first greater element that is
 * to the right of {@code x} in the same array.
 * <p>
 * You are given two distinct 0-indexed integer arrays {@code nums1} and {@code nums2},
 * where {@code nums1} is a subset of {@code nums2}.
 * <br>
 * For each {@code 0 <= i < nums1.length}, find the index {@code j} such that {@code nums1[i] == nums2[j]}
 * and determine the next greater element of {@code nums2[j]} in {@code nums2}.
 * <br>
 * If there is no next greater element, then the answer for this query is {@code -1}.
 * <br>
 * Return an array {@code ans} of length {@code nums1.length} such that {@code ans[i]} is the next greater element
 * as described above.
 * <p>
 * <b>Example 1:</b><br>
 * Input: {@code nums1 = [4,1,2]}, {@code nums2 = [1,3,4,2]}<br>
 * Output: {@code [-1,3,-1]}<br>
 * Explanation:<br>
 * - 4 → no next greater element → -1<br>
 * - 1 → next greater is 3<br>
 * - 2 → no next greater element → -1
 * <p>
 * <b>Example 2:</b><br>
 * Input: {@code nums1 = [2,4]}, {@code nums2 = [1,2,3,4]}<br>
 * Output: {@code [3,-1]}<br>
 * Explanation:<br>
 * - 2 → next greater is 3<br>
 * - 4 → no next greater element → -1
 * <p>
 * <b>Constraints:</b><br>
 * {@code 1 <= nums1.length <= nums2.length <= 1000}<br>
 * {@code 0 <= nums1[i], nums2[i] <= 10^4}<br>
 * All elements in {@code nums1} and {@code nums2} are unique.<br>
 * All elements in {@code nums1} are also present in {@code nums2}.
 */

public class P9_3_1_NextGreaterElement1 {


    /**
     * Monotonic stack: We keep the elements in stack in a specific order. In this case it is in decreasing order.
     * For eg. TOP 3 5 7 9....this is a monotonic stack because from bottom to top, elements are stored in a decreasing order. So if now we get something greater like 8, to maintain the order
     * we will remove the elements that are smaller than 8 (i.e., 3,5,7) and then store 8.
     *
     * In this problem, lets say we have 3,5,7,9 in stack and now we get 8, so if at lower index we have 1, the next greater element is going to be 8, hence elements less than 8 dont have any significance
     * and hence we remove them from the stack
     *
     */

    /**
     * - Traverse right to left
     * - while stack is not empty and top of stack is <= current element ->> pop from stack
     * - if stack is not empty, the nge is the top of stack and if stack is empty, no nge hence -1
     *
     * TC-> O(N1 + N2)
     * SC-> O(N1 + N2)
     */
    private static int[] findNextGreaterElements(int[] nums1, int[] nums2){
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[nums1.length];
        for(int i=nums2.length-1;i>=0;i--){
            while (!stack.isEmpty() && stack.peek()<=nums2[i]){
                stack.pop();
            }
            if(!stack.isEmpty())map.put(nums2[i], stack.peek());
            else map.put(nums2[i], -1);

            stack.push(nums2[i]);
        }

        for(int i=0;i<nums1.length;i++){
            res[i]=map.get(nums1[i]);
        }
        return res;
    }

    /**
     *
     * - traverse from left to right
     * - store the top of stack is less than the current element, then the current element is the nge of the stack, do it while top of stack <current element
     * - put current element in stack so we get it's nge in future
     *
     * TC-> O(N1 + N2)
     * SC-> O(N1 + N2)
     */
    private static int[] findNextGreaterElements2(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums1.length;i++){
            map.put(nums1[i], -1);
        }
        int[] res = new int[nums1.length];

        for(int i=0;i<nums2.length;i++){
            while (!stack.isEmpty() && nums2[i]>stack.peek()){
                map.put(stack.peek(), nums2[i]);
                stack.pop();
            }
            if(map.containsKey(nums2[i])) stack.push(nums2[i]);
        }

        for(int i=0;i<nums1.length;i++){
            res[i]=map.get(nums1[i]);
        }
        return res;
    }

        public static void main(String[] args) {
        int[] nums1 = new int[]{4,1,2};
        int[] nums2 = new int[]{1,3,4,2};

        System.out.println(Arrays.toString(findNextGreaterElements2(nums1, nums2)));
    }
}
