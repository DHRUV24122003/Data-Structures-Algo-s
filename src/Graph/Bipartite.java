package Graph;
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

public class Bipartite {
    //first of all we will run a bfs to check each neigbour ios colored or not
    public static boolean bfs(int start, int [][] graph, int [] color) {
        Queue<Integer> queue = new LinkedList<Integer>(); // make a queue
        queue.add(start); //add the start to the queue
        color[start] = 0; //give it color 0

        while(!queue.isEmpty()){ //until the queue is not empty
            int node = queue.poll(); // pick the first node from the queue

            for (int neighbour : graph[node]) { //check for all the neihbours  of the graph
                if(color[neighbour] == -1){ //if a node is uncoloured
                    color[neighbour] = 1-color[node]; //give it the opposite color to the current node
                    queue.add(neighbour); //add it to the queue
                }
                //if neighbour is already colored
                else if(color[neighbour] == color[node]){
                    return false; //as there is a conflict

                }
            }
        }

        return true;//no conflict in the graph

    }

    public boolean isBipartite(int [][] graph){
        int n = graph.length;
        int [] color = new int[n];
        //give no color to all the nodes of the graph
        Arrays.fill(color, -1); //initialize all the nodes with no color
        for(int i = 0; i < n; i++){ // for all the nodes of the graph
            if(color[i] == -1){ //if any node is uncoloured
                if(!bfs(i, graph, color)){ //if this function is not applicable to that node
                    return false; //return false
                }
            }
        }
        return true;//else return true

    }




    public static void main(String[] args) {
        Bipartite obj = new Bipartite();

        // Example 1: Bipartite hai
        int[][] graph1 = {
                {1, 3},
                {0, 2},
                {1, 3},
                {0, 2}
        };
        System.out.println("Graph 1 is Bipartite : " + obj.isBipartite(graph1));
        System.out.println();

        // Example 2: Bipartite nahi hai (odd cycle)
        int[][] graph2 = {
                {1, 2, 3},
                {0, 2},
                {0, 1, 3},
                {0, 2}
        };
        System.out.print("Graph 2 is Bipartite :  " + obj.isBipartite(graph2));
    }

}
