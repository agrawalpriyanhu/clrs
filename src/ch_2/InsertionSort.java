package ch_2;

import java.util.Arrays;

public class InsertionSort {

    public static int[] sort(int[] input){
        for (int i = 1; i < input.length; i++){
            int key = input[i];
            int j = i - 1;
            while (j >= 0 && input[j] < key){
                input[j+1] = input[j];
                j--;
            }
            input[j+1] = key;
        }
        return input;
    }

    public static void insertionSortDriverCode(){
        int arr[] = {1, 3, 5, 7, 9, 0, 8, 6, 4, 2};
        System.out.println("Input = " + Arrays.toString(arr));
        sort(arr);
        System.out.println("Output = " + Arrays.toString(arr));
    }

}
