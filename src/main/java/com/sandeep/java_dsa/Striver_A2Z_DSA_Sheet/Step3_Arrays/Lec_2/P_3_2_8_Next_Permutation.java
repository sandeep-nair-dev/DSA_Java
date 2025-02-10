package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step3_Arrays.Lec_2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P_3_2_8_Next_Permutation {
    public static void nextPermutation2(List<Integer> nums) {
        int n = nums.size();
        int index = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums.get(i) < nums.get(i + 1)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            Collections.reverse(nums);
        } else {
            for (int i = n - 1; i > index; i--) {
                if (nums.get(i) > nums.get(index)) {
                    int temp = nums.get(i);
                    nums.set(i, nums.get(index));
                    nums.set(index, temp);
                    break;
                }
            }
            List<Integer> sublist = nums.subList(index + 1, n);
            Collections.reverse(sublist);
        }
    }

    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        int index = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            for (int i = 0; i < nums.length / 2; i++) {
                int temp = nums[i];
                nums[i] = nums[nums.length - 1 - i];
                nums[nums.length - 1 - i] = temp;
            }
        } else {
            for (int i = n - 1; i > index; i--) {
                if (nums[i] > nums[index]) {
                    int temp = nums[i];
                    nums[i] = nums[index];
                    nums[index] = temp;
                    break;
                }
            }
            int l = index + 1, k = n - 1;
            while (l < k) {
                int temp = nums[l];
                nums[l] = nums[k];
                nums[k] = temp;
                l++;
                k--;
            }
        }
    }

    public static List<Integer> nextGreaterPermutation(List<Integer> A) {       //Official com.sandeep.java_dsa.Solution from article
        int n = A.size(); // size of the array.

        // Step 1: Find the break point:
        int ind = -1; // break point
        for (int i = n - 2; i >= 0; i--) {
            if (A.get(i) < A.get(i + 1)) {
                // index i is the break point
                ind = i;
                break;
            }
        }

        // If break point does not exist:
        if (ind == -1) {
            // reverse the whole array:
            Collections.reverse(A);
            return A;
        }

        // Step 2: Find the next greater element
        //         and swap it with arr[ind]:

        for (int i = n - 1; i > ind; i--) {
            if (A.get(i) > A.get(ind)) {
                int tmp = A.get(i);
                A.set(i, A.get(ind));
                A.set(ind, tmp);
                break;
            }
        }

        // Step 3: reverse the right half:
        List<Integer> sublist = A.subList(ind + 1, n);
        Collections.reverse(sublist);

        return A;
    }

    public static void main(String args[]) {
        List<Integer> A = Arrays.asList(new Integer[]{2, 1, 5, 4, 3, 0, 0});
//       List<Integer> ans = nextGreaterPermutation(A);
        nextPermutation2(A);

        System.out.print("The next permutation is: [");
        for (Integer an : A) {
            System.out.print(an + " ");
        }
        System.out.println("]");

    }
}
