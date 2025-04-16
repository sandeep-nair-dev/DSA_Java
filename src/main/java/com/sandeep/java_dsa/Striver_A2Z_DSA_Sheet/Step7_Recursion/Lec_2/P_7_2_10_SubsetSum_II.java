package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step7_Recursion.Lec_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class P_7_2_10_SubsetSum_II {

    public static void recursion(int index, int[] nums, List<Integer> subs, HashSet<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(subs));
            return;
        }
        subs.add(nums[index]);
        recursion(index + 1, nums, subs, result);
        subs.removeLast();
        recursion(index + 1, nums, subs, result);
    }


    public static void recursion(int index, int[] nums, List<Integer> subs, List<List<Integer>> result) {
        result.add(new ArrayList<>(subs));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) continue;
            subs.add(nums[i]);
            recursion(i + 1, nums, subs, result);
            subs.removeLast();
        }
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
//        HashSet<List<Integer>> result = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        recursion(0, nums, new ArrayList<>(), result);
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2};
        System.out.println(subsetsWithDup(arr));
    }
}