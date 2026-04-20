package com.sandeep.java_dsa.DS_ImplementationsAndLearnings.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class I0_GraphImplementation {

    private static void graphRepresentationUsingAdjacencyMatrix(int n, int m, int[][] edges){
        int[][] adjMatrix = new int[n+1][n+1];
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];

            adjMatrix[u][v]=1;
            adjMatrix[v][u]=1;
        }

        System.out.println(Arrays.deepToString(adjMatrix));
    }

    private static void graphRepresentationUsingAdjacencyList(int n, int m, int[][] edges){
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v = edges[i][1];

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        System.out.println(adjList.toString());
    }

    public static void main(String[] args) {
        int n=5, m=6;
        int[][] input = new int[][]{{1,2},{1,3},{3,4},{2,4},{2,5},{4,5}};
        graphRepresentationUsingAdjacencyMatrix(n,m,input);
        graphRepresentationUsingAdjacencyList(n,m,input);
    }
}
