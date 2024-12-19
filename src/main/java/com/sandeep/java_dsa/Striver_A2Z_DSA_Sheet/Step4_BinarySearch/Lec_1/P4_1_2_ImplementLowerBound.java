package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step4_BinarySearch.Lec_1;

public class P4_1_2_ImplementLowerBound {
    public static int lowerBound(int []arr, int n, int x) {
        int lo=0, hi=n-1;
        int ans=n;
        while(lo<=hi){
            int mid = (lo+hi)/2;
            if(arr[mid]>=x){
                ans=mid;
                hi=mid-1;
            }else{
                lo=mid+1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 8, 15, 19};
        int n = 5, x = 9;
        int ind = lowerBound(arr, n, x);
        System.out.println("The lower bound is the index: " + ind);
    }
}
