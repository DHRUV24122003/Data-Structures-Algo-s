package GreedyAlgorithms;

import java.util.Arrays;

public class MinPlatforms {

    public int findPlatform(int []arr, int[] dep){
        int n = arr.length; // means no of arrivals or nu of trains

        //sort arrival and departure times

        Arrays.sort(arr);
        Arrays.sort(dep);

        //initialize platforms and maxplatforms
        int platforms = 1;
        int maxPlatform = 1;
        int i = 1;// no of arrivals
        int j = 0; // departures

        while(i<n && j<n){
            if(arr[i]<=dep[j]){
                platforms++;
                i++;
            }
            else{
                platforms--;
                j++;
            }
            maxPlatform = Math.max(maxPlatform,platforms);
        }
        return maxPlatform;
    }





    public static void main(String[] args) {

       MinPlatforms sol = new MinPlatforms();

        int[] arr = {900, 940, 950, 1100, 1500, 1800};
        int[] dep = {910, 1200, 1120, 1130, 1900, 2000};

        int result = sol.findPlatform(arr, dep);

        System.out.println("Minimum Platforms Required = " + result);
        // Output: 3
    }


}
