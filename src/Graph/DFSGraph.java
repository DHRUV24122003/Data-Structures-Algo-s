package Graph;

import java.util.*;

public class DFSGraph {

    // DFS function
    static void dfs(int node, boolean[] visited, List<List<Integer>> graph) {
        // Current node ko visited mark karo
        visited[node] = true;
        System.out.print(node + " ");

        // Saare neighbours pe jao
        for (int neighbour : graph.get(node)) {
            if (!visited[neighbour]) {
                dfs(neighbour, visited, graph);
            }
        }
    }

    public static void main(String[] args) {
        int V = 5; // number of vertices (0 to 4)

        // Graph banate hain (Adjacency List)
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // Edges add kar rahe hain (Undirected Graph)
        graph.get(0).add(1);
        graph.get(0).add(2);

        graph.get(1).add(0);
        graph.get(1).add(3);
        graph.get(1).add(4);

        graph.get(2).add(0);

        graph.get(3).add(1);

        graph.get(4).add(1);

        // Visited array
        boolean[] visited = new boolean[V];

        System.out.print("DFS Traversal: ");

        // Disconnected graph bhi handle karne ke liye
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, visited, graph);
            }
        }
    }
}