package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step3_Arrays.Lec_3;

import java.util.ArrayList;
import java.util.List;

public class P_3_3_1_PascalsTriangle {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascal = new ArrayList<>();
        if (numRows == 0) return pascal;
        pascal.add(List.of(1));
        if (numRows == 1) return pascal;
        pascal.add(List.of(1, 1));
        if (numRows == 2) return pascal;
        for (int i = 2; i <= numRows; i++) {
            pascal.add(new ArrayList<>());
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    pascal.get(i).add(1);
                } else {
                    pascal.get(i).add(pascal.get(i - 1).get(j - 1) + pascal.get(i - 1).get(j));
                }
            }
        }
        return pascal;
    }

    public static void main(String[] args) {
        List<List<Integer>> pascal = generate(3);
        System.out.println(pascal);
    }
}
