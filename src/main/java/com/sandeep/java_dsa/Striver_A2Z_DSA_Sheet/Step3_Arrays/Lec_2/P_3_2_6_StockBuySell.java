package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step3_Arrays.Lec_2;

public class P_3_2_6_StockBuySell {
    public int maxProfit(int[] prices) {
        int maxProfit = 0, buyPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < buyPrice) {
                buyPrice = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - buyPrice);
            }
        }
        return maxProfit;
    }
}
