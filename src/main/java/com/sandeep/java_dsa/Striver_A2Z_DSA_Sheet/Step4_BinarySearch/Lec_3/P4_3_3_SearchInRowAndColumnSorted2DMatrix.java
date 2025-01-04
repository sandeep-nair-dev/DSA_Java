package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step4_BinarySearch.Lec_3;

import java.util.ArrayList;
import java.util.Arrays;

public class P4_3_3_SearchInRowAndColumnSorted2DMatrix {

    public static boolean searchElement(ArrayList<ArrayList<Integer>> matrix, int target) {
        int row = 0;
        int col = matrix.get(0).size() - 1;
        while (row < matrix.size() && col >= 0) {
            if (matrix.get(row).get(col) == target) return true;       //for getting index, return row, col
            else if (matrix.get(row).get(col) < target) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(1, 4, 7, 11, 15)));
        matrix.add(new ArrayList<>(Arrays.asList(2, 5, 8, 12, 19)));
        matrix.add(new ArrayList<>(Arrays.asList(3, 6, 9, 16, 22)));
        matrix.add(new ArrayList<>(Arrays.asList(10, 13, 14, 17, 24)));
        matrix.add(new ArrayList<>(Arrays.asList(18, 21, 23, 26, 30)));

        boolean result = searchElement(matrix, 8);
        System.out.println(result ? "true" : "false");
    }
}