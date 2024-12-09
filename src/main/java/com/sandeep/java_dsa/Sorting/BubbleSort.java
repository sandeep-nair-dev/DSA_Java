package com.sandeep.java_dsa.Sorting;

import java.util.Arrays;

public class BubbleSort {

    public static void iterativeBubbleSort(int[] arr){
        int n = arr.length;
        for (int i = n - 1; i >= 1; i--) {
            boolean didSwap = false;
            for (int j = 0; j <= i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    didSwap =true;
                }
            }
            if(!didSwap) break;
//            System.out.println("Runs");
        }
    }


    public static void recursiveBubbleSort(int n, int[] arr){
        if(n<=1) return;
        System.out.println("FOR n:" + n);
        boolean didSwap = false;
        for(int i=0;i<=n-2;i++){
            if(arr[i]>arr[i+1]){
                int temp = arr[i];
                arr[i]=arr[i+1];
                arr[i+1]=temp;
                didSwap = true;
            }
        }
        if(!didSwap) return;
        recursiveBubbleSort(n-1, arr);
    }

    public static void main(String[] args) {
        System.out.println("-----BUBBLE SORT-----");
        int[] arr = new int[]{13, 46, 24, 52, 20, 9};
//        int[] arr = new int[]{5,4,3,2,1};
//        int[] arr = new int[]{1,2,3,4,5};
        int n = arr.length;

//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int[] arr = new int[n];
//        for(int i=0;i<n;i++){
//            arr[i]=scanner.nextInt();
//        }

//        iterativeBubbleSort(arr);
        recursiveBubbleSort(arr.length,arr);
        System.out.println(Arrays.toString(arr));
    }
}
