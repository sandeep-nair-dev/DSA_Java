package com.sandeep.java_dsa.NeetCode150;

import java.util.Arrays;
import java.util.Stack;

public class P26_CarFleet {

    /*
    Using Stack
    TC -> O(n*logn)
    SC -> O(n)
     */
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] pairs = new int[n][2];
        Stack<Double> stack = new Stack<>();

        for(int i=0;i<n;i++){
            pairs[i][0]=position[i];
            pairs[i][1]=speed[i];
        }

        Arrays.sort(pairs, (a,b)-> Integer.compare(b[0],a[0]));

        for(int[] pair: pairs){
            stack.push((double)(target-pair[0])/pair[1]);
            if(stack.size()>=2 && stack.peek()<=stack.get(stack.size()-2)){
                stack.pop();
            }
        }
        return stack.size();
    }

    /*
    Using Iteration
    TC -> O(n*logn)
    SC -> O(n)
     */
    public int carFleet2(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] pairs = new int[n][2];
        for(int i=0;i<n;i++){
            pairs[i][0]=position[i];
            pairs[i][1]=speed[i];
        }

        Arrays.sort(pairs, (a,b) -> Integer.compare(b[0],a[0]));

        double prevTime = (double)(target-pairs[0][0])/pairs[0][1];

        int fleet=1;
        for(int i=1;i<n;i++){
            double currentTime = (double)(target-pairs[i][0])/pairs[i][1];
            if(currentTime>prevTime){
                fleet++;
                prevTime=currentTime;
            }
        }
        return fleet;
    }

    public static void main(String[] args) {
        int[] position = {10, 8, 0, 5, 3};
        int[] speed = {2, 4, 1, 1, 3};
        int target = 12;
        P26_CarFleet fleets = new P26_CarFleet();
        System.out.println(fleets.carFleet(target, position, speed));
        System.out.println(fleets.carFleet2(target, position, speed));
    }
}
