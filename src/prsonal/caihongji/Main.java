package prsonal.caihongji;


import Algorithims.*;
import Algorithims.DataStructure.LinkList;
import Algorithims.DataStructure.Queue;
import Algorithims.DataStructure.Stack;
import Algorithims.DataStructure.Tree;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void print(int[] seq) {
        System.out.println(Arrays.toString(seq));
    }
    public static void print(double[] seq) {
        System.out.println(Arrays.toString(seq));
    }
    public static void print(int val) {
        System.out.println(val);
    }
    public static void print(String str) {
        System.out.println(str);
    }

    public static void main(String[] args) throws Exception {
	// write your code here
        int[] seq = {10,4,5,7,13,15,12,11};
        InsertionSort is = new InsertionSort(seq,InsertionSort.InsertionSortType.ascending);
        print("InsertionSort: " + Arrays.toString(is.sort()));
        print("InsertionSortWithRecursion: " + Arrays.toString(is.recursiveSort()));

        int[] lq_A = {1,4,6,13};
        int v = 6;
        LineQuery lq = new LineQuery(lq_A,v);
        print("lineQuery: " + lq.query());
        int[] lq_B = {1,2,3,14};
        int v_d = 16;
        LineQuery lq_d = new LineQuery(lq_B,v_d);
        print("dichotomy: " + lq_d.queryWithDichotomy());

        int[] _A = {1,1,0,1,1,0,1,1,1,0};
        int[] B = {1,0,0,0,1,0,0,1,0,1};
        BinaryAddition ba = BinaryAddition.create(_A,B);
        ba.add();
        print("BinaryAddition: ");
        print(Arrays.toString(ba.A));
        print(Arrays.toString(ba.B));
        print(Arrays.toString(ba.C));

        int[] ss_A = {1,4,7,9,10,3,20,8,3,2,4,4};
        SelectionSort ss = new SelectionSort(ss_A);
        print("SelectionSort: ");
        print(Arrays.toString(ss_A));
        print(Arrays.toString(ss.sort()));


        int[] ms_A = {6,5,4,3,2,7};
        MergeSort ms = new MergeSort(ms_A);
        print("MergeSort: ");
        print(ms_A);
        print(Arrays.toString(ms.sort(false)));
        print("Inversion: " + ms.inversion);

        int[] bs_A = {1,4,2,9,5,18,15,17,12};
        BubbleSort bs = new BubbleSort(bs_A);
        print("BubbleSort: ");
        print(bs_A);
        print(Arrays.toString(bs.sort()));

        int[] hornerA = {20,20,3,6,9,12};
        int x = 8;
        Horner h = new Horner(hornerA,x);
        print("Horner: ");
        print("Normal: " + h.normalCal());
        print("Special: " + h.specialCal());

        int[] fmsa_A = {10,-5,-5,10,3,-3,15,-12};
        int[] fmsa_B = {0,1,-5,6};
        FindMaximumSubArray.SubSeq recursion = FindMaximumSubArray.recursiveFind(fmsa_B);
        FindMaximumSubArray.SubSeq violentFind = FindMaximumSubArray.violentFind(fmsa_B);
        FindMaximumSubArray.SubSeq lineFind = FindMaximumSubArray.LinearFind(fmsa_B);
        print("FindMaximumSubArray: ");
        print(Arrays.toString(fmsa_A));
        print("recursion: [low: " + recursion.low + ", high: " + recursion.high + ", sum: " + recursion.sum + "]");
        print("violentFind: [low: " + violentFind.low + ", high: " + violentFind.high + ", sum: " + violentFind.sum + "]") ;
        print("lineFind: [low: " + lineFind.low + ", high: " + lineFind.high + ", sum: " + lineFind.sum + "]");

        int[][] mA = {
                {1,1,1,0},
                {1,1,1,0},
                {1,1,1,0},
                {0,0,0,0}

        };
        int[][] mB = {
                {6,6,6,0},
                {6,6,6,0},
                {6,6,6,0},
                {0,0,0,0}
        };
        print("SquareMatrixMultiply: ");
        int[][] result = SquareMatrixMultiply.multi(mA,mB);
        for (int i = 0; i < result.length; i++) {
            print(result[i]);
        }

        HireAssistant hire = new HireAssistant();
        print("HireAssistant: ");
        print("Directly: ");
        hire.hireDirectly(1,2,3,4,5);
        print("Randomly: ");
        hire.hireRandomly(1,2,3,4,5);

        int[] hps_A = {6,1,5,3,2,4};
        print("HeapSort: ");
        print(hps_A);
        HeapSort.sort(hps_A);
        print(hps_A);


        int[] pq_A = {1,3,2,5,4};
        PriorityQueue pq = new PriorityQueue(pq_A);
        print("PriorityQueue:");
        System.out.print("Raws:"); pq.printRaw();
        System.out.print("Heap:"); pq.printHeap();
        print("Maximum:" + pq.maximum());
        pq.extractMax();
        System.out.print("ExtractMax:");pq.printHeap();
        pq.insert(10);
        System.out.print("Insert:");pq.printHeap();
        pq.increaseKey(1,15);
        System.out.print("IncreaseKey:");pq.printHeap();

        int[] qs_A = {3,7,6,5,4,4};
        print("QuickSort:");
        print(qs_A);
        QuickSort.isAscending = false;
        QuickSort.isRandom = true;
        QuickSort.sort(qs_A);
        print(qs_A);

        int[] cs_A = {'a','c','d','b','w'};
        int[] cs_B = CountingSort.sort(cs_A);
        print("CountingSort:");
        print(Arrays.toString(cs_A));
        print(Arrays.toString(cs_B));

        String[] rs_A = {"Irelia","Trundle","Ezreal","Alistar",
                "Garen","Graves","Jayce","Katarina",
                "LeBlanc","lulu","Lux"};
        String[] rs_B = RadixSort.sort(rs_A);
        for (String str : rs_B) {
            print("[" + str + "]");
        }
        print("BucketSort:");
        double[] bucket_A = {0.14,0.13,0.2,0.11,0.99,0.998,0.989};
        double[][]bucket_B = BucketSort.sort(bucket_A);
        for (double[] list : bucket_B)
            print(list);

        int[] randomizeSelect_A = {1,3,4,2};
        int val = RandomizedSelect.select(randomizeSelect_A,2);
        print("randommizeSelect:");
        print(randomizeSelect_A);
        print(val);


        print("Stack:");
        Stack stack = new Stack(100);
        stack.push(3);stack.push(4);stack.push(5);
        stack.push(8);stack.push(20);
        stack.pop();
        print(stack.raw());

        print("Queue:");
        Queue queue = new Queue(50);
        queue.in(3);queue.in(4);queue.in(5);
        queue.out();
        print(queue.raw());

        print("LinkList:");
        LinkList head = new LinkList(LinkList.head,null);
        Random r = new Random();
        LinkList node = head;
        for (int i = 0; i < 10; i++) {
            node.next = new LinkList(r.nextInt(100), null);
            node = node.next;
            System.out.print("[+" + node.value + "]");
        }
        print("");
        print(head.array());

        print("BinaryTree:");
        Tree.BinaryTree root = new Tree.BinaryTree(-1);
        root.leftChild = new Tree.BinaryTree(10);
        root.rightChild = new Tree.BinaryTree(20);
        root.leftChild.leftChild = new Tree.BinaryTree(100);
        root.rightChild.rightChild = new Tree.BinaryTree(67);
        print(root.allValue());

    }
}
