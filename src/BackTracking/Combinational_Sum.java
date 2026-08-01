package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combinational_Sum {
    public List<List<Integer>>  combinationSum(int[] arr, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);//sort the array
        solve(0, target, arr, new ArrayList<>(), ans);
        return ans;

    }
    private void solve(int index, int target, int[]arr,List<Integer>path, List<List<Integer>> ans){
        //Base case
        if(target == 0){
            ans.add(new ArrayList<>(path));
            return;
        }
        if(index == arr.length || target < 0){
            return;
        }
        //option 1: take the current element
        if(arr[index] <= target){
            path.add(arr[index]);
            solve(index, target-arr[index],arr,path,ans);
            path.remove(path.size()-1);//backtrack

        }
        solve(index+1,target,arr,path,ans);
    }

        public static void main(String[] args) {
            Combinational_Sum sol = new Combinational_Sum();

            int[] arr = {1, 2, 3,6,11,7};
            int target = 11;

            List<List<Integer>> result = sol.combinationSum(arr, target);
            System.out.println(result);
        }
    }



