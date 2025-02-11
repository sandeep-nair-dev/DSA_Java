package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step3_Arrays.Lec_2;

import java.util.ArrayList;

public class P_3_2_9_LeadersInAnArrayProblem {
    static ArrayList<Integer> leaders(int arr[]) {
        // code here
        int maxi = Integer.MIN_VALUE;
        ArrayList<Integer> leaders = new ArrayList<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] >= maxi) {
                maxi = arr[i];
                leaders.add(0, arr[i]);
            }
        }
        return leaders;
    }
}
