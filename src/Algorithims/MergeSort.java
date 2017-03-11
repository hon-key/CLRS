package Algorithims;

/**
 * Created by caihongji on 2017/3/10.
 * 算法名称 : 归并排序
 */
public class MergeSort {
    public final int[] seq;
    public boolean sentinel = true;
    public MergeSort(int[] seq) {this.seq = seq;}
    public int[] sort(boolean sentinel) {
        this.sentinel = sentinel;
        subMergeSort(seq,0,seq.length - 1);
        return seq.clone();
    }

    private void subMergeSort(int[] A,int startIndex,int stopIndex) {
        if (startIndex < stopIndex) {
            int middleIndex = (startIndex + stopIndex) / 2;
            subMergeSort(A,startIndex,middleIndex);
            subMergeSort(A,middleIndex + 1,stopIndex);
            if (sentinel) merge(A,startIndex,middleIndex,stopIndex);
            else mergeWithNoSentinel(A,startIndex,middleIndex,stopIndex);
        }
    }

    private void merge(int[] A,int startIndex,int middleIndex,int stopIndex) {
        int n1 = middleIndex - startIndex + 1;
        int n2 = stopIndex - (middleIndex+1) + 1;
        int[] seq1 = new int[n1 + 1];
        int[] seq2 = new int[n2 + 1];
        assign(seq1,A,startIndex,n1);
        assign(seq2,A,(middleIndex+1),n2);
        seq1[n1] = seq2[n2] = Integer.MAX_VALUE;
        int i = 0,j = 0;
        for (int k = startIndex; k <= stopIndex; k++) {
            if (seq1[i] < seq2[j]) {
                A[k] = seq1[i]; i++;
            }
            else {
                A[k] = seq2[j]; j++;
            }
        }
    }
    private void mergeWithNoSentinel(int[] A,int startIndex,int middleIndex,int stopIndex) {
        int n1 = middleIndex - startIndex + 1;
        int n2 = stopIndex - (middleIndex+1) + 1;
        int[] seq1 = new int[n1];
        int[] seq2 = new int[n2];
        assign(seq1,A,startIndex,n1);
        assign(seq2,A,(middleIndex+1),n2);
        int i = 0,j = 0;
        for (int k = startIndex; k <= stopIndex; k++) {
            int vseq1 = i == seq1.length ? Integer.MAX_VALUE : seq1[i];
            int vseq2 = j == seq2.length ? Integer.MAX_VALUE : seq2[j];
            if (vseq1 < vseq2) {
                A[k] = seq1[i]; i++;
            }
            else {
                A[k] = seq2[j];j++;
            }
        }
    }
    private void assign(int[] target,int[] source,int startIndex,int capcity) {
        for (int i = 0;i < capcity; i++)
            target[i] = source[startIndex + i];
    }


}
