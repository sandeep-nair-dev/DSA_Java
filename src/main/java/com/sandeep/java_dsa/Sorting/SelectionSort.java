package com.sandeep.java_dsa.Sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        System.out.println("-----SELECTION SORT-----");
        int[] arr = new int[]{13, 46, 24, 52, 20, 9};
        int n = arr.length;
        for (int i = 0; i <= n - 2; i++) {
            int mini = i;
            for (int j = i; j <= n-1; j++) {
                if (arr[j] < arr[mini]) {
                    mini = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[mini];
            arr[mini] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
