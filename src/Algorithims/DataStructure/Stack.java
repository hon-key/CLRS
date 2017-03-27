package Algorithims.DataStructure;

/**
 * Created by caihongji on 2017/3/27.
 * 数据结构 : 栈
 */
public class Stack {
    private int[] seq;
    private int top;
    public static final int nil = Integer.MIN_VALUE;

    public Stack(int capacity) {
        seq = new int[capacity];
        top = -1;
    }
    public void push(int val) {
        if (top == seq.length - 1) return;
        top++;
        seq[top] = val;
    }
    public int pop() {
        if (top == -1) return nil;
        top--;
        return seq[top+1];
    }
    public int[] raw() {
        int[] raw = new int[top+1];
        for (int i = 0; i <= top; i++) {
            raw[i] = seq[i];
        }
        return raw;
    }
}
