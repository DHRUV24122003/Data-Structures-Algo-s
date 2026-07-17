package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    static void permute(int []arr, List<Integer> current, boolean [] used) {
        if (current.size() == arr.length) {
            System.out.println(current);
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (used[i] == true) {
                continue;
            }
            used[i] = true;
            current.add(arr[i]);
            permute(arr, current, used);
            current.remove(current.size() - 1);
            used[i] = false;

        }
    }

        public static void main(String[] args) {
            int[] arr = {1, 2, 3,4};

            List<Integer> current = new ArrayList<>();  // abhi tak bani hui permutation
            boolean[] used = new boolean[arr.length];   // kaunsa element use ho chuka hai, track karne ke liye

            System.out.println("All Permutations:");
            permute(arr, current, used);
        }
    }

