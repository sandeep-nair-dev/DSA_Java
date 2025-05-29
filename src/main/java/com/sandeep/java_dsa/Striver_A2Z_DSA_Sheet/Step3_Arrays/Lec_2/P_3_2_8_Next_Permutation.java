package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step3_Arrays.Lec_2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <b>Problem Statement</b>
 * <p>A permutation of an array of integers is an arrangement of its members into a sequence or linear order.<br>
 * For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].<br>
 * The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).<br>
 * For example, the next permutation of arr = [1,2,3] is [1,3,2].<br>
 * Similarly, the next permutation of arr = [2,3,1] is [3,1,2].<br>
 * While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.<br>
 * Given an array of integers nums, find the next permutation of nums.<br>
 * The replacement must be in place and use only constant extra memory.</p>
 */


/**
 * <h3><b>Optimal Solution</b></h3>
 * The steps are the following:<br>
 *<ul>
 * <li><b>Find the break-point, i</b>: Break-point means the first index i from the back of the given array where arr[i] becomes smaller than arr[i+1].
 * For example, if the given array is {2,1,5,4,3,0,0}, the break-point will be index 1(0-based indexing). Here from the back of the array, index 1 is the first index where arr[1] i.e. 1 is smaller than arr[i+1] i.e. 5.</li>
 * To find the break-point, using a loop we will traverse the array backward and store the index i where arr[i] is less than the value at index (i+1) i.e. arr[i+1].
 * <li><b>If such a break-point does not exist i.e. if the array is sorted in decreasing order</b>, the given permutation is the last one in the sorted order of all possible permutations. So, the next permutation must be the first i.e. the permutation in increasing order.
 * So, in this case, we will reverse the whole array and will return it as our answer.</li>
 * <li><b>If a break-point exists:</b>
 * <ul>
 * <li>Find the smallest number i.e. > arr[i] and in the right half of index i(i.e. from index i+1 to n-1) and swap it with arr[i].</li>
 * <li>Reverse the entire right half(i.e. from index i+1 to n-1) of index i. And finally, return the array.</li>
 * </ul>
 * </ul>
 */
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


    // Same as optimal solution, just that integer arrays is used here instead of list
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

    public static List<Integer> nextGreaterPermutation(List<Integer> A) {       //Official Solution from article
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
