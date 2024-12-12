package com.sandeep.java_dsa.Sorting;

import java.util.Arrays;

public class QuickSort {

    public static void quicksort(int[] arr, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high);
            quicksort(arr, low, partitionIndex - 1);
            quicksort(arr, partitionIndex + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = low;
        int i = low;
        int j = high;
        while (i < j) {
            while (i <= high && arr[i] <= arr[pivot]) {             // arr[i] >= arr[pivot] for descending order
                i++;
            }
            while (j >= low + 1 && arr[j] > arr[pivot]) {           // arr[j] > arr[pivot] for descending order
                j--;
            }
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[pivot];
        arr[pivot] = arr[j];
        arr[j] = temp;

        return j;
    }

    public static void main(String[] args) {
        System.out.println("-----QUICK SORT-----");
        int[] arr = new int[]{3, 1, 2, 4, 1, 5, 2, 6, 4};
//
//        Scanner scanner = new Scanner(System.in);
//        int x = scanner.nextInt();
//        int[] arr = new int[x];
//        for(int i=0;i<n;i++){
//            arr[i]=scanner.nextInt();
//        }
        System.out.println(Arrays.toString(arr));
        quicksort(arr, 0, arr.length - 1);
        System.out.println("After com.sandeep.java_dsa.Sorting: ");
        System.out.print(Arrays.toString(arr));
    }
}
