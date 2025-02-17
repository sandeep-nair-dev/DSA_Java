package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step3_Arrays.Lec_3;

import java.util.ArrayList;
import java.util.List;

public class P_3_3_2_MajorityElementsGreaterThanNBy3Times {
    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int ele1 = -1, ele2 = -1, count1 = 0, count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count1 == 0 && nums[i] != ele2) {
                ele1 = nums[i];
                count1++;
            } else if (count2 == 0 && nums[i] != ele1) {
                ele2 = nums[i];
                count2++;
            } else if (nums[i] == ele1) count1++;
            else if (nums[i] == ele2) count2++;
            else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == ele1) count1++;
            else if (nums[i] == ele2) count2++;
        }
        if (count1 > nums.length / 3) ans.add(ele1);
        if (count2 > nums.length / 3) ans.add(ele2);
        return ans;
    }

    public static void main(String args[]) {
        int[] arr = {11, 33, 33, 11, 33, 11};
        List<Integer> ans = majorityElement(arr);
        System.out.print("The majority elements are: ");
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }
}
