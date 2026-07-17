package Recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintSubsets {
    static void printSubsets(int[] arr, int index, List<Integer> current){
        if (index ==arr.length){
            System.out.println(current);
            return ;
        }
        // 1. Current element ko lo (Include)
        current.add(arr[index]);
        printSubsets(arr, index+1, current);

        // Backtrack (element ko hatao)
        current.remove(current.size()-1);

        // 2. Current element ko mat lo (Exclude)
        printSubsets(arr, index+1, current);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3,4};
        List<Integer> current = new ArrayList<>();
        printSubsets(arr, 0, current);
    }
}
