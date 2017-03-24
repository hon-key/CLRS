package Algorithims;

/**
 * Created by caihongji on 2017/3/24.
 * 算法 : 基数排序在单词排序上的应用
 * 练习 : p112 8.3-1
 * P.S. 1. 这里的CountingSort_StrVersion本可以在CountingSort.java的基础上进行OO重构。
 *      但是为了方便就地理解，这里直接拷贝了CountingSort.java的代码进行修改，重写了字符串版本的CountingSort。
 *      2. 这里我把较短单词设为更大的值，实际中可以稍作修改设为更小的值。
 *
 */
public class RadixSort {

    public static String[] sort(String[] seq) {
        int maxLength = findMaxLength(seq) - 1;
        String[] target = seq.clone();
        for (int i = maxLength - 1; i >=0; i--) {
            target = CountingSort_StrVersion.sort(target,i);
        }
        return target;
    }

    private static int findMaxLength(String[] seq) {
        int maxLength = 0;
        for (String str : seq) {
            if (str.length() > maxLength)
                maxLength = str.length();
        }
        return maxLength;
    }

    private static class CountingSort_StrVersion {
        private static String[] origin;
        private static String[] target;
        private static int[] temp;
        private static int index;
        private static final int MAX_VALUE = 128;

        public static String[] sort(String[] seq,int i) {
            initialize(seq,i);
            count();
            accumulate();
            place();
            return target.clone();
        }

        private static void initialize(String[] seq,int i) {
            origin = seq;
            target = new String[origin.length];
            index = i;
            temp = new int[MAX_VALUE + 1];
        }

        private static void count() {
            for (int j = 0; j < origin.length; j++) {
                char i = charAt(origin[j],index);
                temp[i]++;
            }
        }
        private static void accumulate() {
            for (int i = 0; i < temp.length; i++) {
                if (i == 0) continue;
                temp[i] += temp[i - 1];
            }
        }
        private static void place() {
            for (int j = origin.length - 1; j >= 0; j--) {
                char i = charAt(origin[j],index);
                target[temp[i] - 1] = origin[j];
                temp[i]--;
            }
        }
        private static char charAt(String str,int i) {
            if (i < str.length())
                return str.charAt(i);
            return 128;
        }
    }




}
