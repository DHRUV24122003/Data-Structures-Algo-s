package DynamicProgramming;

public class Knapsack {

    public static int solve(int index, int capacity, int[] val, int[] wt) {
        //base case

        if (index == val.length || capacity == 0) {
            return 0;
        }

        //option 1 : don't take the current item

        int notTake = solve(index + 1, capacity, val, wt);

        //option 2 : take the current item
        int Take = 0;
        if (wt[index] <= capacity) {
            Take = val[index]
                    + solve(index + 1,
                    capacity - wt[index],
                    val,
                    wt);
        }

        return Math.max(Take, notTake);
    }


    static void main() {
        int [] val = {5, 2, 3};
        int [] wt = {4, 5, 1};
        int W = 4;
        int answer = solve(0, W, val, wt);

        System.out.println("Maximum value = " + answer);
    }

}

