package Graph;
import java.util.*;



    public class DetectCycleUndirectedBF {

        static boolean bfs(int start, List<List<Integer>> graph, boolean[] visited) {
            Queue<Integer> q = new LinkedList<>();
            int[] parent = new int[graph.size()];

            q.add(start);
            visited[start] = true;
            parent[start] = -1;

            while (!q.isEmpty()) {
                int node = q.poll();

                for (int neighbour : graph.get(node)) {
                    if (!visited[neighbour]) {
                        visited[neighbour] = true;
                        parent[neighbour] = node;
                        q.add(neighbour);
                    }
                    else if (neighbour != parent[node]) {
                        // Visited + not parent → Cycle
                        return true;
                    }
                }
            }
            return false;
        }

        static boolean hasCycle(int V, List<List<Integer>> graph) {
            boolean[] visited = new boolean[V];

            // Disconnected graph ke liye
            for (int i = 0; i < V; i++) {
                if (!visited[i]) {
                    if (bfs(i, graph, visited)) {
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

