package Algorithims.DataStructure;

/**
 * Created by caihongji on 2017/3/27.
 */
public class Queue {
    private int[] seq;
    private int tail;
    private int head;
    public static final int nil = Integer.MIN_VALUE;

    public Queue(int capacity) {
        seq = new int[capacity];
        tail = 0; head = 0;
    }

    public void in(int val) {
        if (isFull()) return;
        seq[tail] = val;
        if (tail == seq.length-1) tail = 0;
        else tail++;
    }
    public int out() {
        if (isEmpty()) return nil;
        int x = seq[head];
        if (head == seq.length-1) head = 0;
        else head++;
        return x;
    }
    private boolean isFull() {
        int t = tail;
        if (t == seq.length-1) t = 0;
        else t++;
        if (t == head) return true;
        return false;
    }
    private boolean isEmpty() {
        return head == tail;
    }
    public int[] raw() {
        int num = tail < head ? seq.length - head + tail : tail - head;
        int[] raw = new int[num];
        if (num == 0) return raw;
        int i = head,j = 0;
        while (true) {
            if (i == seq.length) i = 0;
            raw[j] = seq[i];
            i++;j++;
            if (j == num) break;
        }
        return raw;
    }
}
