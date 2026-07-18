package HashMap;

import java.util.HashMap;

public class TwoSumInHashMap {
    //THERE IS A TARGET  , so find such two numbers whose
    //is equal to the target and return their index;
    static int[] twoSum(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) { //traverse the array
            int num = arr[i];//assign the num equals to array element
            int complement = target - num;//set a complement

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(num,i);
        }
        return new int[]{};

    }

    static void main() {
        int[] arr = {2, 7, 11, 15};//declare an array
        int target = 17;//setting up a target
        int[] result = twoSum(arr, target);
        System.out.println(("["+ result[0] + "," + result[1] +"]"));
    }
}
