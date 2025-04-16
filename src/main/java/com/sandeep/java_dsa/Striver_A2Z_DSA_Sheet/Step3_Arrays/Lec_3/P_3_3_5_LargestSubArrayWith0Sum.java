package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step3_Arrays.Lec_3;

import java.util.HashMap;

public class P_3_3_5_LargestSubArrayWith0Sum {

    public static int optimalWay(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxlen = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == 0) maxlen = i+1;
            else {
                if (!map.containsKey(sum)) {
                    map.put(sum, i);
                } else {
                    maxlen = Math.max(maxlen, i-map.get(sum));
                }
            }
        }
        return maxlen;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-31, -48, -90, 54, 20, 95, 6, -86, 22};
        System.out.println("Length of largest subarray with sum 0: " + optimalWay(arr));
    }
}
