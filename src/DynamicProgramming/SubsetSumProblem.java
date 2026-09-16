package DynamicProgramming;



public class SubsetSumProblem {
    public static boolean solve(int[] arr, int index, int target) {
        if (target == 0) {
            return true;
        }
        if (index == arr.length) {
            return false;
        }
        //not take
        boolean notTake = solve(arr, index + 1, target);

        boolean Take = false;
        if (arr[index] <= target) {
            Take = solve(arr, index + 1, target - arr[index]);


    }
    return Take||notTake;
}

    //let's check for the sum first
    static boolean equalPartition(int [] arr){
        int totalSum = 0;

        for(int num : arr){
            totalSum += num;
        }

        if(totalSum % 2 != 0){
            return false;
        }
        int target = totalSum / 2;



        return solve(arr, 0, target);
    }

     static void main(String[] args) {

        int[] arr = {1, 5, 11, 5,9,7,1};

        boolean answer = equalPartition(arr);

        System.out.println(answer);
    }

}
