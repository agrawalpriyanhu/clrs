package ch_6;

import java.util.Arrays;

public class HeapSort {

    public static void maxHeapify(int[] a, int i, int heapSize){
        int leftIndex = 2 * i + 1, rightIndex = 2 * (i+1);
        int largest = leftIndex <= heapSize && a[leftIndex] > a[i] ? leftIndex : i;
        if (rightIndex <= heapSize && a[rightIndex] > a[largest]){
            largest = rightIndex;
        }
        if (largest != i){
            swap(a, i, largest);
            maxHeapify(a, largest, heapSize);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void buildMaxHeap(int[] a){
        for (int i = a.length/2; i >= 0; i--){
            maxHeapify(a, i, a.length - 1);
        }
    }

    private static void heapSort(int[] arr){
        buildMaxHeap(arr);
        int heapSize = arr.length - 1;
        for (int i = 0; i < arr.length; i++){
            swap(arr, 0, heapSize);
            heapSize = heapSize - 1;
            maxHeapify(arr, 0, heapSize);
        }
    }

    public static void heapSortDriverCode(){
        int[] arr = {5, 1, 25,8, 3, 2, 2, 1, 10, 5, 4, 3, 6};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }



}
