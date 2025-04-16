package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step7_Recursion.Lec_2;

import java.util.ArrayList;
import java.util.Comparator;

public class P_7_2_9_SubsetSum_I {

    // T.C -> (2^n) + (2^n)log(2^n)            --- 2^n for recursion, each element can be picked/not picked so 2 choices for n elements -> 2^n
    //                                             (2^n)log(2^n) for sorting the resultant (2^n) elements

    public static void recursion(int index, int[] arr, int sum, ArrayList<Integer> result) {
        if (index == arr.length) {
            result.add(sum);
            return;
        }

        recursion(index + 1, arr, sum + arr[index], result);
        recursion(index + 1, arr, sum, result);
    }

    public static ArrayList<Integer> subsetSums(int[] arr) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        recursion(0, arr, 0, result);
        result.sort(Comparator.naturalOrder());
        return result;
    }

    public static void main(String[] args) {

        int[] arr = new int[]{5, 6, 7};
        ArrayList<Integer> x = subsetSums(arr);
        System.out.println(x);

    }
}