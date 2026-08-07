package Graphs.prerequisites;

import java.util.*;

public class bfs {
    public static void BFS(int start, boolean[] visited, List<List<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        // Starting node ko queue mein daalo + visited mark karo
        q.add(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            int node = q.poll();   //queue se nikalo
            System.out.println(node + " ");

            //uske saare unvisited neigbours ko queue me daalo
            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.add(neighbor);
                }
            }
        }
    }
            public static void main (String []args){
                int V = 5;  // vertices 0 to 4

                List<List<Integer>> adj = new ArrayList<>();
                for (int i = 0; i < V; i++) {
                    adj.add(new ArrayList<>());
                }

                // Graph bana rahe hain
                adj.get(0).add(1);
                adj.get(1).add(0);

                adj.get(0).add(2);
                adj.get(2).add(0);

                adj.get(1).add(3);
                adj.get(3).add(1);

                adj.get(2).add(4);
                adj.get(4).add(2);

                boolean[] visited = new boolean[V];

                System.out.print("BFS Traversal: ");
                BFS(0, visited, adj);


            }
        }


