package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step3_Arrays.Lec_2;

public class P_3_2_3_MajorityElement {
    public int majorityElement(int[] nums) {
        int freq = 1;
        int curr = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == curr) {
                freq++;
            } else {
                freq--;
            }

            if (freq == 0) {
                curr = nums[i];
                freq = 1;
            }
        }
        return curr;
    }
}
