package GreedyAlgorithms;

import java.util.*;
public class MaxSumArri_i {

    public static int maximizeSum(int[] arr){
        Arrays.sort(arr);

        long mod = 1000000007L;

        //Initialize totalsum as 64-bit long to safely hold running sums

        long totalSum = 0;

        for(int i = 0; i < arr.length; i++){
            long term = (long) arr[i] *i;

            totalSum = (totalSum + term) % mod;
        }

        return (int)totalSum;
    }

    public static void main(String[] args) {
        // Sample input array
        int[] arr = {5, 3, 2, 4, 1};

        // Call the function and store the result
        int result = maximizeSum(arr);

        // Print the output result to the console
        System.out.println("Maximum sum: " + result);
    }
}


