package GreedyAlgorithms;

import java.util.*;
public class MaxSumKNegations {
    public  int maxSumKNegations(int[] arr, int k) {

        Arrays.sort(arr);
        int n = arr.length;

        for(int i = 0; i < n && k>0 ; i++){

            //if current number is negative

            if(arr[i] < 0){
                arr[i] = -arr[i];
                k--;

            } else{
                break;
            }
        }
        if(k > 0) {
           Arrays.sort(arr);
        }

        if(k%2 ==1){
            arr[0] = -arr[0];
        }

        int sum = 0;
        for (int num : arr) {
            sum += num;
        }

        return sum;
    }
    static void main(String[] args) {

       MaxSumKNegations sol = new MaxSumKNegations();

        int[] arr = {1, 2, -3, 4, 5};
        int k = 1;

        int result = sol.maxSumKNegations(arr, k);

        System.out.println("Maximum Sum after K negations = " + result);
        // Output: 15
    }
}
