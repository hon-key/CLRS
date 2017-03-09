package Algorithims;

/**
 * Created by caihongji on 2017/3/9.
 * 练习：p22 2.1-3
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
                i = j;  v = key;
                break;
            }
        }
        v = key; //恢复原始状态
        return i;
    }
}

/*
 *     证明：
 *          循环不变式：A[0...j]为循环不变式，即A数组本身被遍历过的元素的组合。
 *          初始化：循环之前，v的值被取出暂存于key，并赋值为nil；
 *                 循环不变式A[0]为空数组，即v的原始值并不在数组之中出现,且v为nil，故而为真。
 *           保持： 在一次迭代之中，循环不变式A[0..j]增加一个值，并判断该值是否和v的原始值key相等；
 *                 若相等，则让v重新赋予原始值key，i赋予相应的索引值，使得A[i] = v;
 *                 若不相等，则v依旧为nil，且v的原始值key不在A[0..j]之中，故而为真。
 *           终止： 导致循环终止的条件是j >= A.length;
 *                 循环中，终止时，j = A.length,此时要么v = nil；要么v = 原始值，且i = 相应的索引，故而为真。
 */
