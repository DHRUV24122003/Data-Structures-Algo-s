package GreedyAlgorithms;
import java.util.ArrayList;
import java.util.Arrays;

public class CandyProblem {

    //Mx and min amount to buy the candies

    public ArrayList<Integer> candyStore(int[] prices, int k) {

        //sort the prices in ascending order
        Arrays.sort(prices);
        int n = prices.length;

        //min cost

        int minCost = 0;
        int i = 0;    //left pointer
        int j = n - 1;   //right pointer

        while (i <= j) {
            //buy the cheapest candies
            minCost += prices[i];
            i++;

            j = j - k; //take the expensive candies in free
        }

        //max amount
        int maxCost = 0;
        i = n - 1;
        j = 0;
        while (j <= i) {
            maxCost += prices[i];
            i--;

            j = j + k;
        }

        //return the result

        ArrayList<Integer> result = new ArrayList<>();

        result.add(minCost);
        result.add(maxCost);
        return result;


    }



     static void main(String[] args) {

        CandyProblem sol = new CandyProblem ();

        int[] prices = {3, 2, 1, 4};
        int k = 2;

        ArrayList<Integer> ans = sol.candyStore(prices, k);

        System.out.println("Minimum Cost = " + ans.get(0));
        System.out.println("Maximum Cost = " + ans.get(1));
    }



}
