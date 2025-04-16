package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step7_Recursion.Lec_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class P_7_2_8_CombinationSum_II {

    // But here T.C willbe 2^t * k * logn   -> logn for adding the element to the hashset

    public static void recursion(int index, int[] candidates, List<Integer> subseq, HashSet<List<Integer>> result, int target) {
        if (index == candidates.length) {
            if (target == 0) {
                result.add(new ArrayList<>(subseq));
            }
            return;
        }

        if (candidates[index] <= target) {
            subseq.add(candidates[index]);
            recursion(index + 1, candidates, subseq, result, target - candidates[index]);
            subseq.removeLast();
        }
        recursion(index + 1, candidates, subseq, result, target);
    }


    // T.C. -> (2^n) * k  --> k is avg length of subsequence

    public static void recursionOptimized(int index, int[] candidates, List<Integer> subseq, List<List<Integer>> result, int target) {
        if (target == 0) {
            result.add(new ArrayList<>(subseq));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) continue;
            if (candidates[i] > target) break;

            subseq.add(candidates[i]);
            recursionOptimized(i + 1, candidates, subseq, result, target - candidates[i]);
            subseq.removeLast();
        }
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        recursionOptimized(0, candidates, new ArrayList<>(), result, target);
        return result;
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        System.out.println(combinationSum2(candidates, 8));
    }
}