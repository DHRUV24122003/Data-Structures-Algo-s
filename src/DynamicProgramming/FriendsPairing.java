package DynamicProgramming;

public class FriendsPairing {

    public static long countWays(int n) {

        // Base cases
        if (n <= 2) {
            return n;
        }

        // dp[i] = i friends ko arrange karne ke total ways
        long[] dp = new long[n + 1];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {

            // Case 1:
            // Current friend single rahe
            long single = dp[i - 1];

            // Case 2:
            // Current friend kisi ek friend ke saath pair kare
            // uske paas (i - 1) choices hain
            long pair = (i - 1) * dp[i - 2];

            dp[i] = single + pair;
        }

        return dp[n];
    }

    public static void main(String[] args) {

        int n = 4;

        System.out.println(countWays(n));
    }
}