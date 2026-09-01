package GreedyAlgorithms;
import java.util.*;
public class MinCoins {
    public List<Integer> minPartition(int N){
        List<Integer> result = new ArrayList<>();
        int[] coins = {2000, 500, 200, 100, 50, 20, 10, 5, 2, 1};
        //greedy approach
        for (int coin : coins) {
            //till the time wwe are able to use current coin use it

            while(N>= coin){
                result.add(coin); //take the coin
                N = N - coin; //reduce by that amount
            }

            //if amt get 0  then stops
            if(N == 0) break;
        }

        return result;




}
    public static void main(String[] args) {

        MinCoins sol = new MinCoins();

        int amount = 43;

        List<Integer> coinsUsed = sol.minPartition(amount);

        System.out.println("Coins used: " + coinsUsed);
        System.out.println("Minimum number of coins: " + coinsUsed.size());
    }
}
