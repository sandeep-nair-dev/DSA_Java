package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step3_Arrays.Lec_2;

public class P_3_2_5_PrintSubarrayWithMaxSum {
    public static int maxSubArray(int[] nums) {
        int start = -1, sum = 0;
        int maxStart = -1, maxEnd = -1;
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (sum <= 0) {
                sum = 0;
                start = i;
            }

            sum += nums[i];

            if (sum > maxi) {
                maxi = sum;
                maxStart = start;
                maxEnd = i;
            }
        }

        System.out.println("Subarray with max sum is: ");
        for (int i = maxStart; i <= maxEnd; i++) {
            System.out.print(nums[i] + ",");
        }
        return maxi;
    }

    public static void main(String args[]) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int n = arr.length;
        long maxSum = maxSubArray(arr);
        System.out.println("The maximum subarray sum is: " + maxSum);

    }
}
