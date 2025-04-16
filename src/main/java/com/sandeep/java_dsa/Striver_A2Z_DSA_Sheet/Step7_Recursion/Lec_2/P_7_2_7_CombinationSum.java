package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step7_Recursion.Lec_2;

import java.util.ArrayList;
import java.util.List;

public class P_7_2_7_CombinationSum {

    // T.C. -> (2^t) * k        k is the time to put elements into result ds, 2^t is the time taken for recursion...it cant be 2^n bec each element can be picked unlimited no of times
    // S.C. -> K * x  k is length of string and x is no. of combinations (we ignored the auxiliary space it would take)

    public static void recursion(int index, int[] nums, List<Integer> subseq, int target, List<List<Integer>> result) {
        if (index == nums.length) {
            if (target == 0) {
                result.add(new ArrayList<>(subseq));        // dont assume as constant operation, takes linear time
            }
            return;
        }

        //picking the element
        if (nums[index] <= target) {
            subseq.add(nums[index]);
            recursion(index, nums, subseq, target - nums[index], result);  // index bec we can pick the element again, if it couldnt be picked again we would have used index+1
            subseq.removeLast();
        }

        //not picking the element
        recursion(index + 1, nums, subseq, target, result);     //not picking the element hence moving to next element (index+1)
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        recursion(0, candidates, new ArrayList<Integer>(), target, result);
        return result;
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{2, 3, 6, 7};
        System.out.println(combinationSum(candidates, 7));
    }
}