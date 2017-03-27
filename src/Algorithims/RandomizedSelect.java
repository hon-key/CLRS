package Algorithims;
import java.util.Random;
/**
 * Created by caihongji on 2017/3/27.
 * 算法 : 随机选择
 */
public class RandomizedSelect {

    public static int select(int[] seq,int i) {
        return randomizeSelect(seq,0,seq.length-1,i);
    }

    private static int randomizeSelect(int[] seq,int p,int r,int i) {
        if (p == r) return seq[p];
        int q = randomizePartition(seq,p,r);
        int k = q - p + 1;
        if (i == k) return seq[q];
        else if (i < k) return randomizeSelect(seq,p,(q-1),i);
        else return randomizeSelect(seq,(q+1),r,(i-k));
    }
    private static int randomizePartition(int[] seq,int p, int r) {
        if (p < r) {
            exchange(seq, random(p, r), r);
            int i = p - 1;
            int x = seq[r];
            for (int j = p; j < r; j++) {
                if (seq[j] <= x) {
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
