package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step3_Arrays.Lec_2;

public class P_3_2_4_MaximumSubarraySum {
    public int maxSubArray(int[] nums) {
        int start = -1, sum = 0;
//        int maxStart=-1, maxEnd=-1;               Required if we want to print the subarray
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > maxi) {
                maxi = sum;
//                maxStart=start;
//                maxEnd=i;
            }
            if (sum <= 0) {
                sum = 0;
//                start=i;
            }
        }
        return maxi;
    }
}
