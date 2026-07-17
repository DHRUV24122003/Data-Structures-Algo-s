package Recursion;

import java.util.Scanner;

public class SumOfAllArrayElements {
     public static int ArrSum(int[] arr, int n) {
         if(n==0){
             return 0;
         }

          return arr[n - 1] + ArrSum(arr, n - 1);
     }

    public static void main() {
        int [] arr = {2,4,5,7,8,9,10};
        int sum = ArrSum(arr, arr.length);
        System.out.println(sum);  // Output: 15
    }
}
