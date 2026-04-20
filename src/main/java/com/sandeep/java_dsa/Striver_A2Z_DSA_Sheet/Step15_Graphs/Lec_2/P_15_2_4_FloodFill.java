package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step15_Graphs.Lec_2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P_15_2_4_FloodFill {

    /**
     * You are given an image represented by an m x n grid of integers image, where image[i][j] represents the pixel value of the image. You are also given three integers sr, sc, and color. Your task is to perform a flood fill on the image starting from the pixel image[sr][sc].
     *
     * To perform a flood fill:
     *
     * Begin with the starting pixel and change its color to color.
     * Perform the same process for each pixel that is directly adjacent (pixels that share a side with the original pixel, either horizontally or vertically) and shares the same color as the starting pixel.
     * Keep repeating this process by checking neighboring pixels of the updated pixels and modifying their color if it matches the original color of the starting pixel.
     * The process stops when there are no more adjacent pixels of the original color to update.
     * Return the modified image after performing the flood fill.
     *
     *
     * Example 1:
     * Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
     * Output: [[2,2,2],[2,2,0],[2,0,1]]
     */

    static class Pair{
        int row;
        int column;

        public Pair(int r, int c){
            row = r;
            column=c;
        }
    }

    private static int[][] solution(int[][] image, int sr, int sc, int color){
        int m = image.length;
        int n = image[0].length;
        int[][] resultantImage = new int[image.length][image[0].length];
        for(int i=0;i<m;i++){
            System.arraycopy(image[i], 0, resultantImage[i], 0, image[0].length);
        }

        int initialColor=image[sr][sc];
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(sr, sc));
        int[] drow = new int[]{0,1,0,-1};
        int[] dcol = new int[]{-1,0,1,0};

        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            int r = pair.row;
            int c = pair.column;

            resultantImage[r][c]=color;
            for(int i=0;i<4;i++){
                int nrow = r+drow[i];
                int ncol = c+dcol[i];
                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && resultantImage[nrow][ncol]==initialColor){
                    queue.add(new Pair(nrow, ncol));
                }
            }
        }
        return resultantImage;
    }

    public static void main(String[] args) {
        int[][] image  = new int[][]{{0,0,0},{0,0,0}};
        int sr=1, sc=0, color=2;
        int[][] resultantImage = solution(image, sr, sc, color);
        System.out.println(Arrays.deepToString(resultantImage));
    }
}
