package Graph;


import java.util.*;

    public class PrimsAlgorithm {

        // Pair class → (node, weight)
        static class Pair {
            int node;
            int weight;

            Pair(int node, int weight) {
                this.node = node;
                this.weight = weight;
            }
        }

        static void prims(int V, List<List<Pair>> graph) {

            // visited array - kaunsa node MST mein aa chuka hai
            boolean[] visited = new boolean[V];

            // Min-Heap (Priority Queue) - sabse chhoti weight wali edge pehle nikaalegi
            PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);

            // MST ka total weight
            int totalWeight = 0;

            // Start from node 0
            pq.add(new Pair(0, 0));

            while (!pq.isEmpty()) {
                Pair current = pq.poll();
                int node = current.node;
                int weight = current.weight;

                // Agar yeh node pehle se MST mein hai toh skip
                if (visited[node]) continue;

                // Node ko MST mein add kar do
                visited[node] = true;
                totalWeight += weight;

                // Is node ke saare neighbours ko queue mein daalo
                for (Pair neighbour : graph.get(node)) {
                    if (!visited[neighbour.node]) {
                        pq.add(new Pair(neighbour.node, neighbour.weight));
                    }
                }
            }

            System.out.println("Total Weight of MST: " + totalWeight);
        }

        public static void main(String[] args) {

            int V = 4;

            // Graph banate hain (Undirected)
            List<List<Pair>> graph = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                graph.add(new ArrayList<>());
            }

            // Edges add kar rahe hain (undirected hai isliye dono taraf)
            // 0-1 : 2
            graph.get(0).add(new Pair(1, 2));
            graph.get(1).add(new Pair(0, 2));

            // 0-3 : 6
            graph.get(0).add(new Pair(3, 6));
            graph.get(3).add(new Pair(0, 6));

            // 1-2 : 8
            graph.get(1).add(new Pair(2, 8));
            graph.get(2).add(new Pair(1, 8));

            // 1-3 : 3
            graph.get(1).add(new Pair(3, 3));
            graph.get(3).add(new Pair(1, 3));

            // 2-3 : 5
            graph.get(2).add(new Pair(3, 5));
            graph.get(3).add(new Pair(2, 5));

            // Prim’s chalao
            prims(V, graph);
        }
    }

