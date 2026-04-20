package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step15_Graphs.Lec_2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class P_15_2_5_CycleDetectionInGraphBFS {

    /**
     * TC -> O(N+2E) + O(N){In case of components, we go for each node, but that just touches the node, for loop doesn't execute for each because other nodes are already visited in the call made for source}
     * SC -> O(N)
     */

    static class Pair{
        int first;
        int second;

        Pair(int i, int j){
            first=i;
            second=j;
        }
    }

    private static boolean findCycleExistsBFS(int src, boolean[] vis, ArrayList<ArrayList<Integer>> adj){
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(src,-1));
        vis[src]=true;
        while (!queue.isEmpty()){
            Pair pair = queue.poll();
            int node = pair.first;
            int parent  = pair.second;
            for(Integer i:adj.get(node)){
                if(!vis[i]){
                    queue.add(new Pair(i,node));
                    vis[i]=true;
                }else if(i!=parent){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isCycle(int v, int[][] edges){               // Check if cycle present for each node that is not visited. To handle the case where multiple components are present.
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        boolean[] vis = new boolean[v];
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int edge1 = edge[0];
            int edge2 = edge[1];
            adj.get(edge1).add(edge2);
            adj.get(edge2).add(edge1);
        }

        for(int i=0;i<v;i++){
            if(!vis[i]) {
                if (findCycleExistsBFS(i, vis, adj)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int v=4, e=4;
        int[][] edges = new int[][]{{0,1},{1,2},{2,3}};
        System.out.println(isCycle(v, edges));
    }
}
