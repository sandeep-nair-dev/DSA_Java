package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step3_Arrays.Lec_1;

import java.util.ArrayList;

public class P_3_1_9_FindUnion {
    public static ArrayList<Integer> findUnion(int[] a, int[] b) {
        // add your code here
        ArrayList<Integer> union = new ArrayList<>();
        int i = 0, j = 0;
        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                if (union.isEmpty() || union.get(union.size() - 1) != a[i]) {
                    union.add(a[i]);
                }
                i++;
                j++;
            } else if (a[i] < b[j]) {
                if (union.isEmpty() || union.get(union.size() - 1) != a[i]) {
                    union.add(a[i]);
                }
                i++;
            } else {
                if (union.isEmpty() || union.get(union.size() - 1) != b[j]) {
                    union.add(b[j]);
                }
                j++;
            }
        }
        while (i < a.length) {
            if (union.isEmpty() || union.get(union.size() - 1) != a[i]) {
                union.add(a[i]);
            }
            i++;
        }
        while (j < b.length) {
            if (union.isEmpty() || union.get(union.size() - 1) != b[j]) {
                union.add(b[j]);
            }
            j++;
        }
        return union;
    }

    public static void main(String args[]) {
        int n = 10, m = 7;
        int[] arr1 = {-6, -4, -2, 3, 8};
        int[] arr2 = {-9, -8, -7, -5, -2, 1, 2, 2, 6, 9};
        ArrayList<Integer> Union = findUnion(arr1, arr2);
        System.out.println("Union of arr1 and arr2 is ");
        for (int val : Union)
            System.out.print(val + " ");
    }
}
