package GreedyAlgorithms;

public class MaxStocks {

        public static int solve(int day, int money, int[] price) {

            // All days processed
            if (day == price.length)
                return 0;

            int ans = 0;

            // Try buying 0 to (day + 1) stocks
            for (int buy = 0; buy <= day + 1; buy++) {

                int cost = buy * price[day];

                if (cost <= money) {
                    ans = Math.max(ans, buy +
                            solve(day + 1, money - cost, price));
                }
            }

            return ans;
        }

        public static int buyMaximumProducts(int k, int[] price) {
            return solve(0, k, price);
        }

        public static void main(String[] args) {

            int[] price = {10, 7, 19};
            int k = 45;
            int maxStocks = buyMaximumProducts(k, price);
            System.out.println("the maximum stock can be bought = " + maxStocks);
        }
    }

