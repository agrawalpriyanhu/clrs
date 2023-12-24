package ch_7;

import java.util.Arrays;

public class QuickSort {
    private static void quickSortHelper(int[] arr, int p, int r) {
        if (p >= r)
            return;
        int q = partition(arr, p, r);
        quickSortHelper(arr, p, q - 1);
        quickSortHelper(arr, q + 1, r);
    }

    private static int partition(int[] arr, int p, int r) {
        int key = arr[r];
        int i = p - 1;
        for (int j = p; j < arr.length  - 1; j++){
            if (arr[j] < key){
                i++;
                swap(arr, i, j);
            }
        }
        i++;
        swap(arr, i, r);
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void quickSortDriverCode(){
        int arr[] = {5, 1, 25,8, 3, 2, 2, 1, 10, 5, 4, 3, 6};
        System.out.println(Arrays.toString(arr));
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr) {
        quickSortHelper(arr, 0, arr.length - 1);
    }

}
