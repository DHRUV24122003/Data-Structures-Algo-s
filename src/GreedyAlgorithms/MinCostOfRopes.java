package GreedyAlgorithms;

import java.util.*;
public class MinCostOfRopes {

    public int minCostRopes(int[] arr) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int rope : arr){
            minHeap.add(rope);
        }

        int totalCost = 0; //initialize it as 0

        //till the time minHeap is having a rope
        while(minHeap.size() > 1){

            int first = minHeap.poll(); //find first smallest rope
            int second = minHeap.poll(); //find second smallest rope

            int cost  = first + second;
            totalCost += cost; //update the total cost


            minHeap.add(cost); //add the cost to the minheap
        }

        return totalCost;



    }


    public static void main(String[] args) {

        MinCostOfRopes sol = new MinCostOfRopes();

        int[] arr = {10};

        int result = sol.minCostRopes(arr);

        System.out.println("Minimum Cost = " + result);
        // Output: 29
    }
}
