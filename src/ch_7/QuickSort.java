package ch_7;

import java.util.Arrays;

public class QuickSort {

    private static void partition(int arr[], int p, int q, int r){
        swap(arr, q, r);
        int i = p - 1;
        int key = arr[r];
        for (int j = p; j < r; j++){
            if (arr[j] < key){
                i++;
                swap(arr, i, j);
            }
        }
        i++;
        swap(arr, i, r);
        arr[i] = key;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void quickSortDriverCode(){
        int arr[] = {5, 1, 25,8, 3, 2, 2, 1, 10, 5, 4, 3, 6};
        System.out.println(Arrays.toString(arr));
        partition(arr, 1, 4, 8);
        System.out.println(Arrays.toString(arr));
    }

}
