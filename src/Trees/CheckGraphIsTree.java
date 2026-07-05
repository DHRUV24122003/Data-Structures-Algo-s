package Trees;

import java.util.*;

class CheckGraphIsTree {

    // DFS function to check connectivity
    static void dfs(int node, boolean[] visited, List<List<Integer>> adj) {
        visited[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, adj);
            }
        }
    }

    // Main function to check if graph is a tree
    static boolean isTree(int n, List<List<Integer>> adj) {

        // Condition 1: Check number of edges
        int edgeCount = 0;
        for (int i = 0; i < n; i++) {
            edgeCount += adj.get(i).size();
        }
        edgeCount = edgeCount / 2; // Kyunki undirected graph hai (har edge 2 baar count hota hai)

        if (edgeCount != n - 1) {
            return false; // Agar edges n-1 nahi hain toh tree nahi ho sakta
        }

        // Condition 2: Check if graph is connected
        boolean[] visited = new boolean[n];
        dfs(0, visited, adj); // Kisi bhi node (0) se DFS shuru karo

        // Check if all nodes are visited
        for (boolean v : visited) {
            if (!v) {
                return false; // Koi node visit nahi hua → disconnected → not a tree
            }
        }

        return true; // Dono conditions satisfy → Tree hai
    }

    public static void main(String[] args) {

        int n = 4; // Number of vertices

        // Adjacency List banate hain
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Example 1: Valid Tree (4 nodes, 3 edges)
        adj.get(0).add(1); adj.get(1).add(0);
        adj.get(1).add(2); adj.get(2).add(1);
        adj.get(2).add(3); adj.get(3).add(2);

        System.out.println("Is Tree : " + isTree(n, adj));  // Output: true

        // Example 2: Not a Tree (Cycle hai)
        // adj.get(0).add(1); adj.get(1).add(0);
        // adj.get(1).add(2); adj.get(2).add(1);
        // adj.get(2).add(0); adj.get(0).add(2); // Cycle
        // System.out.println("Is Tree? " + isTree(n, adj));  // Output: false
        //
    }
}