package ArrayList;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicates {
    static List<Integer> removeDuplicates(int [] arr) {
        List<Integer> result = new ArrayList<>();
        for(int num : arr){
            if(!result.contains(num)){
                result.add(num);

            }
        }
        return result;
    }

    static void main() {
        int [] arr = {1,2,3,4,5,5,55,5,2,55,5,};
        List<Integer> uniqueList = removeDuplicates(arr);
        System.out.println(uniqueList);
    }
}
