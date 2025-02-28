package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step3_Arrays.Lec_2;

import java.lang.reflect.Array;
import java.util.Arrays;

public class P_3_2_2_SortColors {
    public static void swap(int i, int j, int[] arr){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static void main(String[] args) {
        int nums[] = new int[]{2,0,2,1,1,0};
        int left=0, curr=0, right = nums.length-1;
        while (curr<=right){
            if(nums[curr]==0) {
                swap(curr, left, nums);
                left++;
                curr++;
            } else if (nums[curr]==2) {
                swap(curr, right, nums);
                right--;
            }else curr++;
        }

        for(int i:nums){
            System.out.print(i+", ");
        }
    }
}
