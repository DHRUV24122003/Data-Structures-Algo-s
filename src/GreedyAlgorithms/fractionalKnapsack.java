package GreedyAlgorithms;

import java.util.Arrays;

public class fractionalKnapsack {

    static class Item {
        int value ;
        int weight;
        double ratio;

        Item(int value, int weight){
            this.value = value;
            this.weight = weight;
            this.ratio = (double)value/weight;
        }
    }

    public double FractionalKnapsack(int [] val, int [] wt, int capacity){
     int n = val.length; //total items

     //step 1 : make all the items as array
     Item [] items = new Item[n];

// Har item ko Item class ke object mein convert kar rahe hain

        for(int i = 0; i < n; i++) {
            items[i] = new Item(val[i], wt[i]);

        }

        // Step 2: Items ko ratio ke according descending order mein sort kar rahe hain
        // Matlab sabse zyada profitable item pehle aayega
        Arrays.sort(items,(a,b) -> Double.compare(a.ratio,b.ratio));

        double totalValue = 0.0; //final answer will be stored here
        int remainingCapacity = capacity;// bag mein kitni capacity bachi hai

        //let's pick the item one by one
        for(Item item : items) {

            //agar bag full ho gaya to break the loop
            if (remainingCapacity == 0) {
                break;
            }

            //case 1 ; poora item bag me aa raha hai
            if (item.weight <= remainingCapacity) {
                totalValue += item.ratio;     //poori value add kardo
                remainingCapacity -= item.weight;   //capacity kam kar do
            }

            // Case 2: Poora item nahi aa raha, isliye fraction lena padega
            else {
                // jitni capacity bachi hai utna hissa le lo
                totalValue += item.ratio * remainingCapacity;
                remainingCapacity = 0;                  // ab bag full ho gaya
            }
        }

        // Answer ko 6 decimal places tak round karke return kar rahe hain
        return Math.round(totalValue * 1e6) / 1e6;



        }

    public static void main(String[] args) {

        fractionalKnapsack sol = new fractionalKnapsack();

        // Example 1
        int[] val = {60, 100, 120};
        int[] wt  = {10, 20, 30};
        int capacity = 50;

        double result = sol.FractionalKnapsack(val, wt, capacity);

        System.out.println("Maximum value in Knapsack = " + result);
        // Output: 240.000000
    }
        }






