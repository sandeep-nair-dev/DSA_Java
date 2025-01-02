package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step4_BinarySearch.Lec_3;

public class P4_3_1_FindRowWithMaximumnumberOf1s {
    int lowerBound(int[] arr, int m, int x){
        int index = -1;
        int lo=0, hi=m-1;
        while(lo<=hi){
            int mid = (lo+hi)/2;
            if(arr[mid]>=x){
                hi=mid-1;
            }else{
                lo=mid+1;
            }
        }
        return lo;
    }

    int rowWithMax1s(int[][] arr, int n, int m) {
        // code here
        int index=-1;
        int maxCount=0;
        for(int i=0;i<arr.length;i++){
            int currCount = m-lowerBound(arr[i], m, 1);
            if(currCount>maxCount){
                maxCount=currCount;
                index=i;
            }
        }
        return index;
    }

}
