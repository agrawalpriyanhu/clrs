package ch_9;

import java.util.Random;

public class IthOrderStatistics {

    private static int randomizedPartition(int [] arr, int start, int end){
        int i = new Random().nextInt(start, end + 1);
        swap(arr, i, end);
        int j = start - 1, key = arr[end];
        for(int k = start; k < end; k++){
            if(arr[k] <= key){
                j++;
                swap(arr, j, k);
            }
        }
        j++;
        arr[end] = arr[j];
        arr[j] = key;
        return j;
    }

    private static void swap(int[] arr, int i, int n) {
        int temp = arr[i];
        arr[i] = arr[n];
        arr[n] = temp;
    }

    public static int ithOrderStatistics(int[] arr, int k){
        int start = 0, end = arr.length - 1, i = -1;
        while (i != k){
            if(i > k){
                end = i - 1;
            }
            else {
                start = i + 1;
            }
            i = randomizedPartition(arr, start, end);
        }
        return arr[i];
    }
    public static void ithOrderDriverCode(){
        int[] arr = {9,8,7,6,5,4,3,2,1};
        System.out.println(ithOrderStatistics(arr, 5));

    }

}
