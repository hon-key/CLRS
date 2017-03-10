package Algorithims;

/**
 * Created by caihongji on 2017/3/10.
 * 算法名称：选择排序
 */
public class SelectionSort {
    public final int[] seq;

    public SelectionSort(int[] seq) { this.seq = seq; }
    public int[] sort() {
        for (int j = 0; j < seq.length - 1; j++) {              // c1   n-1
            int i = j + 1;                                      // c2   n-1
            while (i <seq.length) {                             // c3   (n-j) 从 j=[1..n-1] 求和
                if (seq[i] < seq[j])                            // c4   (n-j-1) 从 j=[1..n-1] 求和
                    exchangeSeqData(i,j);                       // c5   (tj) 从 j=[1..n-1]求和
                i++;                                            // c6   (n-j-1) 从 j=[1..n-1]求和
            }
        }
        return seq.clone();
    }
    // 该函数的时间花费可看做常量
    private void exchangeSeqData(int index1,int index2) {
        int key = seq[index1];
        seq[index1] = seq[index2];
        seq[index2] = key;
    }
}



/*
 * 算法分析：
 *      循环不变式 : seq[0..j]组成的数组为循环不变式，即原始数组已经被迭代过的那一部分。
 *      时间总和 = (c1+c2)(n-1) + c3*(n^2-n)/2 + (c4+c6)(n^2+5n-2)/2 + c5*{(tj) 从 j=[1..n-1]求和}
 *      考虑最坏的情况:序列为反向序列，则if语句中的内容的执行次数将和if语句等同，则 tj = n-j-1;
 *      故而时间总和 = (c1+c2)(n-1) + c3*(n^2-n)/2 + (c4+c5+c6)(n^2+5n-2)/2
 *      简化以后，其时间效率为O(n^2)
 *      考虑平均情况：if语句有一半为真，一半为假，则 tj = （n-j-1）/ 2
 *      简化以后，时间效率依旧为O(n^2)
 */
