package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step9_StackAndQueues.Lec_3;

import java.util.Stack;

public class P9_3_8_SumOfSubarrayRanges {

    private static int bruteForce(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int largest = Integer.MIN_VALUE;
            int smallest = Integer.MAX_VALUE;
            for (int j = i; j < arr.length; j++) {
                largest = Math.max(largest, arr[j]);
                smallest = Math.min(smallest, arr[j]);
                sum += (largest - smallest);
            }
        }
        return sum;
    }

    private static long findMinSubarraySum(int[] arr){
        int[] prevSmallerIndex = new int[arr.length];
        int[] nextSmallerIndex = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<arr.length;i++){
            while (!stack.isEmpty() && arr[i]<=arr[stack.peek()]) {
                stack.pop();
            }
            prevSmallerIndex[i] = !stack.isEmpty()?stack.peek():-1;
            stack.add(i);
        }

        stack.clear();

        for(int i=arr.length-1;i>=0;i--){
            while (!stack.isEmpty() && arr[i]<arr[stack.peek()]) {
                stack.pop();
            }
            nextSmallerIndex[i] = !stack.isEmpty()?stack.peek():arr.length;
            stack.add(i);
        }

        long minSum=0;

        for(int i=0;i<arr.length;i++){
            int left = i-prevSmallerIndex[i];
            int right = nextSmallerIndex[i]-i;
            minSum=minSum+((long) left *right*arr[i]);
        }
        System.out.println("Min: " + minSum);
        return minSum;

    }

    private static long findMaxSubarraySum(int[] arr){
        int[] prevLargerElementIndex = new int[arr.length];
        int[] nextLargerElementIndex = new int[arr.length];
        Stack<Integer> stack  = new Stack<>();

        for(int i=0;i<arr.length;i++){
            while (!stack.isEmpty() && arr[i]>=arr[stack.peek()]){
                stack.pop();
            }

            prevLargerElementIndex[i]=stack.isEmpty()?-1:stack.peek();
            stack.add(i);
        }

        stack.clear();

        for(int i=arr.length-1;i>=0;i--){
            while (!stack.isEmpty() && arr[i]>arr[stack.peek()]){
                stack.pop();
            }
            nextLargerElementIndex[i] = !stack.isEmpty()?stack.peek():arr.length;
            stack.add(i);
        }

        long maxSum = 0;
        for(int i=0;i<arr.length;i++){
            int left = i-prevLargerElementIndex[i];
            int right = nextLargerElementIndex[i]-i;
            maxSum = maxSum+((long) left *right*arr[i]);
        }
        System.out.println("Max: " + maxSum);
        return maxSum;
    }

    private static long findSubArrayRangesSum(int[] arr){
        return findMaxSubarraySum(arr)-findMinSubarraySum(arr);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        System.out.println(bruteForce(arr));
        System.out.println(findSubArrayRangesSum(arr));
    }
}
