package DynamicProgramming;
import java.util.*;
public class MaxProfit {


        static int solve(int[] prices,
                         int index,
                         int buy,
                         int transactionsLeft,
                         int[][][] dp) {

            if (index == prices.length) {
                return 0;
            }


            // K transactions complete ho chuki hain
            if (transactionsLeft == 0) {
                return 0;
            }


            if (dp[index][buy][transactionsLeft] != -1) {
                return dp[index][buy][transactionsLeft];
            }



            if (buy == 1) {





                //
                // Transaction abhi complete nahi hui,
                // isliye transactionsLeft same rahega.
                int buyStock =
                        -prices[index]
                                + solve(
                                prices,
                                index + 1,
                                0,
                                transactionsLeft,
                                dp
                        );


                // OPTION 2:
                // Aaj stock mat kharido.
                // Next day par chale jao.
                int skip =
                        solve(
                                prices,
                                index + 1,
                                1,
                                transactionsLeft,
                                dp
                        );


                // Maximum profit choose karo
                dp[index][buy][transactionsLeft] =
                        Math.max(buyStock, skip);
            }


            // CASE 2:
            // buy == 0
            // Matlab hum already stock hold kar rahe hain
            else {

                // OPTION 1:
                // Stock SELL karo.
                //
                // Sell karne par paise milenge,
                // isliye price ADD hoga.
                //
                // Sell ke baad dobara BUY kar sakte hain
                // therefore buy = 1.
                //
                // BUY + SELL complete hua,
                // therefore ek transaction complete:
                // transactionsLeft - 1
                int sellStock =
                        prices[index]
                                + solve(
                                prices,
                                index + 1,
                                1,
                                transactionsLeft - 1,
                                dp
                        );


                // OPTION 2:
                // Aaj sell nahi karna.
                // Stock HOLD karo.
                //
                // Next day chale jao,
                // buy = 0 hi rahega.
                int hold =
                        solve(
                                prices,
                                index + 1,
                                0,
                                transactionsLeft,
                                dp
                        );


                // Maximum profit choose karo
                dp[index][buy][transactionsLeft] =
                        Math.max(sellStock, hold);
            }


            // Current state ka maximum profit return karo
            return dp[index][buy][transactionsLeft];
        }


        static int maxProfit(int[] prices, int k) {

            int n = prices.length;







            // transactionsLeft -> kitni transactions remaining hain
            int[][][] dp = new int[n][2][k + 1];


            // -1 means state abhi calculate nahi hui
            for (int i = 0; i < n; i++) {

                for (int j = 0; j < 2; j++) {

                    Arrays.fill(dp[i][j], -1);
                }
            }


            // Day 0 se start
            // buy = 1 because initially koi stock nahi hai
            // k transactions available hain
            return solve(
                    prices,
                    0,
                    1,
                    k,
                    dp
            );
        }


        public static void main(String[] args) {

            int[] prices = {
                    10, 22, 5, 75, 65, 80
            };

            int k = 2;

            int answer = maxProfit(prices, k);

            System.out.println(
                    "Maximum Profit = " + answer
            );
        }
    }

