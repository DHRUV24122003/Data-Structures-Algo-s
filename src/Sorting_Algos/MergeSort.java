package Sorting_Algos;



public class MergeSort {
    static void mergeSort(int [] arr) {
        if(arr.length<2)
            return;
        int mid = arr.length/2;
        int[] left= java.util.Arrays.copyOfRange(arr,0,mid);
        int[] right = java.util.Arrays.copyOfRange(arr, mid, arr.length);
        mergeSort(left);
        mergeSort(right);
        merge   (arr,left,right);

    }

    static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j=0,k=0;
        while(i < left.length && j<right.length){
            if(left[i] <= right[j]){
                arr[k++] = left[i++];


            } else {
                arr[k++] = right[j++];
            }
        }
        while(i<left.length) arr[k++] = left[i++];
        while(j<right.length) arr[k++] = right[j++];

    }

    static void main() {
        int[] arr= {34,54,98,28,47,54,23,91};
        mergeSort(arr);
        System.out.println("Sorted: " +java.util.Arrays.toString(arr));
    }
}
