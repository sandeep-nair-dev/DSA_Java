package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step7_Recursion.Lec_2;

import java.util.ArrayList;

public class P_7_2_1_GenerateAllBinaryStrings {

    public static void generateAllBinaryStrings(String str, int num) {
        if (str.length() == num) {
            System.out.println(str);
            return;
        }
        if (str.charAt(str.length() - 1) == '1') {
            generateAllBinaryStrings(str + '0', num);
        } else {
            generateAllBinaryStrings(str + '0', num);
            generateAllBinaryStrings(str + '1', num);
        }
    }

    public static ArrayList<String> generateAllBinaryStrings(int n) {
        if (n == 0) {
            ArrayList<String> emptyList = new ArrayList<>();
            emptyList.add("");
            return emptyList;
        }

        if (n == 1) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add("0");
            arrayList.add("1");
            return arrayList;
        }

        ArrayList<String> result = new ArrayList<>();
        ArrayList<String> prevList = generateAllBinaryStrings(n - 1);
        prevList.forEach(s -> {
            result.add(s + '0');
            if (s.charAt(s.length() - 1) == '0') result.add(s + '1');
        });
        return result;
    }

    public static void print(int num) {
        generateAllBinaryStrings("0", num);
        generateAllBinaryStrings("1", num);
    }

    public static void main(String[] args) {
        print(4);
        System.out.println("--------------------");
        ArrayList<String> arrayList = generateAllBinaryStrings(4);
        System.out.println(arrayList);
    }
}