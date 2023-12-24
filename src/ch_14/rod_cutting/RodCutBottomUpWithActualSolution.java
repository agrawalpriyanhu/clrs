package ch_14.rod_cutting;

import java.util.ArrayList;
import java.util.List;

public class RodCutBottomUpWithActualSolution {
    public static int rodCutBottomUpWithActualSolution(int[] price, int n){
        int ans[] = new int[n+1];
        int cutPoint[] = new int[n+1];
        for (int len = 0; len <= n; len++){
            for (int i = 1; i <= len; i++){
                if (price[i] + ans[len - i] > ans[len]){
                    ans[len] = Integer.max(ans[len], price[i] + ans[len - i]);
                    cutPoint[len] = i;
                }
            }
        }
        List<Integer> solution = getSolution(cutPoint, n);
       System.out.println("Solution = " + solution);
        return ans[n];
    }

    private static List<Integer> getSolution(int[] cutPoint, int n) {
        List<Integer> solution = new ArrayList<>();
        while (n > 0){
            solution.add(cutPoint[n]);
            n = n - cutPoint[n];
        }
        return solution;
    }

    public static void rodCutBottomUpWithActualSolutionDriverCode(){
        int [] p = {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30, 32, 35, 37, 38, 42, 43, 45, 48, 50, 60, 64, 70, 72, 78, 80, 83};
        System.out.println(rodCutBottomUpWithActualSolution(p, 26));
    }
}
