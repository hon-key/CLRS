package Algorithims;

import com.sun.org.apache.bcel.internal.generic.FALOAD;

/**
 * Created by caihongji on 2017/3/9.
 * 练习：2.1-4
 * 算法：两个二进制整数相加
 */
public class BinaryAddition {
    public enum Bit {
        zero(0),one(1);
        public int value;
        Bit(int i) {value = i;}
    }
    private class addResult {
        public boolean isCarry;
        public Bit bit;
        public addResult(int value,boolean isCarry) {
            this.isCarry = isCarry;
            bit = value == 0 ? Bit.zero : bit.one;
        }
    }
    public final int[] A;
    public final int[] B;
    public final int[] C;

    private BinaryAddition(int[] A,int[] B) {
        int length = max(A.length,B.length);
        this.A = new int[length];
        this.B = new int[length];
        assign(this.A,A);
        assign(this.B,B);
        this.C = new int[length + 1];
    }
    public  static BinaryAddition create(int[] A,int[] B) throws Exception {
        if (!(isBinary(A) && isBinary(B))) throw new Exception();
        return new BinaryAddition(A,B);
    }
    public boolean add() {
        for (int j = A.length - 1; j >= 0; j--) {
            int Abit = A[j];
            int Bbit = B[j];
            int Cbit = C[j+1];
            addResult result = bitAdd(Abit,Bbit,Cbit);
            if (result == null) return false;
            C[j+1] = result.bit.value;
            if (result.isCarry) C[j] += 1;
        }
        return true;
    }

    private addResult bitAdd(int b1,int b2,int b3) {
        int sum = b1 + b2 + b3;
        switch (sum) {
            case 0: return new addResult(0,false);
            case 1: return new addResult(1,false);
            case 2: return new addResult(0,true);
            case 3: return new addResult(1,true);
            default: return null;
        }
    }
    private int max(int a,int b) { return a > b ? a : b; }
    private void assign(int[] target,int[] origin) {
        if (origin.length > target.length) return;
        for (int i = origin.length - 1; i >= 0; i--) {
            int offset = origin.length - i;
            target[target.length - offset] = origin[i];
        }
    }
    private static boolean isBinary(int[] seq) {
        for (int i = 0; i < seq.length; i++)
            if (seq[i] != 0 && seq[i] != 1) return false;
        return true;
    }
}

/*
 *      证明：
 *          循环不变式：C[C.length - 1 .. j+1]、A[A.length-1, j]、B[B.length-1, j]为循环不变式;
 *                      即输出结构数组A、B、C的尾部子数组，称之为A`B`C`
 *          初始化:    循环之前，循环不变时A`B`C`的数组个数为0，符合0+0=0，故而为真。
 *          保持:      每一次迭代中，循环不变式均增加1位，取出A[j]、B[j]、C[j+1]相加，并适时进位，对C数组进行赋值；
 *                    可以发现，到下一次迭代开始前，循环不变式依旧遵守A` + B` = C`，故而为真。
 *          终止:     终止条件为j = 0，即循环至A[0]、B[0]为止，可以发现，结果就是A + B = C,故而为真。
 */
