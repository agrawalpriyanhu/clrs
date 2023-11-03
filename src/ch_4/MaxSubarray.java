package ch_4;

import java.util.Arrays;
import java.util.List;

public class MaxSubarray {

    // Max sum = 0th element, minIndex = 1st element, maxIndex = 2nd element
    public static List<Integer> maxSubarray(int arr[]){
        return maxSubarrayRecursive(arr, 0, arr.length - 1);
    }

    private static List<Integer> maxSubarrayRecursive(int[] arr, int i, int j) {
        if(i <= j){
            int mid = (i + j)/2;
            return maxSum(maxSubarrayRecursive(arr, i, mid-1),
            maxSubarrayRecursive(arr, mid + 1, j),
            maxSubarrayInclMid(arr, i, mid, j));
        }
        return Arrays.asList(0, -1, -1);
    }

    private static List<Integer> maxSum(List<Integer> maxSubarrayRecursive1,
                                 List<Integer> maxSubarrayRecursive2, List<Integer> maxSubarrayInclMid) {
        if (maxSubarrayRecursive1.get(0) > maxSubarrayRecursive2.get(0) && maxSubarrayRecursive1.get(0) > maxSubarrayInclMid
                .get(0))
            return maxSubarrayRecursive1;
        if (maxSubarrayRecursive2.get(0) > maxSubarrayRecursive1.get(0) && maxSubarrayRecursive2.get(0) > maxSubarrayInclMid
                .get(0))
            return maxSubarrayRecursive2;
        return maxSubarrayInclMid;
    }

    private static List<Integer> maxSubarrayInclMid(int[] arr, int i, int mid, int j) {
        int maxSum, leftSum, rightSum, leftIndex, rightIndex;
        leftSum = maxSum = arr[mid];
        leftIndex = rightIndex = mid;
        //Exploring the left of mid
        int k = mid - 1;
        while (k >= i){
            leftSum += arr[k];
            if (leftSum > maxSum){
                maxSum = leftSum;
                leftIndex = k;
            }
            k--;
        }
        // Exploring the right sum
        rightSum = maxSum;
        k = mid + 1;
        while (k <= j){
            rightSum += arr[k];
            if (rightSum > maxSum){
                maxSum = rightSum;
                rightIndex = k;
            }
            k++;
        }
        return Arrays.asList(maxSum, leftIndex, rightIndex);
    }

    public static void maxSubarrayDriverCode(){
        int[] arr= {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4};
        System.out.println(maxSubarray(arr));
    }

}
