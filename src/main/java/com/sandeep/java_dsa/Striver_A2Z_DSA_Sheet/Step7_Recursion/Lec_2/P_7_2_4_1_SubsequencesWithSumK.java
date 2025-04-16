package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step7_Recursion.Lec_2;

import java.util.ArrayList;
import java.util.List;

public class P_7_2_4_1_SubsequencesWithSumK {

    public static void recursion(int index, List<Integer> nums, ArrayList<Integer> subseq, ArrayList<ArrayList<Integer>> result, int sum, int target) {
        if (sum > target) return;    //can be done only if array contains positives

        if (index == nums.size()) {
            if (sum == target) {
                result.add(new ArrayList<>(subseq));
            }
            return;
        }

        subseq.add(nums.get(index));
        sum += nums.get(index);
        recursion(index + 1, nums, subseq, result, sum, target);
        sum -= nums.get(index);
        Integer i = subseq.removeLast();
        recursion(index + 1, nums, subseq, result, sum, target);
    }

    public static ArrayList<ArrayList<Integer>> allSubsequencesWithSum(List<Integer> nums, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> subseq = new ArrayList<>();
        recursion(0, nums, subseq, result, 0, target);
        return result;
    }

    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 1);
        ArrayList<ArrayList<Integer>> lists = allSubsequencesWithSum(nums, 2);
        System.out.println(lists);
    }
}