package Algorithims.DataStructure;

/**
 * Created by caihongji on 2017/3/29.
 * 数据结构 : 链表
 */
public class LinkList {
    public double value;
    public LinkList next;
    public static final int head = Integer.MIN_VALUE;
    public LinkList(double value,LinkList next) {
        this.value = value;
        this.next = next;
    }
    public void insert(LinkList item) {
        item.next = next;
        next = item;
    }
    public double[] array(){
        int length = length();
        if (value == head) length--;
        if (length == 0) return null;
        double[] array = new double[length];
        LinkList item;
        if (value == head) item = next;
        else  item = this;

        for (int i = 0;i < length; i++) {
            array[i] = item.value;
            item = item.next;
        }
        return array;
    }
    public int length() {
        LinkList item = this;
        int length = 1;
        for (;;) {
            if (item.next != null) {
                length++;
                item = item.next;
            }
            else break;
        }
        return length;
    }
}
