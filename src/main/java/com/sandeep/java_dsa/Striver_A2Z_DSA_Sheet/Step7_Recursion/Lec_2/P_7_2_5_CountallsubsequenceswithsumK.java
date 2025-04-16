package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step7_Recursion.Lec_2;

import java.util.List;

public class P_7_2_5_CountallsubsequenceswithsumK {


    private static int recursion(int index, List<Integer> nums, int sum, int target) {
        if (sum > target) return 0;     //can be done only if array contains positives
        if (index == nums.size()) {
            return sum == target ? 1 : 0;
        }

        sum += nums.get(index);
        int left = recursion(index + 1, nums, sum, target);
        sum -= nums.get(index);
        int right = recursion(index + 1, nums, sum, target);
        return left + right;
    }

    private static int countSubsequencesWithSum(List<Integer> nums, int target) {
        return recursion(0, nums, 0, target);
    }

    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 1);
        int result = countSubsequencesWithSum(nums, 2);
        System.out.println(result);
    }
}