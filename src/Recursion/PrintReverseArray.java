package Recursion;

public class PrintReverseArray {
    static void reverse(int[] arr, int start, int end) {
        if(start>=end){
            return ;
        }
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;

        reverse(arr, start+1, end-1);

    }

    static void main() {
        int[] arr = {1, 2, 3, 4, 5, 6,17,9};

        System.out.print("Original Array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        reverse(arr, 0, arr.length - 1);//start karenge 0 se and end will be starting from end of the array

        System.out.print("\nReversed Array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}


//string reverse
//public class ReverseString {
//
//    static String reverse(String str) {
//        // Base Case
//        if (str.length() == 0) {
//            return str;
//        }
//
//        // Recursive Case
//        // last character + reverse of remaining string
//        return reverse(str.substring(1)) + str.charAt(0);
//    }
//
//    public static void main(String[] args) {
//        String str = "hello";
//        String ans = reverse(str);
//        System.out.println("Reversed String: " + ans);
//    }
//}

