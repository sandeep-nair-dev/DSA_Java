package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step15_Graphs.Lec_2;

import java.util.ArrayList;

public class P_15_2_2_ConnectedComponents {

    /**
     * Given an undirected Graph consisting of V vertices numbered from 0 to V-1 and E edges. The ith edge is represented by [ai,bi], denoting a edge between vertex ai and bi. We say two vertices u and v belong to a same component if there is a path from u to v or v to u. Find the number of connected components in the graph.
     *
     * A connected component is a subgraph of a graph in which there exists a path between any two vertices, and no vertex of the subgraph shares an edge with a vertex outside of the subgraph.
     * Input: V=4, edges=[[0,1],[1,2]]
     * Output: 2
     * Explanation: Vertices {0,1,2} forms the first component and vertex 3 forms the second component.
     */

    private static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis){
        vis[node]=true;
        ArrayList<Integer> connectedNodes = adj.get(node);
        for(Integer i: connectedNodes){
            if(!vis[i]){
                dfs(i, adj, vis);
            }
        }
    }

    private static int findNumberOfConnectedComponents(int v, int[][] edges){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean[] vis = new boolean[v];
        int count=0;
        for(int i=0;i<v;i++){
            if(!vis[i]){
                count++;
                dfs(i, adj, vis);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int v=7;
        int[][] edges = new int[][]{{0,1},{1,2},{2,3},{4,5}};
        System.out.println(findNumberOfConnectedComponents(v, edges));
    }
}
