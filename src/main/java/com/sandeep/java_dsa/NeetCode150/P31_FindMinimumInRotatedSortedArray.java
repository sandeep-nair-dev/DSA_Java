package com.sandeep.java_dsa.NeetCode150;

public class P31_FindMinimumInRotatedSortedArray {

    private static int findMinimum(int[] arr){
        int lo=0;
        int hi=arr.length-1;
        int min = Integer.MAX_VALUE;
        while (lo<=hi){
            int mid = (lo+hi)/2;
            min = Math.min(min, arr[mid]);
            if(arr[mid]>arr[hi]){
                lo=mid+1;
            }else{
                hi=mid-1;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,4,5,6,1,2};
//        int[] nums = new int[]{1,2,3,4,5,6};
//        int[] nums = new int[]{6,5,4,3,2,1};
        System.out.println("Minimum value in rotated sorted array: " + findMinimum(nums));
    }
}
