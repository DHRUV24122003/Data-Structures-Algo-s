package Recursion;
//import java.math.BigInteger;
import java.util.Scanner;
// for numbers up to 20
public class FactorialOfNumber {
    static long Factorial(long n) {
        if (n == 0 || n == 1)

        {
            return 1;
        }
        return n * Factorial(n - 1); //simply return the function with the factorial formula

    }

    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        long n = sc.nextInt();
        long ans = Factorial(n);
        System.out.println("The factorial of " + n +" is " + ans);
    }
}


// for very long numbers

//import java.math.BigInteger;
//public class FactorialBig {
//    static BigInteger factorial(int n) {
//        // Base Case
//        if (n == 0 || n == 1) {
//            return BigInteger.ONE;
//        }
//        // Recursive Case
//        return BigInteger.valueOf(n).multiply(factorial(n - 1));
//    }
//    public static void main(String[] args) {
//        int n = 50;   // yahan 100, 200, 500 bhi try kar sakte ho
//        System.out.println(n + "! = " + factorial(n));
//    }
//}