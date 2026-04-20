package com.sandeep.java_dsa.NeetCode150;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class P71_Permutations {

    private static void recursion(int index, int[] arr, List<Integer> current, HashSet<List<Integer>> result) {
        if (index >= arr.length * 2) {
            if (current.size() == arr.length) {
                HashSet<Integer> hash = new HashSet<>(current);
                if (hash.size() == arr.length)
                    result.add(new ArrayList<>(current));
            }
            return;
        }

        current.add(arr[index % arr.length]);
        recursion(index + 1, arr, current, result);
        current.removeLast();
        recursion(index + 1, arr, current, result);
    }

    private static List<List<Integer>> permute(int[] arr) {
        HashSet<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            List<Integer> current = new ArrayList<>();
            current.add(arr[i]);
            recursion(i, arr, current, result);
        }
        return result.stream().toList();
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
        System.out.println(permute(arr));
    }
}
