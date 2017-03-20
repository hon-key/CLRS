package Algorithims;

/**
 * Created by caihongji on 2017/3/20.
 * 算法 : 堆排序
 */
public class HeapSort {
    private static class Heap {
        public int heapSize;
        public int[] raws;
        public Heap(int[] seq) {
            this.raws = seq;
            this.heapSize = seq.length;
        }
    }

    private HeapSort() {}

    public static void sort(int[] seq) {
        Heap heap = new Heap(seq);
        buildMaxHeap(heap);
        for (int i = heap.raws.length - 1; i >= 1; i--) {
            exchange(heap,(0),i);
            heap.heapSize--;
            maxHeapify(heap,(0));
        }
    }

    private static void buildMaxHeap(Heap heap) {
        heap.heapSize = heap.raws.length;
        for (int i = heap.raws.length / 2 - 1; i >= 0; i--)
            maxHeapify(heap,i);
    }

    private static void maxHeapify(Heap heap,int i) {
        int l = left(i);
        int r = right(i);
        int largest = max(heap,i,l,r);
        if (largest != i) {
            exchange(heap, i, largest);
            maxHeapify(heap,largest);
        }
    }
    private static void exchange(Heap heap,int i,int j) {
        int tmp = heap.raws[i];
        heap.raws[i] = heap.raws[j];
        heap.raws[j] = tmp;
    }
    private static int left(int i) { return 2*i + 1; }
    private static int right(int i) { return 2*i + 1 + 1; }
    private static int max(Heap heap,int i,int l,int r) {
        int largest;
        if (l < heap.heapSize && heap.raws[l] >= heap.raws[i])          largest = l;
        else                                                            largest = i;
        if (r < heap.heapSize && heap.raws[r] >= heap.raws[largest])    largest = r;
        return largest;
    }
}

/*
 *  p90 6.4-2循环不变式证明:
 *          初始化 : 在sort函数迭代之前，heap对象的raws数组中，raws[0..raws.length-1]已被maxHeapify初始化为最大堆;
 *                  而raws[raws.length .. raws.length]为空数组，故而为已排序的数组,循环不变式为真。
 *
 *          保持 : 在一次迭代之前，假设循环不变时为真,此时设 i ,让raws[0..i]为最大堆，raws[i+1..raws.length-1]为已排序数组;
 *                 此时 heap.maxSize=raws.length;
 *                而在当前迭代中,首先交换 raws[0] 与 raws[heap.maxSize - 1],随后让heap.maxSize--,最后使用maxHeapify函数初始化
 *                heap数组中 raws[0..heap.maxSize] 为最大对最大堆。
 *                在此次迭代之后，由于最大堆的特性，raw[0]一定是最大堆的最大值，
 *                故而 raws[heap.maxSize+1..raws.length-1]为已排好序的数组，循环不变时为真。
 *          终止 : 最终，当i = 2时，最大堆为raws[0],已排好序的数组为raws[1..raws.length-1]；
 *                  由于最大堆的性质，raws[0]一定是整个序列中的最小数，故而raws[0..raws.length-1]为已排好序的数组。
 */
