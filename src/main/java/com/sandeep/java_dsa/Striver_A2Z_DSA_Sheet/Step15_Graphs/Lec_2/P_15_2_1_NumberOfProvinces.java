package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step15_Graphs.Lec_2;

public class P_15_2_1_NumberOfProvinces {

    /**
     * There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.
     *
     * A province is a group of directly or indirectly connected cities and no other cities outside of the group.
     *
     * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
     *
     * Return the total number of provinces.
     *
     * Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
     * Output: 2
     */

    private static void dfs(int node, int[][] adj, boolean[] vis){
        vis[node]=true;
        int[] connectedNodes = adj[node];
        for(int i=0;i<connectedNodes.length;i++){
            if(connectedNodes[i]==1 && !vis[i]){
                dfs(i, adj, vis);
            }
        }
    }
    private static int findNumberOfProvinces(int[][] adj){
        boolean[] vis = new boolean[adj.length];
        int count=0;
        for(int i=0;i<vis.length;i++){
            if(!vis[i]){
                count++;
                dfs(i, adj, vis);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] isConnected = {{1,0,0},{0,1,0},{0,0,1}};
        System.out.println(findNumberOfProvinces(isConnected));
    }
}
