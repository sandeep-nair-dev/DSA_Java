package com.sandeep.java_dsa.Sorting;

import java.util.Arrays;

public class InsertionSort {

    public static void iterativeInsertionSort(int[] arr, int n){
        for(int i=0;i<=n-1;i++){
//            System.out.println("STEP: " + i);
            int j=i;
            while(j>0 && arr[j-1]>arr[j]){
//                System.out.println(j + "--->" + arr[j-1] + "---" + arr[j]);
                int temp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j]=temp;

                j--;
            }
//            System.out.println(Arrays.toString(arr));
        }
    }

    public static void recursiveInsertionSort(int[] arr, int n){
        if(n>=arr.length-1) return;
        int j=n+1;
        while(j>0 && arr[j]<arr[j-1]){
            int temp = arr[j];
            arr[j]=arr[j-1];
            arr[j-1]=temp;
            j--;
        }
        recursiveInsertionSort(arr, n+1);
    }
    public static void main(String[] args) {
        System.out.println("-----INSERTION SORT-----");
        int[] arr = new int[]{13, 46, 24, 52, 20, 9};
//        int[] arr = new int[]{5,4,3,2,1};
//        int[] arr = new int[]{1,2,3,4,5};
//
//        Scanner scanner = new Scanner(System.in);
//        int x = scanner.nextInt();
//        int[] arr = new int[x];
//        for(int i=0;i<n;i++){
//            arr[i]=scanner.nextInt();
//        }

        System.out.println(Arrays.toString(arr));
        System.out.println("After sorting:");
        int n = arr.length;
//        iterativeInsertionSort(arr, arr.length);
        recursiveInsertionSort(arr, 0);
        System.out.println(Arrays.toString(arr));
    }
}
