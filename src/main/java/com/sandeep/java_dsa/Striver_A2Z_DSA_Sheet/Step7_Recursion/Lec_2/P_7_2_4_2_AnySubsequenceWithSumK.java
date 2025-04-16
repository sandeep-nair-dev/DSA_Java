package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step7_Recursion.Lec_2;

import java.util.ArrayList;
import java.util.List;

public class P_7_2_4_2_AnySubsequenceWithSumK {

    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 1, 6, 3, 4, 1, 2, 5, 2, 8);
        List<Integer> lists = anySubsequencesWithSum(nums, 4);
        System.out.println(lists);
    }

    private static List<Integer> anySubsequencesWithSum(List<Integer> nums, int i) {
        ArrayList<Integer> result = new ArrayList<>();
        List<Integer> subsequence = new ArrayList<>();
        recusion(0, nums, subsequence, 0, i, result);
        return result;
    }

    private static boolean recusion(int index, List<Integer> nums, List<Integer> subsequence, int sum, int target, List<Integer> result) {
        if (sum > target) return false;        //can be done only if array contains positives

        if (index == nums.size()) {
            if (sum == target) {
                result.addAll(new ArrayList<>(subsequence));
                return true;
            }
            return false;
        }

        subsequence.add(nums.get(index));
        sum += nums.get(index);
        if (recusion(index + 1, nums, subsequence, sum, target, result)) {
            return true;
        }
        sum -= nums.get(index);
        subsequence.removeLast();
        if (recusion(index + 1, nums, subsequence, sum, target, result)) {
            return true;
        }
        return false;
    }
}
