package ch_14.rod_cutting;

public class RodCutBottomUp {

    public static int rodCutBottomUp(int[] price, int n){
        int ans[] = new int[n+1];

        for (int len = 0; len <= n; len++){
            for (int i = 1; i <= len; i++){
                ans[len] = Integer.max(ans[len], price[i] + ans[len - i]);
            }
        }
        return ans[n];
    }

    public static void rodCutBottomUpDriverCode(){
        int [] p = {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30, 32, 35, 37, 38, 42, 43, 45, 48, 50, 60, 64, 70, 72, 78, 80, 83};
        System.out.println(rodCutBottomUp(p, 18));
    }

}
