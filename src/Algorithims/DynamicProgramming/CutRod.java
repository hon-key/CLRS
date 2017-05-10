package Algorithims.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by caihongji on 2017/4/21.
 * 算法 : 钢条切割动态规划问题
 */
public class CutRod {

    public static class Solution {
        public int maxReturn;
        public int[] solution;

        public void setSolution(int[] s,int len) {
            int[] tmp = new int[len];
            int count = 0;
            while (len > 0) {
                tmp[count] = s[len];
                len = len - s[len];
                count++;
            }
            count = 0;
            while (tmp[count] != 0) count++;
            solution = new int[count];
            count = 0;
            while (tmp[count] != 0) {
                solution[count] = tmp[count];
                count++;
            }
        }
        public void printSolution() {
            System.out.println("MaxRetrun: " + maxReturn + " Solution: " + Arrays.toString(solution));
        }
    }
    public static int cut(int[] price,int len) {
        if (len == 0) return 0;
        int q = Integer.MIN_VALUE;
        for (int i = 0;i <= len - 1; i++) {
            q = max(q,price[i] + cut(price,len - 1 - i));
        }
        return q;
    }
    public static Solution cut_memoized(int[] price,int len) {
        int[] r = new int[len+1];
        int[] s = new int[len+1];
        for (int i = 0; i < r.length; i++)
            r[i] = Integer.MIN_VALUE;
        memoizedCutRodAux(price,r,s,len);
        Solution solution = new Solution();
        solution.maxReturn = r[len];
        solution.setSolution(s,len);
        return solution;
    }
    private static int memoizedCutRodAux(int[] price,int[] r,int[] s,int len) {
        if (len == 0) return 0;
        if (r[len] >=0) return r[len-1];
        int q = Integer.MIN_VALUE;
        for (int i = 0; i <= len - 1; i++) {
            int newPrice = price[i] + memoizedCutRodAux(price,r,s,len-(i+1) );
            if (newPrice > q) {
                q = newPrice;
                s[len] = i+1;
            }
        }
        r[len] = q;
        return q;
    }
    public static Solution cut_bottom_up(int[] price,int len) {
        int[] r = new int[len+1];
        int[] s = new int[len+1];
        r[0] = 0;
        int q;
        for (int j = 0; j <= len - 1; j++) {
            q = Integer.MIN_VALUE;
            for (int i = 0; i <= j; i++) {
                int newPrice = price[i]+r[j - i];
                if (newPrice > q) {
                    q = newPrice;
                    s[j+1] = i+1;
                }
            }
            r[j+1] = q;
        }
        Solution solution = new Solution();
        solution.maxReturn = r[len];
        solution.setSolution(s,len);
        return solution;
    }
    private static int max(int a, int b) {
        return a > b ? a : b;
    }
}
