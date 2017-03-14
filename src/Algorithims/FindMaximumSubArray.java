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
        public SubSeq(int low,int high,int sum) { set(low,high,sum); }
        public void set(int low,int high,int sum) {
            this.low = low; this.high = high; this.sum = sum;
        }
    }
    public static SubSeq recursionFind(int[] seq) {
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
            SubSeq crossing = findMaxCrossingSubArray(seq,low,mid,high);
            return max(left,crossing,right);
        }
    }
    private static SubSeq findMaxCrossingSubArray(int[] seq,int low,int mid,int high) {
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
        if (right.sum > max.sum) max = right;
        return max;
    }

    public static SubSeq violentFind(int[] seq) {
        SubSeq maximumSubArray = new SubSeq(Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE);

        for (int i = 0; i < seq.length; i++) {
            if (seq[i] > maximumSubArray.sum) {
                maximumSubArray.set(i, i, seq[i]);
            }
            int previousSum = seq[i];
            for (int j = i + 1; j < seq.length; j++) {
                int currentSum = previousSum + seq[j];
                if (currentSum > maximumSubArray.sum ||
                        (currentSum == maximumSubArray.sum && (j-i) < (maximumSubArray.high - maximumSubArray.low))) {
                    maximumSubArray.set(i,j,currentSum);
                }
                previousSum = currentSum;
            }
        }
        return maximumSubArray;
    }

    public static SubSeq LinearFind(int[] seq) {
        SubSeq maximumSubArray = initialMaximumSubArrayFrom(seq);
        if (maximumSubArray.sum == 0) return maximumSubArray;

        int previousSum = 0;
        for (int i = maximumSubArray.low + 1; i < seq.length; i++) {
            int newValue = seq[i];
            int extendSum = maximumSubArray.sum + previousSum + newValue;
            int maxSum = max(maximumSubArray.sum,extendSum,newValue);
            if (maxSum == newValue) {
                maximumSubArray.set(i,i,newValue);
                previousSum = 0;
            }else if (maxSum == maximumSubArray.sum) {
                previousSum += newValue;
            }else if (maxSum == extendSum) {
                maximumSubArray.set(maximumSubArray.low,i,extendSum);
                previousSum = 0;
            }
        }
        return maximumSubArray;
    }
    private static SubSeq initialMaximumSubArrayFrom(int[] seq) {
        SubSeq maximumSubArray = new SubSeq(0,0,0);
        for (int i = 0; i < seq.length; i++) {
            if (seq[i] > 0) {
                maximumSubArray.sum = seq[i];
                maximumSubArray.low = i;
                maximumSubArray.high = i;
                break;
            }
        }
        return maximumSubArray;
    }
    private static int max(int sum,int extendSum,int newSum) {
        int max = newSum;
        if (sum > max) max = sum;
        if (extendSum > max) max = extendSum;
        return max;
    }
}
