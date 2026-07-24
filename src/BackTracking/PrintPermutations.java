package BackTracking;

import java.util.ArrayList;
import java.util.List;



public class PrintPermutations {
    public static void printPermutations(int [] arr, List<Integer> current,boolean[]used ){
        if (current.size() == arr.length) {
            System.out.println(current);
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (used[i]) continue;//if the element has already been used then skip to the next iteration
            used[i] = true;   //if it is avalable
            current.add(arr[i]);
            printPermutations(arr, current, used);
            current.remove(current.size() - 1);//remove backtrack
            used[i] = false;

        }
    }
    public static void main() {
        int [] arr = {1,2,3};
        List<Integer> current = new ArrayList<>();
        boolean [] used = new boolean[arr.length];
            printPermutations(arr, current, used);
    }

}
