package com.sandeep.java_dsa.NeetCode150;

import java.util.HashSet;

public class P1_ContainsDuplicates {

    static boolean containsDuplicate(int[] nums){
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums){
            if(set.contains(num)) return false;
            set.add(num);
        }
        return true;
    }

    public static void main(String[] args) {

    }

}
