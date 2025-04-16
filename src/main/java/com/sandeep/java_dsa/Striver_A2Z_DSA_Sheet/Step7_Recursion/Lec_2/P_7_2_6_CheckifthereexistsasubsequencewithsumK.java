package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step7_Recursion.Lec_2;

import java.util.List;

public class P_7_2_6_CheckifthereexistsasubsequencewithsumK {

    public static boolean recursion(int index, List<Integer> nums, int sum, int target) {
        if (index == nums.size()) {
            if (sum == target) return true;
            return false;
        }

        sum += nums.get(index);
        if (recursion(index + 1, nums, sum, target)) return true;
        sum -= nums.get(index);
        if (recursion(index + 1, nums, sum, target)) return true;

        return false;
    }

    private static boolean checkSubsequenceExistsWithSumK(List<Integer> nums, int target) {
        return recursion(0, nums, 0, target);
    }

    public static void main(String[] args) {
        List<Integer> nums = List.of(9, 8, 7);
        boolean exists = checkSubsequenceExistsWithSumK(nums, 12);
        System.out.println(exists);
    }
}