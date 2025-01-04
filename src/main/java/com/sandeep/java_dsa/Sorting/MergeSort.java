package com.sandeep.java_dsa.Sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {


    public static void merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low, right = mid + 1;
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }

    public static void mergeSort(int[] arr, int low, int high) {
        if (low >= high) return;
        int mid = (low + high) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    public static void main(String[] args) {
        System.out.println("-----MERGE SORT-----");
        int[] arr = new int[]{3, 1, 2, 4, 1, 5, 2, 6, 4};
//
//        Scanner scanner = new Scanner(System.in);
//        int x = scanner.nextInt();
//        int[] arr = new int[x];
//        for(int i=0;i<n;i++){
//            arr[i]=scanner.nextInt();
//        }
        System.out.println(Arrays.toString(arr));
        mergeSort(arr, 0, arr.length - 1);
        System.out.println("After com.sandeep.java_dsa.Sorting: ");
        System.out.print(Arrays.toString(arr));
    }
}
