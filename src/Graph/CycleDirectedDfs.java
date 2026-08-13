package Graph;

import java.util.*;
public class CycleDirectedDfs {

    //first of all make a function which checks visited or not
    static boolean visitingNodes(int node , List<List<Integer>> graph, int []color,List<Integer> path) {
        // 0 → Not Visited
        // 1 → Visiting (Gray)
        // 2 → Visited (Black)

        //first of all mark the element as 1;
        color[node] = 1; //visiting (gray)
        path.add(node); //current path me add karo
        for(int neighbour : graph.get(node)) {
            if(color[neighbour] == 1) { //  cycle  found
               printCycle(path,neighbour);
                return true;
            }
            if(color[neighbour] == 0) { //start with all the neighbours that are not visited yet
                if(visitingNodes(neighbour, graph, color,path)){ //call the function and if found return true
                    return true;
                };
            }
            // If color[neighbour] == 2 (Black), ignore (already processed)
        }
        path.remove(path.size() - 1);
        color[node] = 2; //hence mark all the nodes as visited ,black
        return false;
    }
    //to print the cycle make a function

    static void printCycle(List<Integer> path, int cycleStart){
        System.out.print("cycle nodes : ");


    boolean startPrinting = false ;
    for(int node : path){
        if (node == cycleStart) {
            startPrinting = true;
        }
        if (startPrinting) {
            System.out.print(node + " ");
        }
    }
        System.out.print(cycleStart);  // cycle close
        System.out.println();
}

    static boolean hasCycle(int V, List<List<Integer>> graph) {
        int [] color = new int[V];
        List<Integer> path = new ArrayList<>();
        for(int i = 0; i < V; i++) { // run a loop for all the nodes
            if(color[i] == 0){ // for all the nodes that are not visited
                if(visitingNodes(i,graph,color,path)){ //if cycle found return true
                    return true;
                }

            }

        }
        return false; //else return false no cycle found


    }



public static void main(String[] args) {
        int V = 4;

        // Create graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // -------- Example 1: Cycle hai (1 → 2 → 3 → 1) --------
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
