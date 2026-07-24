package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class PrintSubsets {

    public static void printSubsets(int [] arr,int index , List <Integer> current  ){
        if(index == arr.length){
            System.out.println(current);
            return ;
        }
        current.add(arr[index]);
        printSubsets(arr,index+1,current);
        current.remove(current.size()-1);
        printSubsets(arr,index+1,current);}

    static void main() {
        int [] arr = {1,2,3,4,5,6};
        List<Integer> current = new ArrayList<>();
        printSubsets(arr, 0, current);
        System.out.println(current);
    }
}






//import java.util.*;
//
//public class Subsets {
//
//    public static List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> result = new ArrayList<>();
//        backtrack(0, nums, new ArrayList<>(), result);
//        return result;
//    }
//
//    private static void backtrack(int start, int[] nums, List<Integer> path, List<List<Integer>> result) {
//
//        // Har step pe current path ko result mein daal do
//        result.add(new ArrayList<>(path));
//
//        // Ab aage ke elements try karo
//        for (int i = start; i < nums.length; i++) {
//
//            // Choose
//            path.add(nums[i]);
//
//            // Explore
//            backtrack(i + 1, nums, path, result);
//
//            // Unchoose (Backtrack)
//            path.remove(path.size() - 1);
//        }
//    }
//
//    public static void main(String[] args) {
//        int[] nums = {1, 2, 3};
//
//        List<List<Integer>> ans = subsets(nums);
//
//        System.out.println("All Subsets:");
//        for (List<Integer> subset : ans) {
//            System.out.println(subset);
//        }
//    }
//}
