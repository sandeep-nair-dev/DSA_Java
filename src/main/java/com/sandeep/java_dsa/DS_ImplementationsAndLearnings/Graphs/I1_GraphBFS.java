package com.sandeep.java_dsa.DS_ImplementationsAndLearnings.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class I1_GraphBFS {

    private static ArrayList<Integer> graphBFS(int n, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] vis = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        vis[0]=true;

        while (!queue.isEmpty()){
            Integer node = queue.poll();
            bfs.add(node);

            for(Integer it:adj.get(node)){
                if(!vis[it]){
                    vis[it]=true;
                    queue.add(it);
                }
            }
        }
        return bfs;
    }

    public static void main(String[] args) {
        int n = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(4);
        adj.get(4).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(1).add(3);
        adj.get(3).add(1);

        ArrayList<Integer> bfs = graphBFS(n, adj);
        System.out.println(bfs);
    }
}
