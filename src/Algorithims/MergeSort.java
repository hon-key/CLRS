package Algorithims;

/**
 * Created by caihongji on 2017/3/10.
 * 算法名称 : 归并排序
 * p24 2-4 逆序对
 */
public class MergeSort {
    public final int[] seq;
    public boolean sentinel = true;
    public int inversion = 0;

    public MergeSort(int[] seq) {this.seq = seq;}
    public int[] sort(boolean sentinel) {
        this.sentinel = sentinel;
        mergeSort(seq,0,seq.length - 1);
        return seq.clone();
    }
    private void mergeSort(int[] A,int startIndex,int stopIndex) {
        if (startIndex < stopIndex) {
            int middleIndex = (startIndex + stopIndex) / 2;
            mergeSort(A,startIndex,middleIndex);
            mergeSort(A,middleIndex + 1,stopIndex);
            if (sentinel) merge(A,startIndex,middleIndex,stopIndex);
            else mergeWithNoSentinel(A,startIndex,middleIndex,stopIndex);
        }
    }

    private void merge(int[] A,int startIndex,int middleIndex,int stopIndex) {
        int[] seq1 = createArray(A,startIndex,middleIndex,true);
        int[] seq2 = createArray(A,(middleIndex+1),stopIndex,true);
        seq1[seq1.length - 1] = seq2[seq2.length - 1] = Integer.MAX_VALUE;
        int i = 0,j = 0;
        for (int k = startIndex; k <= stopIndex; k++) {
            if (seq1[i] <= seq2[j]) {
                A[k] = seq1[i]; i++;
            }
            else {
                A[k] = seq2[j]; j++;
                if (seq[i] != Integer.MAX_VALUE) inversion += seq1.length - i;
            }
        }
    }
    private void mergeWithNoSentinel(int[] A,int startIndex,int middleIndex,int stopIndex) {
        int[] seq1 = createArray(A,startIndex,middleIndex,false);
        int[] seq2 = createArray(A,(middleIndex+1),stopIndex,false);
        int i = 0,j = 0;
        for (int k = startIndex; k <= stopIndex; k++) {
            int vseq1 = i == seq1.length ? Integer.MAX_VALUE : seq1[i];
            int vseq2 = j == seq2.length ? Integer.MAX_VALUE : seq2[j];
            if (vseq1 <= vseq2) {
                A[k] = seq1[i]; i++;
            }
            else {
                A[k] = seq2[j];j++;
                if (vseq1 != Integer.MAX_VALUE) inversion += seq1.length - i;
            }
        }
    }
    private int[] createArray(int[] A,int startIndex,int stopIndex,boolean sentinel) {
        int capcity = stopIndex - startIndex + 1;
        if (sentinel) capcity = capcity + 1;
        int[] array = new int[capcity];
        assign(array,A,startIndex,capcity);
        return array;
    }
    private void assign(int[] target,int[] source,int startIndex,int capcity) {
        for (int i = 0;i < capcity; i++)
            target[i] = source[startIndex + i];
    }


}
