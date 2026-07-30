package BackTracking;
import java.util.*;



public class CombinationalSum {


    public List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);  // sort to generate combinations in non-decreasing order
        backtrack(arr, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] arr, int remaining, int start,
                           List<Integer> path, List<List<Integer>> result) {
        if (remaining == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < arr.length; i++) {
            if (arr[i] > remaining) break;  // pruning

            path.add(arr[i]);
            // reuse allowed → pass same index i
            backtrack(arr, remaining - arr[i], i, path, result);
            path.remove(path.size() - 1);  // backtrack
        }
    }



        public static void main(String[] args) {
            CombinationalSum sol = new CombinationalSum();

            // Example 1
            int[] arr1 = {1, 2, 3};
            int target1 = 5;
            List<List<Integer>> result1 = sol.combinationSum(arr1, target1);
            System.out.println("Input: arr = [1, 2, 3], target = 5");
            System.out.println("Output: " + result1);
            System.out.println();

            // Example 2
            int[] arr2 = {2, 4};
            int target2 = 1;
            List<List<Integer>> result2 = sol.combinationSum(arr2, target2);
            System.out.println("Input: arr = [2, 4], target = 1");
            System.out.println("Output: " + result2);
            System.out.println();

            // Extra test case
            int[] arr3 = {2, 3, 6, 7};
            int target3 = 7;
            List<List<Integer>> result3 = sol.combinationSum(arr3, target3);
            System.out.println("Input: arr = [2, 3, 6, 7], target = 7");
            System.out.println("Output: " + result3);
        }
    }


