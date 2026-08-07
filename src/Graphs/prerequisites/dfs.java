package Graphs.prerequisites;

import java.util.*;

public class dfs {
    public static void main(String [] args) {

        int v = 4; //number of vertices
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < v; i++){
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(0);


        adj.get(0).add(2);
        adj.get(2).add(0);

        adj.get(1).add(3);
        adj.get(3).add(1);

        adj.get(2).add(3);
        adj.get(3).add(2);

        boolean [] visited = new boolean[v];

        System.out.println("DFS Traversal : ");
        DFS(0,visited,adj);


    }
    static void DFS(int node , boolean []visited , List<List<Integer>> adj){
        visited[node] = true;
        System.out.print(node + " ");
        for(int neighbour : adj.get(node)){
            if(!visited[neighbour]){
                DFS(neighbour, visited, adj);
            }


        }
    }
}
