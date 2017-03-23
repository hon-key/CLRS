package Algorithims;

/**
 * Created by caihongji on 2017/3/23.
 * 算法 : 计数排序
 */
public class CountingSort {
    private static int[] origin;
    private static int[] target;
    private static int[] temp;

    public static int[] sort(int[] seq) {
        initialize(seq);
        count();
        accumulate();
        place();
        return target.clone();
    }

    private static void initialize(int[] seq) {
        origin = seq;
        target = new int[origin.length];
        int maxInt = Integer.MIN_VALUE;
        for (int a : origin)
            if (a > maxInt) maxInt = a;
        temp = new int[maxInt+1];
    }

    private static void count() {
        for (int j = 0; j < origin.length; j++)
            temp[origin[j]]++;
    }
    private static void accumulate() {
        for (int i = 0; i < temp.length; i++) {
            if (i == 0) continue;
            temp[i] += temp[i - 1];
        }
    }
    private static void place() {
        for (int j = origin.length - 1; j >= 0; j--) {
            target[temp[origin[j]] - 1] = origin[j];
            temp[origin[j]]--;
        }
    }
}
