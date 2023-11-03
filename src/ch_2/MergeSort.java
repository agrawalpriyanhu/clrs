package ch_2;

import java.util.Arrays;

public class MergeSort {

    public static int[] mergeSort(int[] arr){
        mergeSortRecursive(arr, 0, arr.length - 1);
        return arr;
    }

    private static void mergeSortRecursive(int[] arr, int s, int e) {
        if (s < e){
            int m = ((s + e)/2);
            mergeSortRecursive(arr, s, m);
            mergeSortRecursive(arr,m+1, e);
            merge(arr, s, m, e);
        }
    }

    private static void merge(int[] arr, int s, int m, int e) {
        int lSize = m - s + 1, rSize = e - m;
        int [] l = new int[lSize], r = new int[rSize];
        int k = s;
        for(int i = 0; i < l.length; i++, k++){
            l[i] = arr[k];
        }
        for (int i = 0; i < r.length; i++, k++){
            r[i] = arr[k];
        }
        int i = 0, j = 0;
        k = s;
        while (i < l.length && j < r.length){
            arr[k++] = l[i] < r[j] ? l[i++] : r[j++];
        }
        if(i == l.length){
            while (j < r.length){
                arr[k++] = r[j++];
            }
        } else if (j == r.length) {
            while (i < l.length)
                arr[k++] = l[i++];

        }
    }

    public static void mergeSortDriverCode(){
        int arr[] = {5, 3, 1, 7, 9, 0, 8, 6, 4, 2};
        System.out.println("Input = " + Arrays.toString(arr));
        mergeSort(arr);
        System.out.println("Output = " + Arrays.toString(arr));
    }

}
