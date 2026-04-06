package Sorting_Algos;
public  class BubbleSort {
    static void bubbleSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;

        }
    }

    static void main() {
        int[] arr = {67, 98, 12, 83, 23, 56, 92, 60};
        BubbleSort.bubbleSort(arr);

        System.out.println("Sorted: " + java.util.Arrays.toString(arr));
    }
}

