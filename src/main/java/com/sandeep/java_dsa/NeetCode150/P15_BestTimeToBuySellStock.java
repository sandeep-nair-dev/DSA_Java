package com.sandeep.java_dsa.NeetCode150;

public class P15_BestTimeToBuySellStock {
    public static int maxProfit(int[] prices) {
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<buyPrice){
                buyPrice=prices[i];
            }else{
                maxProfit = Math.max(maxProfit, prices[i]-buyPrice);
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10,1,5,6,7,1};
        System.out.println("Max Profit: " + maxProfit(arr));
    }
}
