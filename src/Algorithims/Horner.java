package Algorithims;

/**
 * Created by caihongji on 2017/3/12.
 * 算法 : 霍纳规则
 * p23 2-3
 */
public class Horner {
    public final int[] a;
    public final int x;

    public Horner(int[] a,int x) {
        this.a = a; this.x = x;
    }
    public long normalCal() {
        long p = a[0];
        for (int i = 0; i < a.length; i++) {
            int X = x;
            for (int j = 0; j < i - 1; j++) X *= x;
            if (i == 0) X = 0;
            p += a[i] * X;
        }
        return p;
    }

    public long specialCal() {
        long y = 0;
        for (int i = a.length-1;i >= 0; i--) {
            y = a[i] + x * y;
        }
        return y;
    }
}


/*
 *      证明:
 *          循环不变式 y = a[k+i+1]x^k k=0..n-(i+1)求和,并设没有项的和式为0;
 *          初始化 : 第一次迭代之前，y = 0,等于循环不变式，为真。
 *          保持 : for 循环每次迭代开始前皆有循环不变式为真。
 *          终止 : i = -1; 此时有循环不变时 y = a[k]x^k k=0..n求和,为真。
 *
 */
