package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step9_StackAndQueues.Lec_3;

public class P9_3_5_TrappingRainwater {

    private static int findTrappingRainwater1(int[] arr) {
        int[] prefixMax_lmax = new int[arr.length];
        int[] suffixMax_rmax = new int[arr.length];
        prefixMax_lmax[0] = 0;
        for (int i = 1; i < arr.length; i++) {
            prefixMax_lmax[i] = Math.max(prefixMax_lmax[i - 1], arr[i - 1]);
        }

        suffixMax_rmax[arr.length - 1] = 0;
        for (int i = arr.length - 2; i >= 0; i--) {
            suffixMax_rmax[i] = Math.max(suffixMax_rmax[i + 1], arr[i + 1]);
        }

        int maxVol = 0;
        for (int i = 0; i < arr.length; i++) {
            int current = Math.min(prefixMax_lmax[i], suffixMax_rmax[i]) - arr[i];
            if (current > 0) maxVol += current;
        }
        return maxVol;
    }

    private static int findTrappingRainwater2(int[] arr) {
        int[] suffixMax_rmax = new int[arr.length];

        suffixMax_rmax[arr.length - 1] = 0;
        for (int i = arr.length - 2; i >= 0; i--) {
            suffixMax_rmax[i] = Math.max(suffixMax_rmax[i + 1], arr[i + 1]);
        }

        int prefixMax_lmax=0;

        int maxVol = 0;
        for (int i = 0; i < arr.length; i++) {
            int current = Math.min(prefixMax_lmax, suffixMax_rmax[i]) - arr[i];
            if (current > 0) maxVol += current;
            prefixMax_lmax = Math.max(prefixMax_lmax, arr[i]);
        }
        return maxVol;
    }

    private static int findTrappingRainwaterOptimal(int[] arr){
        int l=0,r=arr.length-1;
        int lmax=arr[l], rmax=arr[r];
        int maxVol=0;

        while (l<r){
            if(lmax<rmax){
                l++;
                lmax = Math.max(lmax, arr[l]);
                maxVol += lmax-arr[l];
            }else{
                r--;
                rmax = Math.max(rmax, arr[r]);
                maxVol += rmax-arr[r];
            }
        }
        return maxVol;
    }


    public static void main(String[] args) {
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(findTrappingRainwater1(height));
        System.out.println(findTrappingRainwater2(height));
        System.out.println(findTrappingRainwaterOptimal(height));
    }
}
