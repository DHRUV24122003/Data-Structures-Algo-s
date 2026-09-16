package DynamicProgramming;

public class UnboundedKnapsack {

    public static int solve(int index, int capacity,
                            int[] wt, int[] val) {
        if(index == wt.length || capacity == 0) {
            return 0;
        }

        int NotTake = solve(index + 1, capacity, wt, val);

        int Take = 0;
        if(wt[index] <= capacity) {
            Take = val[index]+solve(index , capacity-wt[index], wt, val);//only index will be the same
        }

        return Math.max(NotTake, Take);

    }


    static void main() {
        int [] val = {5, 2, 3};
        int [] wt = {4, 5, 1};
        int W = 4;
        int answer = solve(0, W, val, wt);
        System.out.println(answer);
    }
}
