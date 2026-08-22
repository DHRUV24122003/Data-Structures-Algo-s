package Graph;

import java.util.*;

public class CycleDirectedDfs {

    // DFS function to detect cycle
    static boolean dfs(int node, List<List<Integer>> graph, int[] color, List<Integer> path) {
        // 0 → Not Visited
        // 1 → Visiting (Gray)
        // 2 → Visited (Black)

        color[node] = 1;          // Mark as Visiting
        path.add(node);           // Add to current path

        for (int neighbour : graph.get(node)) {
            if (color[neighbour] == 1) {
                // Cycle found
                printCycle(path, neighbour);
                return true;
            }

            if (color[neighbour] == 0) {
                if (dfs(neighbour, graph, color, path)) {
                    return true;
                }
            }
            // If color == 2 → already processed, ignore
        }

        // Backtrack
        path.remove(path.size() - 1);
        color[node] = 2;          // Mark as Visited
        return false;
    }

    // Function to print the cycle
    static void printCycle(List<Integer> path, int cycleStart) {
        System.out.print("Cycle nodes: ");

        boolean startPrinting = false;
        for (int node : path) {
            if (node == cycleStart) {
                startPrinting = true;
            }
            if (startPrinting) {
                System.out.print(node + " → ");
            }
        }
        System.out.print(cycleStart);  // cycle close
        System.out.println();
    }

    // Main function to check cycle in the whole graph
    static boolean hasCycle(int V, List<List<Integer>> graph) {
        int[] color = new int[V];
        List<Integer> path = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (color[i] == 0) {
                if (dfs(i, graph, color, path)) {
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

        // Example: Cycle hai (1 → 2 → 3 → 1)
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

//algorithm
//In the first function start with intializing node as 1 means visiting
//check for all of the neigbours in the graph nodes if any one is found as 1 then means it has already been visited and cycle detected so return true;
//now in the same loop check for all the unvisited nodes if there is a cycle by calling the function and return true else false


//has cycle function
//make an array of colors having no of vertices
//run a loop till no of vertices
//if color of unvisited node is 0 call the function if cycle is found return true
