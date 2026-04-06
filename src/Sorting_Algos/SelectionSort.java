package Sorting_Algos;

public class SelectionSort {
    static void selectionSort(int[] arr){
        int n = arr.length;


        for(int i = 0; i < n-1; i++){
            int minIdx =i;
            for(int j=i+1;j<n;j++){
            if(arr[j] < arr[minIdx]){
                minIdx = j;
            }
        }
        int temp = arr[minIdx];
        arr[minIdx] = arr[i];
        arr[i] =temp;

    }
}

static void main(String[] args) {
    int[] arr = {43,98,16,53,90,31,68};
    selectionSort(arr);
    System.out.println("Sorted: " + java.util.Arrays.toString(arr));

}
}
