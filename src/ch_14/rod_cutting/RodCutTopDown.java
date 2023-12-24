package ch_14.rod_cutting;

public class RodCutTopDown {

    public static int rodCutTopDown(int [] price, int n){
        int ans[] = new int[n+1];
        return rodCutTopDownHelper(price, n, ans);
    }

    private static int rodCutTopDownHelper(int[] price, int n, int[] ans) {
        if (n == 0)
            return 0;
        if (ans[n] > 0)
            return ans[n];
        int max = 0;
        for (int i = 1; i <= n; i++){
            max = Integer.max(max, price[i] + rodCutTopDownHelper(price, n - i, ans));
        }
        ans[n] = max;
        return ans[n];
    }

    public static void rodCutTopDownDriverCode(){
        int [] p = {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        System.out.println(rodCutTopDown(p, 9));
    }

}
