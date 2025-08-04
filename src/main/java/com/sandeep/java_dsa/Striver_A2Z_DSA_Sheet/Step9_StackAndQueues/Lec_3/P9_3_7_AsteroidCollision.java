package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step9_StackAndQueues.Lec_3;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class P9_3_7_AsteroidCollision {

    public static int[] calculateAfterCollision(int[] asteroids){
        List<Integer> listStack = new ArrayList<>();
        for(int i=0;i<asteroids.length;i++){
            if(asteroids[i]>0) listStack.add(asteroids[i]);
            else{
                while (!listStack.isEmpty() && listStack.getLast()>0 && listStack.getLast()<Math.abs(asteroids[i])){
                    listStack.removeLast();
                }
                if (!listStack.isEmpty() && listStack.getLast()==Math.abs(asteroids[i])){           // if getlast is begative, condition fails because we are checking equality with abs(element)
                    listStack.removeLast();
                }else if(listStack.isEmpty() || listStack.getLast()<0) listStack.add(asteroids[i]);
            }
        }
        int[] result = new int[listStack.size()];
        for(int i=0;i<listStack.size();i++){
            result[i]=listStack.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] asteroid = new int[]{-2,-1,1,-2};
        System.out.println(Arrays.toString(calculateAfterCollision(asteroid)));
    }
}
