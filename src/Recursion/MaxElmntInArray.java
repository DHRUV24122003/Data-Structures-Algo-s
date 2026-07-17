package Recursion;

public class MaxElmntInArray {
    static int findMax(int [] arr, int index){
        if (index == arr.length-1){
            return arr[index];
        }

        int MaxElement =  findMax(arr, index+1);
        return Math.max(arr[index],MaxElement );
    }

    static void main() {
        int [] arr = {11,2,3,4,5};
        System.out.println("the maximum element is "+ findMax(arr, 0));
    }


}


//if we have to find the min
//static int findMin(int[] arr, int index) {
//    // Base Case
//    if (index == arr.length - 1) {
//        return arr[index];
//    }
//
//    // Recursive Case
//    int minInRest = findMin(arr, index + 1);
//    return Math.min(arr[index], minInRest);
//}
