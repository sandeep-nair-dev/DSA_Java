package com.sandeep.java_dsa.NeetCode150;

import java.util.*;

public class P70_CombinationSum2 {

    private static void recursion(int index, int[] arr, List<Integer> current, HashSet<List<Integer>> result, int target) {
        if (index >= arr.length) {
            if (target == 0) {
                result.add(new ArrayList<>(current));
            }
            return;
        }

        if (arr[index] <= target) {
            current.add(arr[index]);
            recursion(index + 1, arr, current, result, target - arr[index]);
            current.removeLast();
        }
        recursion(index + 1, arr, current, result, target);
    }

    //TODO: Understand how it is working and how is it time efficient
    private static void recursionOptimized(int index, int[] arr, List<Integer> current, List<List<Integer>> result, int target){
        if(target==0){
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i=index;i<arr.length;i++){
            if(i>index && arr[i]==arr[i-1]) continue;
            if(arr[i]>target) break;

            current.add(arr[i]);
            recursionOptimized(i + 1, arr, current, result, target - arr[i]);
            current.removeLast();
        }
    }

    private static List<List<Integer>> findCombinationSumWithoutRepeating(int[] arr, int target) {
        HashSet<List<Integer>> result = new HashSet<>();
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(arr);
//        recursion(0, arr, new ArrayList<>(), result, target);
        recursionOptimized(0, arr, new ArrayList<>(), resultList, target);
//        return result.stream().toList();
        return resultList;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(findCombinationSumWithoutRepeating(arr, target));

    }
}
