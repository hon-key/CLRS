package Algorithims;

/**
 * Created by caihongji on 2017/3/14.
 * 算法：寻找和最大连续子数组
 */
public class FindMaximumSubArray {
    public static class SubSeq {
        public int low;
        public int high;
        public int sum;
        public SubSeq(int low,int high,int sum) {
            this.low = low; this.high = high; this.sum = sum;
        }
    }
    public static SubSeq find(int[] seq) {
        return findMaximumSubArray(seq,0,seq.length-1);
    }
    private static SubSeq findMaximumSubArray(int[] seq,int low,int high) {
        if (low == high) {
            SubSeq subArray = new SubSeq(low,high,seq[low]);
            return subArray;
        }else {
            int mid = (low + high) / 2;
            SubSeq left = findMaximumSubArray(seq,low,mid);
            SubSeq right = findMaximumSubArray(seq,(mid+1),high);
            SubSeq crossing = findMaxCorssingSubArray(seq,low,mid,high);
            return max(left,crossing,right);
        }
    }
    private static SubSeq findMaxCorssingSubArray(int[] seq,int low,int mid,int high) {
        int leftSum = Integer.MIN_VALUE;
        int leftIndex = 0,sum = 0;
        for (int i = mid; i >= low; i--) {
            sum += seq[i];
            if (sum > leftSum) {
                leftSum = sum;
                leftIndex = i;
            }
        }
        int rightSum = Integer.MIN_VALUE;
        int rightIndex = 0;sum = 0;
        for (int i = mid+1; i <= high; i++) {
            sum += seq[i];
            if (sum > rightSum) {
                rightSum = sum;
                rightIndex = i;
            }
        }
        SubSeq crossing = new SubSeq(leftIndex,rightIndex,(leftSum + rightSum));
        return crossing;
    }
    private static SubSeq max(SubSeq left,SubSeq crossing,SubSeq right) {
        SubSeq max = left;
        if (crossing.sum > max.sum) max = crossing;
        else if (right.sum > max.sum) max = right;
        return max;
    }

    public static SubSeq violentFind(int[] seq) {
        int sum = Integer.MIN_VALUE;
        int low = 0,high = 0;
        for (int i = 0; i < seq.length; i++) {
            int previousSum = seq[i];
            for (int j = i + 1; j < seq.length; j++) {
                int currentSum = previousSum + seq[j];
                if (currentSum > sum) {
                    sum = currentSum;
                    low = i; high = j+1;
                }
                previousSum = currentSum;
            }
        }
        SubSeq subseq = new SubSeq(low,high,sum);
        return subseq;
    }

}
