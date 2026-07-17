package Recursion;

import java.util.Scanner;

public class SumOfNFibonacciNumbers {
    static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if(n==1){
            return 1;
        }
        return fib(n-1)+fib(n-2);
    }

    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int n = sc.nextInt();
        int ans = fib(n);
        System.out.println("the sum of the series is " + ans);
    }
}
