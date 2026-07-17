package Recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    static void findCombinations(int []arr, int target, int index, List<Integer> current ){
        if(target == 0){
            System.out.println(current);
            return;
        }
        if(target < 0 || index  ==arr.length){
            return;
        }
        current.add(arr[index]);
        findCombinations(arr, target-arr[index], index,current);

        current.remove(current.size()-1);
        findCombinations(arr, target,index+1,current);
    }
    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 7};
        int target = 7;

        List<Integer> current = new ArrayList<>();
        System.out.println("Combinations that sum to " + target + ":");
        findCombinations(arr, target, 0, current);
    }

}
