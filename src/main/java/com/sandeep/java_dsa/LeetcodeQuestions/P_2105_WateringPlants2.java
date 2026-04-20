package com.sandeep.java_dsa.LeetcodeQuestions;

import java.util.List;

public class P_2105_WateringPlants2 {

    private static int noOfRefills(int[] plants, int capA, int capB){
        int i=0, j=plants.length-1;
        int refills=0;
        int waterA=capA;
        int waterB=capB;
        while (i<=j){
            if(i==j){
                if(waterA==waterB){
                    if(waterA<plants[i]){
                        refills++;
                        waterA=capA;
                    }
                    waterA-=plants[i];
                }else{
                    int refiller = Math.max(waterA, waterB);
                    if(refiller<plants[i]){
                        refills++;
                    }
                }
            }else{
                if(waterA<plants[i]){
                    refills++;
                    waterA=capA;
                }
                waterA-=plants[i];

                if(waterB<plants[j]){
                    refills++;
                    waterB=capB;
                }
                waterB-=plants[j];
            }
            i++;
            j--;
        }
        return refills;
    }

    public static void main(String[] args) {
        int[] plants = new int[]{2,2,3,3};
        int capA=3;
        int capB=4;
        System.out.println(noOfRefills(plants, capA, capB));
    }
}
