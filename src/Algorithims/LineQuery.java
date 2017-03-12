package Algorithims;

/**
 * Created by caihongji on 2017/3/9.
 * 练习：p12 2.1-3 (线性查找);
 *      p22 2.3-5 (二分查找，排序好的条件下)
 */
public class LineQuery {
    public static final int nil = -1;
    public final int[] A;
    public int v;
    public LineQuery(int[] A,int v) {
        this.A = A;
        this.v = v;
    }

    public int query() {
        int key = this.v;
        v = nil;
        int i = nil;
        for (int j = 0; j < A.length; j++) {
            if (key == A[j]) {
                i = j;
                v = key;
                break;
            }
        }
        v = key; //恢复原始状态
        return i;
    }
    public int queryWithDichotomy() {
        return dichotomy(A,0,A.length - 1);
    }
    private int dichotomy(int[] seq,int begin,int end) {
        int key = nil;
        if (end >= begin) {
            int index = begin + (end - begin) / 2;
            int compare = v - seq[index];
            if (compare == 0) key = index;
            else if (compare < 0) key = dichotomy(seq,begin,(index - 1));
            else key = dichotomy(seq,(index+1),end);
        }
        return key;
    }
}

/*
 *     证明：线性查找
 *          循环不变式：A[0...j]为循环不变式，即A数组本身被遍历过的元素的组合。
 *          初始化：循环之前，v的值被取出暂存于key，并赋值为nil；
 *                 循环不变式A[0]为空数组，即v的原始值并不在数组之中出现,且v为nil，故而为真。
 *           保持： 在一次迭代之中，循环不变式A[0..j]增加一个值，并判断该值是否和v的原始值key相等；
 *                 若相等，则让v重新赋予原始值key，i赋予相应的索引值，使得A[i] = v;
 *                 若不相等，则v依旧为nil，且v的原始值key不在A[0..j]之中，故而为真。
 *           终止： 导致循环终止的条件是j >= A.length;
 *                 循环中，终止时，j = A.length,此时要么v = nil；要么v = 原始值，且i = 相应的索引，故而为真。
 */

/*
 *      证明：二分查找
 *          分解: 考虑二分查找的特性，分解步骤的主要操作为：赋值nil、判断大小、计算索引、比较、判断并选择步骤。
 *               该操作集合的花费为o(1)。
 *          解决: 解决操作为递归操作，该操作将数组一分为二，并选择其中一个子序列进行递归。
 *               故而操作花费为T(n/2)
 *          合并：该算法为查找算法，一旦在分解阶段的比较操作得到结果，便立即返回，故而没有合并操作，花费为0。
 *
 *          递归式: T(n) = T(n/2) + c ，当 n = 1 时，T(n) = c
 *          数学归纳: 考虑 n 的规模为2的幂次方的情况,设 n = 2，则有 T(2) = T(1) + c = 2c,其数量作为叶子的树的层数为:lg2 + 1;
 *                   假设 n = 2^i，我们有在n规模下，树的层数为:lg2^i + 1 = i + 1;
 *                   考虑 n = 2^(i+1) 的情况，树的层数比 n = 2^i 多 1 层，为 i + 1 + 1 = lg2^(i+1) + 1 成立。
 *                   故而有 n 规模情况下，树的层数为 lgn + 1;
 *                   则 T(n)的花费为 T(n) = c(lgn + 1) = c*lgn + c;
 *                   花费为o(lgn)
 */
