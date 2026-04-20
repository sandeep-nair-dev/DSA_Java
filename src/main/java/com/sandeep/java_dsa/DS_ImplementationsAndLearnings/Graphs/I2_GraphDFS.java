package com.sandeep.java_dsa.DS_ImplementationsAndLearnings.Graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class I2_GraphDFS {

    private static void graphDFS(int node, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> dfs, boolean[] vis){
        vis[node]=true;
        dfs.add(node);
        for(Integer it:adj.get(node)){
            if(!vis[it]){
                graphDFS(it, adj, dfs, vis);
            }
        }
    }

    public static void main(String[] args) {
        int n=9;
        ArrayList< ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=1;i<=9;i++){
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(1).add(3);
        adj.get(2).add(1);
        adj.get(2).add(5);
        adj.get(2).add(6);
        adj.get(3).add(1);
        adj.get(3).add(4);
        adj.get(3).add(7);
        adj.get(4).add(3);
        adj.get(4).add(8);
        adj.get(5).add(2);
        adj.get(6).add(2);
        adj.get(7).add(3);
        adj.get(7).add(8);
        adj.get(8).add(4);
        adj.get(8).add(7);

        ArrayList<Integer> dfs = new ArrayList<>();
        boolean[] vis = new boolean[n+1];
        graphDFS(1, adj, dfs, vis);

        System.out.println(dfs);
    }
}
