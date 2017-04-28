package Algorithims.DynamicProgramming;

/**
 * Created by caihongji on 2017/4/21.
 * 算法 : 钢条切割动态规划问题
 */
public class CutRod {
    public static int cut(int[] price,int len) {
        if (len == 0) return 0;
        int q = Integer.MIN_VALUE;
        for (int i = 0;i <= len - 1; i++) {
            q = max(q,price[i] + cut(price,len - 1 - i));
        }
        return q;
    }
    public static int cut_memoized(int[] price,int len) {
        int[] r = new int[len];
        for (int i = 0; i < r.length; i++)
            r[i] = Integer.MIN_VALUE;
        return memoizedCutRodAux(price,r,len);
    }
    private static int memoizedCutRodAux(int[] price,int[] r,int len) {
        if (len == 0) return 0;
        if (r[len-1] >=0) return r[len-1];
        int q = Integer.MIN_VALUE;
        for (int i = 0; i <= len - 1; i++)
            q = max(q,price[i] + memoizedCutRodAux(price,r,len-1 - i));
        r[len-1] = q;
        return q;
    }
    public static int cut_bottom_up(int[] price,int len) {
        int[] r = new int[len+1];
        r[0] = 0;
        int q;
        for (int j = 0; j <= len - 1; j++) {
            q = Integer.MIN_VALUE;
            for (int i = 0; i <= j; i++) {
                q = max(q,price[i]+r[j - i]);
            }
            r[j+1] = q;
        }
        return r[len];
    }
    private static int max(int a, int b) { return a > b ? a : b; }
}
