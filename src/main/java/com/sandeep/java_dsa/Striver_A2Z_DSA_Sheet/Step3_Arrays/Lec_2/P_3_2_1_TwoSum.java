package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step3_Arrays.Lec_2;

import java.util.Arrays;
import java.util.HashMap;

public class P_3_2_1_TwoSum {
    public static int[] findTwoSum(int[] nums, int target) {
        int[] temp = Arrays.copyOf(nums, nums.length);
        int[] res = new int[2];
        Arrays.sort(temp);
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int sum = temp[lo] + temp[hi];
            if (sum == target) {
                break;
            }
            if (sum < target) {
                lo++;
            } else {
                hi--;
            }
        }

        int p = 0;
        int k = 0;
        while (k < nums.length && p < 2) {
            if (nums[k] == temp[lo] || nums[k] == temp[hi]) {
                res[p] = k;
                p++;
            }
            k++;
        }
        return res;
    }

    public static int[] findTwoSum2(int[] nums, int target) {
        int n = nums.length;
        int[] ans = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int j = target - nums[i];
            if (map.containsKey(j)) {
                ans[0] = i;
                ans[1] = map.get(j);
                break;
            } else {
                map.put(nums[i], i);
            }
        }
        return ans;
    }

}
