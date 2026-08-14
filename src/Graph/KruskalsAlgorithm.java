package Graph;


import java.util.*;

    public class KruskalsAlgorithm {

        // Edge class
        static class Edge implements Comparable<Edge> {
            int src, dest, weight;

            Edge(int src, int dest, int weight) {
                this.src = src;
                this.dest = dest;
                this.weight = weight;
            }

            // Weight ke hisaab se sort karne ke liye
            public int compareTo(Edge other) {
                return this.weight - other.weight;
            }
        }

        // ---------- Union-Find (Disjoint Set) ----------
        static int[] parent;

        static int find(int x) {
            if (parent[x] == x)
                return x;
            return parent[x] = find(parent[x]);  // Path compression
        }

        static void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px != py) {
                parent[py] = px;
            }
        }

        // ---------- Kruskal’s Algorithm ----------
        static void kruskal(int V, List<Edge> edges) {

            // Parent array initialize karo (har node apna parent)
            parent = new int[V];
            for (int i = 0; i < V; i++) {
                parent[i] = i;
            }

            // Edges ko weight ke hisaab se sort karo
            Collections.sort(edges);

            int totalWeight = 0;
            int edgeCount = 0;

            System.out.println("Edges in MST:");

            for (Edge edge : edges) {
                int u = edge.src;
                int v = edge.dest;

                // Agar dono alag component mein hain
                if (find(u) != find(v)) {
                    union(u, v);
                    totalWeight += edge.weight;
                    edgeCount++;

                    System.out.println(u + " - " + v + "  weight: " + edge.weight);

                    // (V-1) edges mil gayi toh ruk jao
                    if (edgeCount == V - 1)
                        break;
                }
            }

            System.out.println("Total Weight of MST: " + totalWeight);
        }

        public static void main(String[] args) {

            int V = 4;
            List<Edge> edges = new ArrayList<>();

            // Edges add kar rahe hain (undirected)
            edges.add(new Edge(0, 1, 2));
            edges.add(new Edge(0, 3, 6));
            edges.add(new Edge(1, 2, 8));
            edges.add(new Edge(1, 3, 3));
            edges.add(new Edge(2, 3, 5));

            // Kruskal’s chalao
            kruskal(V, edges);
        }
    }

