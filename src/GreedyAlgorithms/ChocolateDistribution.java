package GreedyAlgorithms;

import java.util.Arrays;

public class ChocolateDistribution {

    public static int distribution(int [] arr, int m){
        int n = arr.length;
        if(m == 0 || n == 0 || n<m){
            return 0;
        }

        Arrays.sort(arr);

        int minDifference = Integer.MAX_VALUE; //assume maximum values as min difference


        // Step 2: m size ki window slide karte raho
        // i = starting index of window
        for(int i = 0; i+m-1<n; i++){


            int currentDifference = arr[i+m-1] - arr[i];
            if(currentDifference < minDifference){
                minDifference = currentDifference;
            }


        }
        return minDifference;
    }



     static void main(String[] args) {

        ChocolateDistribution sol = new ChocolateDistribution();

        int[] arr = {3, 4, 1, 9, 56};
        int m = 5;

        int result = sol.distribution(arr, m);

        System.out.println("Minimum Difference = " + result);
        // Output: 2
    }
}
