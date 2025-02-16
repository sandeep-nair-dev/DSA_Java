package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step3_Arrays.Lec_2;

import java.util.HashMap;
import java.util.Map;

public class P_3_2_14_CountSubarraysWithGivenSum {
    public static int findAllSubarraysWithGivenSumOptimal(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            count += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};
        int k = 6;
        int cnt = findAllSubarraysWithGivenSumOptimal(arr, k);
        System.out.println("The number of subarrays is: " + cnt);
    }
}
