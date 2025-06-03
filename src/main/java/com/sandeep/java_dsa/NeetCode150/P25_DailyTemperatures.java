package com.sandeep.java_dsa.NeetCode150;

import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.Stack;

/**
 * <h5><b>Daily Temperatures</b></h5>
 * <p>
 * You are given an array of integers {@code temperatures} where {@code temperatures[i]} represents
 * the daily temperature on the {@code i}th day.
 * <p>
 * Return an array {@code result} where {@code result[i]} is the number of days after the {@code i}th day
 * before a warmer temperature appears on a future day.
 * If there is no day in the future where a warmer temperature will appear for the {@code i}th day,
 * set {@code result[i]} to {@code 0} instead.
 * <p>
 * <b>Example 1:</b><br>
 * Input: {@code temperatures = [30,38,30,36,35,40,28]}<br>
 * Output: {@code [1,4,1,2,1,0,0]}
 * <p>
 * <b>Example 2:</b><br>
 * Input: {@code temperatures = [22,21,20]}<br>
 * Output: {@code [0,0,0]}
 * <p>
 * <b>Constraints:</b><br>
 * {@code 1 <= temperatures.length <= 1000}<br>
 * {@code 1 <= temperatures[i] <= 100}
 */

public class P25_DailyTemperatures {

    public static int[] solutionBrute(int[] arr){
        int[] res  = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                if(j!=i && arr[j]>arr[i]){
                    res[i]=j-i;
                    break;
                }
            }
        }
        return res;
    }

    /**
     * Using stack (monotonic decreasing stack)
     * TC -> O(n)
     * SC -> O(n)
     */
    public static int[] solutionBetter(int[] arr){
        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        int[] res = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            while (!stack.isEmpty() && arr[i]>stack.peek().getLeft()){
                res[stack.peek().getRight()]=i-stack.peek().getRight();
                stack.pop();
            }
            stack.push(Pair.of(arr[i], i));
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{30,38,30,36,35,40,28};
        System.out.println("Result (Brute): " + Arrays.toString(solutionBrute(arr)));
        System.out.println("Result (Better): " + Arrays.toString(solutionBetter(arr)));
    }
}
