package Recursion;

public class printAllElementsOfArr {
    static void printElements(int []arr, int num ){
        if(num==arr.length){
            return  ;
        }

        System.out.print(arr[num] + " ");
        printElements(arr, num+1);


       }


    static void main() {
        int[] arr = {1,2,3,4,5,6,17,9,23};
        printElements(arr, 0);
    }
}
