package Recursion;

public class ArrayIsSorted {
    static boolean isSorted(int[] arr, int index) {
        // Base Case: last element tak pahunch gaye → sorted hai
        if (index == arr.length - 1) {
            return true;
        }

        // Agar current element next se bada hai → not sorted
        if (arr[index] > arr[index + 1]) {
            return false;
        }

        // Baaki array check karo
        return isSorted(arr, index + 1);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        System.out.println(isSorted(arr, 0));
    }

}
