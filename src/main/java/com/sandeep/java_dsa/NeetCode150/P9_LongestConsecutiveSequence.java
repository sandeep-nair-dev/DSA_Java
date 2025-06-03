package com.sandeep.java_dsa.NeetCode150;

import java.util.Arrays;
import java.util.HashSet;

public class P9_LongestConsecutiveSequence {

    public static int optimalSolution(int[] arr){
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i : arr) {
            hashSet.add(i);
        }

        int longestLength=0;
        for(Integer i:hashSet){
            if(!hashSet.contains(i-1)){
                int len=1;
                int x=i;
                while (hashSet.contains(x+1)){
                    len++;
                    x++;
                }
                longestLength=Math.max(longestLength, len);
            }
        }
        return longestLength;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,20,4,10,3,4,5};
        System.out.println("Longest consecutive sequence: " + optimalSolution(arr));
    }
}
