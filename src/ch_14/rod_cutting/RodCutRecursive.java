package ch_14.rod_cutting;

public class RodCutRecursive {

    public static int rodCutRecursive(int[] p, int n){
        int ans = Integer.MIN_VALUE;
        if (n == 0)
            return 0;
        for (int i = 1; i <= n; i++){
            ans = Integer.max(ans, p[i] + rodCutRecursive(p, n - i));
        }
        return ans;
    }

    public static void rodCutRecursiveDriverCode(){
        int [] p = {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30, 32, 35, 37, 38, 42, 43, 45, 48, 50, 60, 64, 70, 72, 78, 80, 83};
        System.out.println(rodCutRecursive(p, 26));
    }

}
