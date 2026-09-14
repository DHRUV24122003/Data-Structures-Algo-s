package DynamicProgramming;

public class CoinChangeProblem {
    static int coinChange(int[] coins, int sum) {
        int[] dp = new int[sum + 1];
        dp[0] = 1; //ka matlab "0 banane ka ek way hai — koi coin mat lo."
        for(int coin : coins){
            for(int amount = coin; amount <= sum; amount++){
                dp[amount] = dp[amount] + dp[amount-coin];

            }

        }
        return dp[sum];
    }
    public static void main(String[] args) {
        int[] coins = {1, 2, 3};

        int sum = 8;
        System.out.println(coinChange(coins, sum));
    }
}
