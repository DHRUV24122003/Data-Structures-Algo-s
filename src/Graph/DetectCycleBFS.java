package Graph;

import java.util.*;

    public class DetectCycleBFS {

        static boolean hasCycle(int V, List<List<Integer>> graph) {
            // Step 1: Indegree calculate karo
            int[] indegree = new int[V];
            for (int i = 0; i < V; i++) {
                for (int neighbour : graph.get(i)) {
                    indegree[neighbour]++;
                }
            }

            // Step 2: Indegree 0 wale nodes ko queue mein daalo
            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < V; i++) {
                if (indegree[i] == 0) {
                    q.add(i);
                }
            }

            // Step 3: BFS chalao
            int count = 0; // kitne nodes process kiye

            while (!q.isEmpty()) {
                int node = q.poll();
                count++;

                // Is node ke neighbours ka indegree kam karo
                for (int neighbour : graph.get(node)) {
                    indegree[neighbour]--;
                    if (indegree[neighbour] == 0) {
                        q.add(neighbour);
                    }
                }
            }

            // Step 4: Check karo
            // Agar saare nodes process ho gaye → No Cycle
            // Agar kuch nodes reh gaye → Cycle hai
            return count != V;
        }

        public static void main(String[] args) {
            int V = 4;

            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                graph.add(new ArrayList<>());
            }

            // -------- Example: Cycle hai --------
            // 0 → 1 → 2 → 3
            //      ↑_______│  (3 → 1)
            graph.get(0).add(1);
            graph.get(1).add(2);
            graph.get(2).add(3);
            graph.get(3).add(1);   // back edge → cycle

            if (hasCycle(V, graph)) {
                System.out.println("Cycle Detected");
            } else {
                System.out.println("No Cycle");
            }
        }
    }


