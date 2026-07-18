package HashMap;

import java.util.HashMap;

public class FrequencyCount {
    static void printFrequency(int []arr){
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int num: arr) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

                //step - 2 map.print
                for(int key : map.keySet()){
                    System.out.println(key + " -> " + map.get(key));
                }

            }





    static void main() {
        int []arr = {1,2,3,4,5,5,2,3,4,4,5,5,7};
        printFrequency(arr);
    }
}
