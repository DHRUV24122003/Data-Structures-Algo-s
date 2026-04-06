package Sorting_Algos;

public class InsertionSort {
    static void insertionSort(int[] arr) {
    int n = arr.length;
    for (int i = 1; i < n; i++){
        int key =arr[i];
        int j= i-1;
        while(j >=0 && arr[j] >key){
            arr[j+1] = arr[j];
            j--;
        }
        arr[j+1] = key;
    }

}

static void main() {
    int[] arr = {64,87,12,79,25,90,53};
    insertionSort(arr);
    System.out.println("Sorted: "+ java.util.Arrays.toString(arr));
}
}
