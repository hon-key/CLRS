package Algorithims;

/**
 * Created by caihongji on 2017/3/9.
 * 算法名称：插入排序
 * 算法特性：升降序可选;递归（练习2.3-4）、非递归可选
 */
public class InsertionSort {
    public enum InsertionSortType { ascending,descendiing }
    public final int seq[];
    public InsertionSortType sortType;
    public InsertionSort(int seq[],InsertionSortType type) {
        this.seq = seq;
        this.sortType = type;
    }
    public int[] sort() {
        int[] seq = this.seq;
        int key;
        for (int j = 1;j <= seq.length - 1; j++) {
            key = seq[j];
            insert(seq,key,j);
        }
        return seq.clone();
    }
    public int[] sortWithRecursion() {
        recursion(seq,0,seq.length-1);
        return seq.clone();
    }
    private void recursion(int[] seq,int begin,int end) {
        if (end > begin) {
            recursion(seq,begin,(end-1));
            insert(seq,seq[end],end);
        }
    }
    private void insert(int[] seq,int key,int index) {
        int i;
        for (i = index - 1; i >= 0 && biggerOrSmaller(seq[i],key); i--) {
            seq[i + 1] = seq[i];
        }
        seq[i + 1] = key;
    }
    private boolean biggerOrSmaller(int value,int key) {
        switch (this.sortType) {
            case ascending: return value > key;
            case descendiing: return value < key;
            default:return false;
        }
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