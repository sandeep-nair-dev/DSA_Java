package com.sandeep.java_dsa.NeetCode150;

import java.util.ArrayList;
import java.util.List;

public class P68_Subsets {

    public static void findSubsets(int i, int[] nums, List<Integer> current, List<List<Integer>> result){
        if(i==nums.length){
            result.add(new ArrayList<>(current));
            return;
        }

        current.add(nums[i]);
        findSubsets(i+1, nums, current, result);
        current.remove(current.size()-1);
        findSubsets(i+1, nums, current, result);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        findSubsets(0, arr, current, result);
        System.out.println(result);
    }
}
