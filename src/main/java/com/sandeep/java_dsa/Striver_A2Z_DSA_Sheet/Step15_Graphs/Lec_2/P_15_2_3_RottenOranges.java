package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step15_Graphs.Lec_2;

import java.util.LinkedList;
import java.util.Queue;

public class P_15_2_3_RottenOranges {

    /**
     * You are given an m x n grid where each cell can have one of three values:
     *
     * 0 representing an empty cell,
     * 1 representing a fresh orange, or
     * 2 representing a rotten orange.
     * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
     *
     * Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
     *
     * Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
     * Output: 4
     */

    static class Pair {
        int first;
        int second;
        int time;

        public Pair(int i, int j, int tm) {
            first = i;
            second = j;
            time = tm;
        }
    }

    /**
     * SC -> O(m*n)+O(m*n) == O(m*n) {for vis[][], Queue}
     * TC -> O(m*n) {Queue can have atmost n*m elements and for each n*m elements inner loop executes 4 times so approx 4*(m*n) i.e. equivalent to O(m*n)}
     */

    private static int solution1(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        Queue<Pair> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Pair(i, j, 0));
                    vis[i][j] = 2;
                } else {
                    vis[i][j] = 0;
                }
            }
        }

        int[] drow = new int[]{-1, 0, +1, 0};
        int[] dcol = new int[]{0, -1, 0, +1};

        int maxTime = 0;
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int row = pair.first;
            int col = pair.second;
            int time = pair.time;

            maxTime = Math.max(time, maxTime);
            for (int i = 0; i < 4; i++) {
                int nRow = row + drow[i];
                int nCol = col + dcol[i];

                if (nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && vis[nRow][nCol] != 2 && grid[nRow][nCol] == 1) {
                    queue.add(new Pair(nRow, nCol, time + 1));
                    vis[nRow][nCol] = 2;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (vis[i][j] != 2 && grid[i][j] == 1) return -1;
            }
        }
        return maxTime;
    }

    private static int solution2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        int freshCount = 0;
        Queue<Pair> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Pair(i, j, 0));
                    vis[i][j] = 2;
                } else {
                    vis[i][j] = 0;
                }

                if (grid[i][j] == 1) freshCount++;
            }
        }

        int[] drow = new int[]{-1, 0, +1, 0};
        int[] dcol = new int[]{0, -1, 0, +1};

        int maxTime = 0;
        int freshRottenCount = 0;
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int row = pair.first;
            int col = pair.second;
            int time = pair.time;

            maxTime = Math.max(time, maxTime);
            for (int i = 0; i < 4; i++) {
                int nRow = row + drow[i];
                int nCol = col + dcol[i];

                if (nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && vis[nRow][nCol] != 2 && grid[nRow][nCol] == 1) {
                    queue.add(new Pair(nRow, nCol, time + 1));
                    vis[nRow][nCol] = 2;
                    freshRottenCount++;
                }
            }
        }

        if (freshCount != freshRottenCount) return -1;
        return maxTime;
    }


    public static void main(String[] args) {
        int[][] grid = new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(solution1(grid));
        System.out.println(solution2(grid));
    }
}
