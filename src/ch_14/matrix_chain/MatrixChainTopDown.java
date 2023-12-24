package ch_14.matrix_chain;

import java.util.Arrays;

public class MatrixChainTopDown {

    public static int matrixChainTopDown(int[] dim, int start, int end){
        int [][] dp = new int[dim.length + 1][dim.length + 1];
        for (int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[i][i] = 0;
        }
        return matrixChainTopDownHelper(dim, start, end, dp);
    }

    private static int matrixChainTopDownHelper(int[] dim, int start, int end, int[][] dp){
        if(start == end){
            return  0;
        }
        if (dp[start][end] < Integer.MAX_VALUE)
            return dp[start][end];
        int ans = Integer.MAX_VALUE;
        for (int k = start; k < end; k++){
            ans = Integer.min(ans, matrixChainTopDownHelper(dim, start, k, dp) + matrixChainTopDownHelper(dim, k+1, end, dp) + dim[start - 1] * dim[k] * dim[end]);
        }
        dp[start][end] = ans;
        return ans;
    }

    public static void matrixChainTopDownDriverCode(){
        int dim[] = { 1, 2, 3, 4, 3,5, 6, 8, 10, 2, 4, 8, 9, 20, 9, 8, 7, 6, 5, 4};
        System.out.println(matrixChainTopDown(dim, 1, dim.length - 1));
    }
}
