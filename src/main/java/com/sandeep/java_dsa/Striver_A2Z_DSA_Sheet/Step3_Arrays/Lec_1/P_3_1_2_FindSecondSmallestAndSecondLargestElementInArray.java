package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step3_Arrays.Lec_1;

import org.apache.commons.lang3.tuple.Pair;

public class P_3_1_2_FindSecondSmallestAndSecondLargestElementInArray {

    //brute force: sort the array and take the arr[1] and arr[arr.length-2] element as second smallest and second largest
    //better approach: 2 traversal, 1st traversal find the largest and smallest element...in 2nd traversal find the element just smaller than the largest and just larger than the smallest
    //optimal approach: we take both smallest and second smallest as well as larget and second largest in single traversal
    private static Pair<Integer, Integer> secondSmallestandSecondLargest(int[] arr) {
        if (arr.length < 2) return Pair.of(-1, -1);
        int largest = Integer.MIN_VALUE, secondLargest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE, secondSmallest = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i] > secondLargest && arr[i] != largest) {
                secondLargest = arr[i];
            }
            if (arr[i] < smallest) {
                secondSmallest = smallest;
                smallest = arr[i];
            } else if (arr[i] < secondSmallest && arr[i] != smallest) {
                secondSmallest = arr[i];
            }
        }
        return Pair.of(secondSmallest, secondLargest);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 7, 7, 5};
        Pair<Integer, Integer> pair = secondSmallestandSecondLargest(arr);
        System.out.println("Second smallest is " + pair.getLeft());
        System.out.println("Second largest is " + pair.getRight());
    }
}
