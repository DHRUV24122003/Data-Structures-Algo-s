package Recursion;

public class NumbersFrom1toN {
    //printing in descending order
    static void printNumbers(int n ) {
        if(n < 0){ //base case
            return;
        }
        //now run the recursive function
        //System.out.print( n + " "); // printing the numbers
        printNumbers(n-1); //recursive function will call itself until the base condition gets executed
        System.out.print(n + " "); // printing the numbers

    }

    static void main() {
        int n = 10;
        System.out.print("Numbers from 1 to " + n + " are : ");
        printNumbers(n);

    }

}



//printing in ascending order
//first print the numbers and then call the function
