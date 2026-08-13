package Graph;


    import java.util.*;
    import java.security.Permissions;
    public class Dijkstra {

        // Yeh class ek pair banati hai → (node + uska distance)
        static class Pair {
            int node;   // Kaunsa node hai
            int dist;   // Us node tak ka distance

            // Constructor - jab naya Pair banate hain to node aur dist set ho jata hai
            Pair(int node, int dist) {
                this.node = node;
                this.dist = dist;
            }
        }

        // Main Dijkstra function
        // V = total nodes, graph = adjacency list, source = starting node
        static int[] dijkstra(int V, List<List<Pair>> graph, int source) {

            // distance array banaya - isme source se har node ka shortest distance store hoga
            int[] distance = new int[V];

            // Pehle saare distances ko infinity (sabse bada number) se bhar diya
            Arrays.fill(distance, Integer.MAX_VALUE);

            // Source se source tak ka distance 0 hota hai
            distance[source] = 0;

            // Min-Heap (Priority Queue) banaya
            // Yeh hamesha sabse chhote distance wale Pair ko pehle nikaalta hai
            PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);

            // Source ko distance 0 ke saath queue mein daal diya
            pq.add(new Pair(source, 0));

            // Jab tak queue khali nahi hoti, tab tak chalte raho
            while (!pq.isEmpty()) {

                // Queue se sabse chhote distance wala Pair nikaalo
                Pair current = pq.poll();

                int node = current.node;   // Current node ka number
                int dist = current.dist;   // Current node tak ka distance jo queue se aaya

                // Agar queue se aaya hua distance, already mile hue distance se bada hai
                // matlab yeh purana (bekaar) record hai → skip kar do
                if (dist > distance[node]) continue;

                // Ab current node ke saare neighbours ko check karo
                for (Pair neighbour : graph.get(node)) {

                    // Naya distance nikaalo = current node ka distance + edge ka weight
                    int newDist = distance[node] + neighbour.dist;

                    // Agar naya distance purane distance se chhota hai
                    if (newDist < distance[neighbour.node]) {

                        // Toh distance update kar do
                        distance[neighbour.node] = newDist;

                        // Aur is naye better distance ke saath neighbour ko queue mein daal do
                        pq.add(new Pair(neighbour.node, newDist));
                    }
                }
            }

            // Saare shortest distances return kar do
            return distance;
        }

        public static void main(String[] args) {

            int V = 5;  // Total 5 nodes hain (0 se 4)

            // Graph banane ke liye adjacency list
            List<List<Pair>> graph = new ArrayList<>();

            // Har node ke liye ek khaali list bana di
            for (int i = 0; i < V; i++) {
                graph.add(new ArrayList<>());
            }

            // Ab edges add kar rahe hain
            // Format: graph.get(from).add(new Pair(to, weight));

            graph.get(0).add(new Pair(1, 4));  // 0 → 1, weight 4
            graph.get(0).add(new Pair(2, 1));  // 0 → 2, weight 1
            graph.get(1).add(new Pair(3, 2));  // 1 → 3, weight 2
            graph.get(2).add(new Pair(3, 5));  // 2 → 3, weight 5
            graph.get(2).add(new Pair(4, 3));  // 2 → 4, weight 3
            graph.get(3).add(new Pair(4, 1));  // 3 → 4, weight 1

            // Dijkstra chalao, source = 0
            int[] result = dijkstra(V, graph, 0);

            // Result print karo
            System.out.println("Shortest distances from source 0:");
            for (int i = 0; i < V; i++) {
                System.out.println("0 → " + i + " : " + result[i]);
            }
        }
    }











//public class Dijkstra {
//    static class Edge {
//        int src;
//        int dest;
//        int wt;
//        public Edge(int s, int d, int w) {
//            this.src = s;
//            this.dest = d;
//            this.wt = w;
//        }
//    }
//    static void createGraph(ArrayList<Edge> graph[]) {
//        for(int i=0; i<graph.length; i++) {
//            graph[i] = new ArrayList<>();
//        }
//        graph[0].add(new Edge(0, 1, 2));
//        graph[0].add(new Edge(0, 2, 4));
//        graph[1].add(new Edge(1, 3, 7));
//        graph[1].add(new Edge(1, 2, 1));
//        graph[2].add(new Edge(2, 4, 3));
//        graph[3].add(new Edge(3, 5, 1));
//        graph[4].add(new Edge(4, 3, 2));
//        graph[4].add(new Edge(4, 5, 5));
//    }
//    static class Pair implements Comparable<Pair> {
//        int n;
//        int path;
//        public Pair(int n, int path) {
//            this.n = n;
//            this.path = path;
//        }
//        @Override
//        public int compareTo(Pair p2) {
//            return this.path - p2.path;
//        }
//    }
//    public static int[] dijkstra(ArrayList<Edge> graph[], int src) {
//        PriorityQueue<Pair> pq = new PriorityQueue<>();
//        int dist[] = new int[graph.length];
//        boolean vis[] = new boolean[graph.length];
//        for(int i=0; i<dist.length; i++) {
//            if(i != src) {
//                dist[i] = Integer.MAX_VALUE;
//            }
//        }
//        pq.add(new Pair(src, 0));
//        while(!pq.isEmpty()) {
//            Pair curr = pq.remove();
//            if(!vis[curr.n]) {
//                vis[curr.n] = true;
//                for(int i=0; i<graph[curr.n].size(); i++) {
//                    Edge e = graph[curr.n].get(i);
//                    int u = e.src;
//                    int v = e.dest;
//                    if(!vis[v] && dist[u]+e.wt < dist[v]) {
//                        dist[v] = dist[u] + e.wt;
//                        pq.add(new Pair(v, dist[v]));
//                    }
//                }
//            }
//        }
//        return dist;
//    }
//    public static void main(String args[]) {
//        int V = 6;
//        ArrayList<Edge> graph[] = new ArrayList[V];
//        createGraph(graph);
//        int src = 0;
//        int dist[] = dijkstra(graph, src);
//        for(int i=0; i<dist.length; i++) {
//            System.out.println(dist[i]+" ");
//        }
//    }
//}