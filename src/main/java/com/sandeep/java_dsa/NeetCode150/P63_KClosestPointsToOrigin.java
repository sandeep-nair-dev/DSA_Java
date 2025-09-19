package com.sandeep.java_dsa.NeetCode150;

import java.util.Arrays;
import java.util.PriorityQueue;

public class P63_KClosestPointsToOrigin {

    static class Point implements Comparable<Point> {
        int x;
        int y;
        int distSq;
        int i;

        Point(int x, int y, int ds, int i) {
            this.x = x;
            this.y = y;
            this.distSq = ds;
            this.i = i;
        }

        @Override
        public int compareTo(Point p2) {
            return p2.distSq - this.distSq;
        }
    }


    public static int[][] kClosest1(int[][] points, int k) {
        int[][] result = new int[k][2];
        PriorityQueue<Point> pq = new PriorityQueue<>();
        for (int i = 0; i < points.length; i++) {
            int distSq = (int) (Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2));
            Point point = new Point(points[i][0], points[i][1], distSq, i);
            if (pq.size() < k) {
                pq.offer(point);
            } else if (distSq < pq.peek().distSq) {
                pq.offer(point);
                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }

        for (int i = 0; i < k; i++) {
            Point p = pq.poll();
            result[i][0] = p.x;
            result[i][1] = p.y;
        }
        return result;
    }

    //Alternate

    static class Pair {
        int left;
        int right;

        public int getLeft() {
            return left;
        }

        public int getRight() {
            return right;
        }

        public Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    private static int findEuclideanDistance(int[] points) {
        return (int) (Math.pow(points[0], 2) + Math.pow(points[1], 2));
    }

    public static int[][] kClosest2(int[][] points, int k) {
        int[][] result = new int[k][2];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.right - a.right);
        for (int i = 0; i < points.length; i++) {
            int eDistance = findEuclideanDistance(points[i]);
            if (pq.size() < k) {
                pq.offer(new Pair(i, eDistance));
            } else if (eDistance < pq.peek().getRight()) {
                pq.offer(new Pair(i, eDistance));
                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }
        int ind = 0;
        while (!pq.isEmpty()) {
            int arrInd = pq.poll().getLeft();
            result[ind][0] = points[arrInd][0];
            result[ind][1] = points[arrInd][1];
            ind++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{{3, 3}, {5, -1}, {-2, 4}};
        int k = 2;
        System.out.println(Arrays.deepToString(kClosest1(points, k)));
        System.out.println(Arrays.deepToString(kClosest2(points, k)));
    }

    //Alternate

}
