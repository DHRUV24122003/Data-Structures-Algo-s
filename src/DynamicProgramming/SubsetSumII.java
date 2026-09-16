package DynamicProgramming;

import java.util.*;

public class SubsetSumII {

    static boolean findSubset(int[] arr, int index, int target,
                              List<Integer> subset1) {

        // Target achieved
        if (target == 0) {
            return true;
        }

        // No elements left
        if (index == arr.length) {
            return false;
        }

        // -------------------------
        // TAKE current element
        // -------------------------
        if (arr[index] <= target) {

            subset1.add(arr[index]);

            if (findSubset(arr, index + 1,
                    target - arr[index], subset1)) {
                return true;
            }

            // Backtracking:
            // this element did not lead to solution
            subset1.remove(subset1.size() - 1);
        }

        // -------------------------
        // NOT TAKE current element
        // -------------------------
        if (findSubset(arr, index + 1, target, subset1)) {
            return true;
        }

        return false;
    }


    public static void main(String[] args) {

        int[] arr = {1, 5, 11, 5,9,7};

        int totalSum = 0;

        for (int num : arr) {
            totalSum += num;
        }

        // Equal partition impossible
        if (totalSum % 2 != 0) {
            System.out.println("Equal partition not possible");
            return;
        }

        int target = totalSum / 2;

        List<Integer> subset1 = new ArrayList<>();

        boolean possible =
                findSubset(arr, 0, target, subset1);

        if (!possible) {
            System.out.println("Equal partition not possible");
            return;
        }

        // Build second subset
        List<Integer> subset2 = new ArrayList<>();

        // Copy subset1 because duplicate values can exist
        List<Integer> temp = new ArrayList<>(subset1);

        for (int num : arr) {

            if (temp.contains(num)) {
                temp.remove(Integer.valueOf(num));
            } else {
                subset2.add(num);
            }
        }

        System.out.println("Subset 1: " + subset1);
        System.out.println("Subset 2: " + subset2);
    }
}