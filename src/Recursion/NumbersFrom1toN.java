package Recursion;

public class NumbersFrom1toN {
    static void printNumbers(int n ) {
        if(n < 0){ //base case
            return;
        }
        //now run the recursive function
        printNumbers(n-1);
        System.out.print(n + " ");
    }

    static void main() {
        int n = 10;
        System.out.print("Numbers from 1 to " + n + " are : ");
        printNumbers(n);
    }

}
