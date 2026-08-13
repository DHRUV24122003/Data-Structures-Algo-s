package Graph;
import java.util.*;
public class DetectCycleUndirected {
//check if a visited node is not the parent of current node - means cycle is there
    static boolean dfs(int node, int parent, List<List<Integer>> graph, boolean[] visited) {
        visited[node] = true; //initialize as visited

        for (int neighbour : graph.get(node)) { //for all the neighbours
            if (!visited[neighbour]) { //not visited - recurse
                // Not visited → recurse
                if (dfs(neighbour, node, graph, visited)) { //call the function if visited return true
                    return true;
                }
            }
            else if (neighbour != parent) {
                // Visited + not parent → Cycle mil gaya
                return true;
            }
        }
        return false;
    }

    static boolean hasCycle(int V, List<List<Integer>> graph) {
        boolean[] visited = new boolean[V];

        // Disconnected graph ke liye saare nodes check karo
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, -1, graph, visited)) {
                    return true;
                }
            }
        }
        return false;
    }





    public static void main(String[] args) {
        int V = 4;

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // Example: Cycle hai (0-1-2-3-0)
        graph.get(0).add(1);
        graph.get(1).add(0);

        graph.get(1).add(2);
        graph.get(2).add(1);

        graph.get(2).add(3);
        graph.get(3).add(2);

        graph.get(3).add(0);
        graph.get(0).add(3);

        if (hasCycle(V, graph)) {
            System.out.println("Cycle Detected");
        } else {
            System.out.println("No Cycle");
        }
    }

}
