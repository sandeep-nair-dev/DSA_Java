package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step3_Arrays.Lec_3;

import java.util.HashMap;

public class P_3_3_6_CountOfSubArraysWithXORk {
    /*
        Brute Force method: Using 3 loops, i and j denote beginning and end of subarray and k to traverse from i to j and calculate xor of the subarray
        Better Method: Use 2 loops, dont use k, instead keep track of xor and find xor of elements everytime j increases
     */

    /*
        Optimal method -> x = totalXor ^ k  (totalXor is the xor of all elements in the sub array
     */
    private static int optimalWay(int[] arr, int k){
        HashMap<Integer, Integer> frontXorElementAndCountMap = new HashMap<>();
        frontXorElementAndCountMap.put(0,1);
        int xor=0, count=0;
        for(int i=0;i<arr.length;i++){
            xor=xor^arr[i];

            int x = xor^k;
            if(frontXorElementAndCountMap.containsKey(x)){
                count+=frontXorElementAndCountMap.get(x);
            }
            if(frontXorElementAndCountMap.containsKey(xor)){
                frontXorElementAndCountMap.put(xor, frontXorElementAndCountMap.get(xor)+1);
            }else{
                frontXorElementAndCountMap.put(xor,1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 2, 2, 6, 4};
        int k=6;
        System.out.println("Result: " + optimalWay(arr, k));
    }
}
