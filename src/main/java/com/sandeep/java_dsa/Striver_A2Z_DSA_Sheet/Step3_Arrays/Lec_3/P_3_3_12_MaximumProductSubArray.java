package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step3_Arrays.Lec_3;


import java.util.HashMap;
import java.util.Map;

/**
 * <h3><b>Problem Statement</b></h3>
 * <p>Given an integer array nums, find a subarray that has the largest product, and return the product.<br>
 * The test cases are generated so that the answer will fit in a 32-bit integer.<br><br>
 * Example 1:<br>
 * Input: nums = [2,3,-2,4]<br>
 * Output: 6<br>
 * Explanation: [2,3] has the largest product 6.</p>
 */
public class P_3_3_12_MaximumProductSubArray {

    private static int maximumSubArrayProductBrute(int[] arr){
        int maxProduct = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
            int currProduct = 1;
                for(int k=i;k<j;k++) {
                    currProduct *= arr[k];
                }
                maxProduct = Math.max(maxProduct, currProduct);
            }
        }
        return maxProduct;
    }

    private static int maximumSubArrayProductBetter(int[] arr){
        int maxProduct = 0;
        for (int i = 0; i < arr.length; i++) {
            int currProduct = arr[i];
            for (int j = i+1; j < arr.length; j++) {
                currProduct*=arr[j];
                maxProduct = Math.max(maxProduct, currProduct);
            }
        }
        return maxProduct;
    }

    private static int maximumSubArrayProductOptimal(int[] arr){
        int preProd = 1;
        int sufProd = 1;
        int maxProduct = 0;
        for(int i=0;i<arr.length;i++){
            if(preProd==0) preProd=1;
            if(sufProd==0) sufProd=1;
            preProd*=arr[i];
            sufProd*=arr[arr.length-i-1];
            maxProduct = Math.max(maxProduct, Math.max(preProd, sufProd));
        }

        return maxProduct;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-2,0,-1};
        System.out.println("Max Sub Array Product (Brute): " + maximumSubArrayProductBrute(arr));
        System.out.println("Max Sub Array Product (Better): " + maximumSubArrayProductBetter(arr));
        System.out.println("Max Sub Array Product (Optimal): " + maximumSubArrayProductOptimal(arr));
    }
}
