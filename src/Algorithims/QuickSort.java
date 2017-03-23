package Algorithims;

import java.util.Random;

/**
 * Created by caihongji on 2017/3/21.
 * 算法名称 : 快速排序
 * p97 7.1-4 非递增
 * 随机化版本
 */
public class QuickSort {
    private QuickSort() {}
    public static boolean isAscending = true;
    public static boolean isRandom = true;
    public static void sort(int[] seq) {
        quickSort(seq,0,seq.length-1);
    }
    private static void quickSort(int[] seq,int p, int r) {
        if (p < r) {
            if (isRandom)
                exchange(seq, random(p, r), r);

            int q = partition(seq,p,r);
            quickSort(seq, p, (q - 1));
            quickSort(seq, (q + 1), r);
        }
    }
    private static int partition(int[] seq,int p, int r) {
        if (p < r) {
            int i = p - 1;
            int x = seq[r];
            for (int j = p; j < r; j++) {
                if (isAscending ? (seq[j] <= x) : (seq[j] > x) ) {
                    i++;
                    exchange(seq,i,j);
                }
            }
            exchange(seq,(i+1),r);
            return i+1;
        }
        return -1;
    }
    private static void exchange(int[] seq,int i,int j) {
        int tmp = seq[i];
        seq[i] = seq[j];
        seq[j] = tmp;
    }
    private static int random(int begin,int end) {
        if (begin >= end)
            return end;

        Random r = new Random();
        int bounds = end + 1 - begin;
        return begin + r.nextInt(bounds);
    }
}
