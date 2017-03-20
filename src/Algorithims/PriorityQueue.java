package Algorithims;

import java.util.Arrays;

/**
 * Created by caihongji on 2017/3/20.
 * 数据结构 : 优先队列
 */
public class PriorityQueue {
    private static class Heap {
        int heapSize;
        int[] raws;
        Heap(int[] seq) {
            raws = seq;
            buildMaxHeap();
        }
        void buildMaxHeap() {
            heapSize = raws.length;
            for (int i = raws.length / 2 - 1; i >= 0; i--)
                maxHeapify(i);
        }
        void maxHeapify(int i) {
            int l = left(i);
            int r = right(i);
            int largest = max(i,l,r);
            if (largest != i) {
                exchange(i, largest);
                maxHeapify(largest);
            }
        }
        static int left(int i) { return 2*i + 1; }
        static int right(int i) { return 2*i + 1 + 1; }
        static int parent(int i) { return (i+1) / 2 - 1; }
        int max(int i,int l,int r) {
            int largest;
            if (l < heapSize && raws[l] >= raws[i])          largest = l;
            else                                             largest = i;
            if (r < heapSize && raws[r] >= raws[largest])    largest = r;
            return largest;
        }
        void exchange(int i,int j) {
            int tmp = raws[i];
            raws[i] = raws[j];
            raws[j] = tmp;
        }
    }

    private Heap heap;
    public PriorityQueue(int[] seq) {
        this.heap = new Heap(seq);
    }
    public void insert(int key) {
        heap.heapSize++;
        heap.raws[heap.heapSize - 1] = Integer.MIN_VALUE;
        increaseKey(heap.heapSize - 1,key);
    }
    public int maximum() {
        return heap.raws[0];
    }
    public int extractMax() {
        int max = heap.raws[0];
        heap.raws[0] = heap.raws[heap.heapSize - 1];
        heap.heapSize--;
        heap.maxHeapify(0);
        return max;
    }
    public void increaseKey(int i,int newKey) {
        heap.raws[i] = newKey;
        while (i > 0 && heap.raws[Heap.parent(i)] < heap.raws[i]) {
            heap.exchange(Heap.parent(i),i);
            i = Heap.parent(i);
        }
    }
    public void printHeap() {
        System.out.print("[");
        for (int i = 0; i < heap.heapSize; i++) {
            if (i == 0) { System.out.print(heap.raws[i]); continue;}
            System.out.print(", " + heap.raws[i]);
        }
        System.out.print("]\n");
    }
    public void printRaw() {
        System.out.println(Arrays.toString(heap.raws));
    }


}
