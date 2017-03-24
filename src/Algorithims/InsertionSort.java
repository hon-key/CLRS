package Algorithims;

/**
 * Created by caihongji on 2017/3/9.
 * 算法名称：插入排序
 * 算法特性：升降序可选;递归（练习2.3-4）、非递归可选
 */
public class InsertionSort {
    public enum InsertionSortType { ascending,descendiing }
    public final double seq[];
    public InsertionSortType sortType;
    public InsertionSort(int seq[],InsertionSortType type) {
        this.seq = convertToDouble(seq);
        this.sortType = type;
    }
    public InsertionSort(double seq[],InsertionSortType type) {
        this.seq = seq;
        this.sortType = type;
    }
    public double[] sort() {
        double[] seq = this.seq;
        double key;
        for (int j = 1;j <= seq.length - 1; j++) {
            key = seq[j];
            insert(seq,key,j);
        }
        return seq.clone();
    }
    public double[] recursiveSort() {
        recursion(seq,0,seq.length-1);
        return seq.clone();
    }
    private void recursion(double[] seq,int begin,int end) {
        if (end > begin) {
            recursion(seq,begin,(end-1));
            insert(seq,seq[end],end);
        }
    }
    private void insert(double[] seq,double key,int index) {
        int i;
        for (i = index - 1; i >= 0 && biggerOrSmaller(seq[i],key); i--) {
            seq[i + 1] = seq[i];
        }
        seq[i + 1] = key;
    }
    private boolean biggerOrSmaller(double value,double key) {
        switch (this.sortType) {
            case ascending: return value > key;
            case descendiing: return value < key;
            default:return false;
        }
    }
    private double[] convertToDouble(int[] seq) {
        double[] doubleSeq = new double[seq.length];
        for (int i = 0; i < seq.length;i++) {
            doubleSeq[i] = (double)seq[i];
        }
        return doubleSeq;
    }
}


/*
 *  递归法递归式：
 *      分解: 分解步骤仅仅为判断索引是否为 end > begin，需要常量时间，故而 D(n) = o(1)。
 *      解决: 我们递归地求解一个seq[bein..end-1]的数组,将贡献T(n-1)的运行时间。
 *      合并: insert函数的时间花费为C(n) = o(n)
 *
 *      递归式:    T(n) = T(n-1) + D(n) + C(n) = T(n-1) + o(n) + 1
 *                设一个常数c, 化简为:T(n) = T(n-1) + cn
 *
 */