package Algorithims;

/**
 * Created by caihongji on 2017/3/9.
 * 算法名称：插入排序
 * 算法特性：升降序可选
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
            int i;
            for (i = j - 1; i >= 0 && bigerOrSamller(seq[i],key); i--) {
                seq[i + 1] = seq[i];
            }
            seq[i + 1] = key;
        }
        return seq;
    }
    private boolean bigerOrSamller(int value,int key) {
        switch (this.sortType) {
            case ascending: return value > key;
            case descendiing: return value < key;
            default:return false;
        }
    }
}