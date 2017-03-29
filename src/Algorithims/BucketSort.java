package Algorithims;

import Algorithims.DataStructure.LinkList;

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
}
