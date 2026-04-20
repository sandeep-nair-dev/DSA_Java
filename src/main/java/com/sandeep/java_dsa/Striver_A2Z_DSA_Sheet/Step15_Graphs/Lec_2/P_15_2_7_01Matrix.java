package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step15_Graphs.Lec_2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P_15_2_7_01Matrix {

    static class Pair{
        int row;
        int col;
        int dist;

        Pair(int i, int j, int k){
            row=i;
            col=j;
            dist=k;
        }
    }

    private static int[][] nearestZero(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] resultDistanceMatrix = new int[m][n];
        int[][] visited =new int[m][n];
        int[] drow = new int[]{-1,0,1,0};
        int[] dcol = new int[]{0,-1,0,1};

        Queue<Pair> queue = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    queue.add(new Pair(i,j,0));
                    visited[i][j]=1;
                }
            }
        }

        while (!queue.isEmpty()){
            Pair front = queue.poll();
            int row = front.row;
            int col = front.col;
            int dist = front.dist;
            resultDistanceMatrix[row][col]=dist;
            for(int i=0;i<4;i++){
                int nrow = row + drow[i];
                int ncol = col+dcol[i];
                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && matrix[nrow][ncol]==1 && visited[nrow][ncol]==0){
                    queue.add(new Pair(nrow, ncol, dist+1));
                    visited[nrow][ncol]=1;
                }
            }
        }
        return resultDistanceMatrix;
    }

    public static void main(String[] args) {
        int [][] mat = new int[][]{{0,0,0},{0,1,0}, {1,1,1}};
        System.out.println(Arrays.deepToString(nearestZero(mat)));
    }
}
