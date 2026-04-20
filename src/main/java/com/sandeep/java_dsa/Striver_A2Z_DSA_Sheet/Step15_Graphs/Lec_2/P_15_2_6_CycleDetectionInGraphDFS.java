package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step15_Graphs.Lec_2;

import java.util.ArrayList;

public class P_15_2_6_CycleDetectionInGraphDFS {

    /**
     * TC -> O(N+2E) {For each node, it goes through all the connected nodes, that is degree of the node and degree of node is 2E} + O(N){calls this many times for different components and that in turn calls all the other nodes that  is why it is + and not *}
     * Therefore TC -> O(N+2E) + O(N)
     * SC -> O(N)  + O(N) {Recursion stack space of no. of nodes + Visited array } ~= O(N)
     */

    private static boolean findCycleDFS(int node, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] vis){
            vis[node]=true;
            for(Integer i:adj.get(node)){
                if(!vis[i]){
                    if(findCycleDFS(i, node, adj, vis)){
                        return true;
                    }
                }
                else if(i!=parent){
                    return true;
                }
            }
        return false;
    }

    private static boolean isCycle(int v, int[][] edges){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        boolean[] vis = new boolean[v];
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];

            adj.get(node1).add(node2);
            adj.get(node2).add(node1);
        }

        for(int i=0;i<v;i++){
            if(!vis[i]){
                if(findCycleDFS(i,-1,  adj, vis)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int v=4, e=4;
        int[][] edges = new int[][]{{0,1},{0,2},{1,2},{2,3}};
        System.out.println(isCycle(v,edges));
    }
}
