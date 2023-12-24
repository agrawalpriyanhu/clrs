package ch_14.rod_cutting;

import java.util.ArrayList;
import java.util.List;

public class RodCutTopDownWithActualSolution {

    public static int rodCutTopDownWithActualSolution(int [] price, int n){
        int ans[] = new int[n+1];
        int cutPoint[] = new int[n+1];
        rodCutTopDownHelperWithActualSolution(price, n, ans, cutPoint);
        List<Integer> solution = getSolution(cutPoint, n);
        System.out.println("Solution = " + solution);
        return ans[n];
    }

    private static int rodCutTopDownHelperWithActualSolution(int[] price, int n, int[] ans, int[] cutpoint) {
        if (n == 0)
            return 0;
        if (ans[n] > 0)
            return ans[n];
        int max = 0;
        for (int i = 1; i <= n; i++){
            if (price[i] + rodCutTopDownHelperWithActualSolution(price, n - i, ans, cutpoint) > max){
                max = price[i] + rodCutTopDownHelperWithActualSolution(price, n - i, ans, cutpoint);
                cutpoint[n] = i;
            }
        }
        ans[n] = max;
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


    public static void rodCutTopDownWithActualSolutionDriverCode(){
        int [] p = {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30, 32, 35, 37, 38, 42, 43, 45, 48, 50, 60, 64, 70, 72, 78, 80, 83};
        System.out.println(rodCutTopDownWithActualSolution(p, 26));
    }

}
