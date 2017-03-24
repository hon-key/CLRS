package Algorithims;

import sun.awt.image.ImageWatched;

/**
 * Created by caihongji on 2017/3/24.
 * 算法 : 桶排序
 */
public class BucketSort {
    private static double[] seq;
    private static LinkList[] list;

    private BucketSort() {}

    public static double[][] sort(double[] seq) {
        BucketSort.seq = seq;
        initialize();
        insert();
        return insertionSort();
    }

    private static void initialize() {
        list = new LinkList[seq.length];
        for (int i = 0;i < list.length; i++) {
            list[i] = new LinkList(LinkList.head,null);
        }
    }
    private static void insert() {
        for (int i = 0;i < seq.length;i++) {
            LinkList item = new LinkList(seq[i],null);
            list[(int)Math.floor(seq.length * seq[i])].insert(item);
        }
    }
    private static double[][] insertionSort() {
        double[][] listArray = new double[list.length][];
        for (int i = 0; i < list.length; i++) {
            double[] tmp = list[i].array();
            if (tmp != null) {
                InsertionSort is = new InsertionSort(tmp, InsertionSort.InsertionSortType.ascending);
                tmp = is.sort();
            }
            listArray[i] = tmp;
        }
        return listArray;
    }

    private static class LinkList {
        double value;
        LinkList next;
        public static final int head = Integer.MIN_VALUE;
        public LinkList(double value,LinkList next) {
            this.value = value;
            this.next = next;
        }
        public void insert(LinkList item) {
            if (next == null)
                next = item;
            else
                next.insert(item);
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
}
