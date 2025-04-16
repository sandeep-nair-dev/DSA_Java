package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step16_DynamicProgramming.Lec_4;

import java.lang.reflect.Array;
import java.util.Arrays;

public class P_16_4_6_AssignCookie {

    public static void main(String[] args) {

        int[] g = new int[]{1,2};
        int[] s = new int[]{1,2,3};

        Arrays.sort(g);
        Arrays.sort(s);

        int gptr=0, sptr=0;
        while(sptr<s.length && gptr<g.length){
            if(s[sptr]>=g[gptr]){
                gptr++;
            }
            sptr++;
        }
        System.out.println("Satisfied children: " + gptr);

    }
}