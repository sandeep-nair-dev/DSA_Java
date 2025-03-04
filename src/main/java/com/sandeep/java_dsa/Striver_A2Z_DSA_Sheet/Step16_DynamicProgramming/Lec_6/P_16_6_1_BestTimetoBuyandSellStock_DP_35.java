package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step16_DynamicProgramming.Lec_6;

public class P_16_6_1_BestTimetoBuyandSellStock_DP_35 {

    public static int func(int[] arr){
        int maxProfit = 0, minBuy = Integer.MAX_VALUE;
        for(int i:arr){
            if(i<minBuy) minBuy=i;
            else maxProfit = Math.max(maxProfit, i-minBuy);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{7,1,5,3,6,4};
        System.out.println(func(arr));
    }
}