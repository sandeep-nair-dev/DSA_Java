package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step4_BinarySearch.Lec_2;

public class P4_2_5_FindSMallestDivisor {
    public static boolean checkThreshold(int[] nums, int threshold, int divisor) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += Math.ceil((double) nums[i] / (double) divisor);
            if (sum > threshold) return false;
        }
        if (sum <= threshold) return true;
        return false;
    }

    public static int smallestDivisor(int[] nums, int threshold) {
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            maxi = Math.max(maxi, nums[i]);
        }
        int lo = 1, hi = maxi;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (checkThreshold(nums, threshold, mid)) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int limit = 8;
        int ans = smallestDivisor(arr, limit);
        System.out.println("The minimum divisor is: " + ans);
    }
}
