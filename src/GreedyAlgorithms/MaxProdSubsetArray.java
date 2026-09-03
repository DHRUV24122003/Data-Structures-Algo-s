package GreedyAlgorithms;

public class MaxProdSubsetArray {

    public int findMaxProd(int [] arr) {
        int n = arr.length;
        long mod = 1000000007; //modulo value


        if (n == 1) {
            return arr[0];
        }

        long product = 1;
        int negativeCount = 0;
        int zeroCount = 0;
        int maxNegative = Integer.MIN_VALUE; //THE BIGGEST NEGATIVE NUM

        for(int num : arr) {

            //if number is 0
            if (num == 0) {
                zeroCount++; //zero count increase
                continue;  //skip next calculations
            }

            //if number is negative
            if (num < 0) {
                negativeCount++;
                maxNegative = Math.max(maxNegative, num); //update biggest negative

            }

            product = (product * num) % mod;

            //if product is negative make it positive

            if (product < 0) {
                product += mod;
            }
        }

        //if all the elements are 0
        if(zeroCount == n){
            return 0;
        }

        //only 1 negative and rest are 0
        if(negativeCount ==1 && (zeroCount + negativeCount== n)){
            return 0;
        }

        //if negative numbers count is odd
        //then remove the biggest -ve (close to 0)

        if(negativeCount %2 == 1){
            product = (product / maxNegative) % mod;

            //again negative check


            if(product < 0){

                product += mod;
            }
        }

        //final product return
        return (int)product;
    }

    public static void main(String[] args) {

        MaxProdSubsetArray sol = new MaxProdSubsetArray();

        int[] arr = {-1, -1, -2, 4, 3};

        int result = sol.findMaxProd(arr);

        System.out.println("Maximum Product = " + result);  // Output: 24
    }
}
