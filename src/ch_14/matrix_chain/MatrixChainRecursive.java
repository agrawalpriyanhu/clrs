package ch_14.matrix_chain;


public class MatrixChainRecursive {

    public static int matrixChainRecursive(int[] dim, int start, int end){
        if(start == end){
            return  0;
        }
        int ans = Integer.MAX_VALUE;
        for (int k = start; k < end; k++){
            ans = Integer.min(ans, matrixChainRecursive(dim, start, k) + matrixChainRecursive(dim, k+1, end) + dim[start - 1] * dim[k] * dim[end]);
        }
        return ans;
    }

    public static void matrixChainRecursiveDriverCode(){
        int dim[] = { 1, 2, 3, 4, 3,5, 6, 8, 10, 2, 4, 8, 9, 20, 9, 8, 7, 6, 5, 4};
        System.out.println(matrixChainRecursive(dim, 1, dim.length - 1));
    }
}
