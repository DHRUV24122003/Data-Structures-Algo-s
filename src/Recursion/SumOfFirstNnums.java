package Recursion;

public class SumOfFirstNnums {
    static int sum(int n) {
        if (n == 0) {
            return 0;
        }
        return n + sum(n - 1);
    }

    public static void main() {
        int n = 7834;
        int ans = sum(n);
        System.out.println(" the sum of first " + n + " numbers is " +ans);
    }
}
