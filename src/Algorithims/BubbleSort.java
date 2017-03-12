package Algorithims;

/**
 * Created by caihongji on 2017/3/12.
 * 算法: 冒泡排序
 * p23 2-2 冒泡排序的正确性
 */
public class BubbleSort {
    public  final int[] seq;

    public BubbleSort(int[] seq) {
        this.seq = seq;
    }

    public int[] sort() {
        for (int i = 0; i < seq.length - 1;i++) {               //  c1  n-1
            for (int j = seq.length - 1;j > i;j--) {            //  c2  (n-i) i = 0..n-2 求和
                if (seq[j] < seq[j-1])                          //  c3  (n-i) i = 0..n-2 求和
                    exchangeData(seq,j,(j-1));                  //  c4  tj 从 j = 0..n-2 求和
            }
        }
        return seq.clone();
    }
    private void exchangeData(int[] seq, int i,int j) {
        int tmp = seq[i];
        seq[i] = seq[j];
        seq[j] = tmp;
    }
}


/*
 *      循环不变式 : 不变式为seq[0..i],即seq数组前一部分整数的集合。
 *      证明 :
 *          初始化 : 在该算法迭代开始之前，i = 0, seq[0..0]为空数组，是正确的。
 *          保持 : 在上一次迭代为真的情况下，考虑当前的一次迭代:
 *                 第二个 for 循环里，从 第 j 个数开始，与第 j - 1 个数进行比较，若为真，即交换数据；
 *                 随后让第 j - 1 个数与第 j - 2 个数比较，以此类推。
 *                 可以知道，当第二个 for 循环结束时，当前迭代结尾,seq[i..seq.length-1]中的最小数被交换到seq[i];同时i++;
 *                 seq[0..i] 为排好序的数组，即为真。
 *          终止 : 该算法在 i = seq.length - 1 时，判断为false而终止，此时seq[0..seq.length-1]为以排好序的数组，为真。
 *
 *      性能 : 设当规模为 n 时, T(n) = c1(n-1) + (c2+c3)(n-1 在 i=0..n-2求和) + c4(tj在 i=0..n-2求和）
 *             最坏的情况下，tj =（n-i) 则 T(n) = c1(n-1) + (c2+c3+c4)(n-i i=0..n-2求和)
 *
 */
