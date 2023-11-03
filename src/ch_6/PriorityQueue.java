package ch_6;

public class PriorityQueue {

    public static int heapMaximum(int[] arr){
        return arr[0];
    }

    public static int extractMax(int arr[], int heapSize){
        int max = arr[0];
        swap(arr, 0, heapSize);
        heapSize--;
        HeapSort.maxHeapify(arr, 0, heapSize);
        return max;
    }

    public static void increaseKey(int arr[], int i, int key, int heapSize){
        arr[i] = key;
        int parentOfI = (i-1)/2;
        while (i >= 0 && arr[i] > arr[parentOfI]){
            swap(arr, i, parentOfI);
            i = parentOfI;
        }
    }

    public static void insertKey(int [] arr, int key, int heapSize){
        heapSize++;
        arr[heapSize] = Integer.MIN_VALUE;
        increaseKey(arr, heapSize, key, heapSize);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
