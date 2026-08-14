package Graph;
import java.util.*;

    public class FloydWarshal {

        static final int INF = 99999;   // Infinity ki jagah bada number

        static void floydWarshall(int[][] graph, int V) {

            // dist matrix banaya - isme answer store hoga
            int[][] dist = new int[V][V];

            // Step 1: Initial matrix copy karo
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    dist[i][j] = graph[i][j];
                }
            }

            // Step 2: Har intermediate node k try karo
            for (int k = 0; k < V; k++) {           // k = intermediate node

                for (int i = 0; i < V; i++) {       // i = source

                    for (int j = 0; j < V; j++) {   // j = destination

                        // Agar i → k → j  better hai toh update karo
                        if (dist[i][k] != INF && dist[k][j] != INF &&
                                dist[i][k] + dist[k][j] < dist[i][j]) {

                            dist[i][j] = dist[i][k] + dist[k][j];
                        }
                    }
                }
            }

            // Final matrix print karo
            printSolution(dist, V);
        }

        static void printSolution(int[][] dist, int V) {
            System.out.println("Shortest distances between every pair of vertices:");
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][j] == INF) {
                        System.out.print("INF ");
                    } else {
                        System.out.print(dist[i][j] + "   ");
                    }
                }
                System.out.println();
            }
        }

        public static void main(String[] args) {

            int V = 4;

            // Graph matrix (INF = no direct edge)
            int[][] graph = {
                    {0,   3,   INF, 5},
                    {INF, 0,   1,   INF},
                    {INF, INF, 0,   2},
                    {INF, 4,   INF, 0}
            };

            // Floyd-Warshall chalao
            floydWarshall(graph, V);
        }
    }

