package Algorithims.DataStructure;

import sun.plugin2.os.windows.SECURITY_ATTRIBUTES;

import java.util.ArrayList;

/**
 * Created by caihongji on 2017/3/27.
 * 数据结构 : 栈
 */
public class Stack<T> {
    private T[] seq;
    private int top;
    public final T nil = null;

    public Stack(T[] seq) {
        this.seq = seq;
        top = -1;
    }
    public void push(T t) {
        if (top == seq.length - 1) return;
        top++;
        seq[top] = t;
    }
    public T pop() {
        if (!hasNext()) return nil;
        top--;
        return seq[top+1];
    }
    public boolean hasNext() {
        if (top == -1) return false;
        return true;
    }
    public ArrayList<T> raw() {
        ArrayList<T> raw = new ArrayList();
        for (int i = 0; i <= top; i++) {
            raw.add(i,seq[i]);
        }
        return raw;
    }
}
