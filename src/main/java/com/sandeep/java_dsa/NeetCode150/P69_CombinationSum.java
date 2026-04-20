package com.sandeep.java_dsa.NeetCode150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P69_CombinationSum {

    private static void findCombinationSums(int i, int[] arr, List<Integer> current, List<List<Integer>> cSums, int target) {
        if (i == arr.length) {
            if (target == 0) cSums.add(new ArrayList<>(current));
            return;
        }
        if (target < 0) {
            return;
        }
        if (arr[i] <= target) {
            current.add(arr[i]);
            findCombinationSums(i, arr, current, cSums, target - arr[i]);
            current.remove(current.size() - 1);
        }
        findCombinationSums(i + 1, arr, current, cSums, target);
    }


    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 6, 7};
        int target = 7;
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        findCombinationSums(0, arr, current, result, target);
        System.out.println(result);
    }
}
