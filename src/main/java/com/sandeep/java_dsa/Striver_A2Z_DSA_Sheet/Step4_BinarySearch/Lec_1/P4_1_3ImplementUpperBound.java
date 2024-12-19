package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step4_BinarySearch.Lec_1;

public class P4_1_3ImplementUpperBound {
    public static void main(String[] args) {
        int[] arr = {3, 5, 8, 9, 15, 19};
        int n = 6, x = 9;
        int ind = upperBound(arr, x, n);
        System.out.println("The upper bound is the index: " + ind);
    }

    private static int upperBound(int[] arr, int x, int n) {
        int lo=0, hi=n-1, ans=-1;
        while(lo<=hi){
            int mid= (lo+hi)/2;
            if(arr[mid]>x){
                ans=mid;
                hi=mid-1;
            }else{
                lo=mid+1;
            }
        }
        return ans;
    }
}
