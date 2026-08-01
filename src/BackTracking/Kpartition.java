package BackTracking;
import java.util.*;
public class Kpartition {

        public static void main(String[] args) {
            Kpartition sol = new Kpartition();

            int[] arr1 = {2, 1, 4, 5, 6};
            System.out.println(sol.isKPartitionPossible(arr1, 3)); // true

            int[] arr2 = {2, 1, 5, 5, 6};
            System.out.println(sol.isKPartitionPossible(arr2, 3)); // false
        }



        public boolean isKPartitionPossible(int[] arr, int k) {
            int n = arr.length;

            // Edge cases
            if (k == 1) return true;
            if (k > n) return false;

            int totalSum = 0;
            for (int num : arr) {
                totalSum += num;
            }

            // Agar total sum k se divisible nahi hai toh impossible
            if (totalSum % k != 0) return false;

            int target = totalSum / k;

            // Optimization: descending order mein sort karo
            Arrays.sort(arr);
            reverse(arr); // bade numbers pehle try karenge

            boolean[] visited = new boolean[n];

            return solve(0, 0, k, target, arr, visited);
        }

        private boolean solve(int start, int currentSum, int remainingSubsets,
                              int target, int[] arr, boolean[] visited) {

            // Agar saare subsets ban gaye
            if (remainingSubsets == 0) return true;

            // Ek subset complete ho gaya
            if (currentSum == target) {
                return solve(0, 0, remainingSubsets - 1, target, arr, visited);
            }

            for (int i = start; i < arr.length; i++) {

                // Already used hai toh skip
                if (visited[i]) continue;

                // Current number leke sum target se zyada ho raha hai toh skip
                if (currentSum + arr[i] > target) continue;

                // Current number lo
                visited[i] = true;

                if (solve(i + 1, currentSum + arr[i], remainingSubsets, target, arr, visited)) {
                    return true;
                }

                // Backtrack
                visited[i] = false;

                // Optimization: agar currentSum 0 hai aur yeh number nahi chala
                // toh aage bhi nahi chalega (same situation)
                if (currentSum == 0) break;
            }

            return false;
        }

        // Array ko reverse karne ke liye helper
        private void reverse(int[] arr) {
            int left = 0, right = arr.length - 1;
            while (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
    }


