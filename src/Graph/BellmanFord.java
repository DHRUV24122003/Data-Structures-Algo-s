package Graph;
import java.util.*;
public class BellmanFord {

    //edge class having source, destination and weight
    static class Edge {
        int from;
        int to;
        int weight;

        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    //bellman-ford function
    //return karega distance array
    //agar negative cycle mila toh null return karega

    static int [] bellmanFord(int V, List<Edge> edges, int source){

        // make a distance array
        int [] distance = new int [V];

        //first fill all the distances with infinity
        Arrays.fill(distance,Integer.MAX_VALUE);

        //set the distance of source as 0;
        distance[source] = 0;

        // ========== Step 1: (V-1) baar saari edges ko relax karo ==========
        for(int i = 1; i <= V; i++) {
            for (Edge edge : edges) {
                int u = edge.from;
                int v = edge.to;
                int wt = edge.weight;

                //agar u tak pahunch sakte hai aur naya distance better hai
                if (distance[u] != Integer.MAX_VALUE && distance[u] + wt < distance[v]) {
                    distance[v] = distance[u] + wt;
                }
            }
        }

            //step-2 negative cycle check (Vth time)
            for (Edge edge : edges){
                int u = edge.from;
                int v = edge.to;
                int wt = edge.weight;

                //agar ab bhi koi distance update ho raha hai
                //matlab negative cycle hai

                if(distance[u] != Integer.MAX_VALUE && distance[u] + wt < distance[v]){
                    System.out.println("negative weight cycle detected");
                    return null;

                }
            }

            //now if we are here means there is no cycle
            return distance;
        }
        public static void main(String[] args) {

            int V = 4;          // total nodes (0 to 3)
            int source = 0;

            // saari edges ki list
            List<Edge> edges = new ArrayList<>();

            // edges add kar rahe hain (jo example mein the)
            edges.add(new Edge(0, 1, 4));
            edges.add(new Edge(0, 2, 5));
            edges.add(new Edge(1, 2, -3));
            edges.add(new Edge(1, 3, 2));
            edges.add(new Edge(2, 3, 4));

            // Bellman-Ford chalao
            int[] result = bellmanFord(V, edges, source);

            // result print karo
            if (result != null) {
                System.out.println("Shortest distances from source " + source + ":");
                for (int i = 0; i < V; i++) {
                    if (result[i] == Integer.MAX_VALUE) {
                        System.out.println(source + " → " + i + " : Infinity");
                    } else {
                        System.out.println(source + " → " + i + " : " + result[i]);
                    }
                }
            }
        }

    }



