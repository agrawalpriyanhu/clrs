package ch_14.matrix_chain;

import java.util.Arrays;

public class MatrixChainBottomUp {

    private static int matrixChainBottomUp(int[] dim, int start, int end){
        int dp[][] = new int[dim.length + 1][dim.length + 1];
        for (int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[i][i] = 0;
        }
        int chainlength = dim.length - 1;
        for (int len = 2; len <= chainlength; len++){
            for (int i = 1; i <= chainlength - len + 1; i++){
                int max = i + len - 1;
                int ans = Integer.MAX_VALUE;
                for (int j = i; j < max; j++){
                    ans = Integer.min(ans, dp[i][j] + dp[j+1][max] + dim[i-1] * dim[j] * dim[max]);
                }
                dp[i][max] = ans;
            }
        }
        return dp[1][chainlength];
    }

    public static void matrixChainRecursiveDriverCode(){
        int dim[] = { 1, 2, 3, 4, 3,5, 6, 8, 10, 2, 4, 8, 9, 20, 9, 8, 7, 6, 5, 4};
        System.out.println(matrixChainBottomUp(dim, 1, dim.length - 1));
    }
}
