package com.sandeep.java_dsa.Collections;

import java.util.Arrays;

public class LearnArraysClass {
    public static void main(String[] args) {
        int[] n1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int index = Arrays.binarySearch(n1, 4);      //But array has to be sorted
//        System.out.println(index);
        Integer[] n2 = new Integer[]{1, 7, 23, 5, 8, 9, 1, 2, 55, 2};
        Arrays.sort(n2);
//        System.out.println(Arrays.toString(n2));
        Arrays.fill(n2, 99);
//        System.out.println(Arrays.toString(n2));
    }
}
