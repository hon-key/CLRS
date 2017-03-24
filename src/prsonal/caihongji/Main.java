package prsonal.caihongji;


import Algorithims.*;
import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws Exception {
	// write your code here
        int[] seq = {10,4,5,7,13,15,12,11};
        InsertionSort is = new InsertionSort(seq,InsertionSort.InsertionSortType.ascending);
        System.out.println("InsertionSort: " + Arrays.toString(is.sort()));
        System.out.println("InsertionSortWithRecursion: " + Arrays.toString(is.recursiveSort()));

        int[] lq_A = {1,4,6,13};
        int v = 6;
        LineQuery lq = new LineQuery(lq_A,v);
        System.out.println("lineQuery: " + lq.query());
        int[] lq_B = {1,2,3,14};
        int v_d = 16;
        LineQuery lq_d = new LineQuery(lq_B,v_d);
        System.out.println("dichotomy: " + lq_d.queryWithDichotomy());

        int[] _A = {1,1,0,1,1,0,1,1,1,0};
        int[] B = {1,0,0,0,1,0,0,1,0,1};
        BinaryAddition ba = BinaryAddition.create(_A,B);
        ba.add();
        System.out.println("BinaryAddition: ");
        System.out.println(Arrays.toString(ba.A));
        System.out.println(Arrays.toString(ba.B));
        System.out.println(Arrays.toString(ba.C));

        int[] ss_A = {1,4,7,9,10,3,20,8,3,2,4,4};
        SelectionSort ss = new SelectionSort(ss_A);
        System.out.println("SelectionSort: ");
        System.out.println(Arrays.toString(ss_A));
        System.out.println(Arrays.toString(ss.sort()));


        int[] ms_A = {6,5,4,3,2,7};
        MergeSort ms = new MergeSort(ms_A);
        System.out.println("MergeSort: ");
        System.out.println(Arrays.toString(ms_A));
        System.out.println(Arrays.toString(ms.sort(false)));
        System.out.println("Inversion: " + ms.inversion);

        int[] bs_A = {1,4,2,9,5,18,15,17,12};
        BubbleSort bs = new BubbleSort(bs_A);
        System.out.println("BubbleSort: ");
        System.out.println(Arrays.toString(bs_A));
        System.out.println(Arrays.toString(bs.sort()));

        int[] hornerA = {20,20,3,6,9,12};
        int x = 8;
        Horner h = new Horner(hornerA,x);
        System.out.println("Horner: ");
        System.out.println("Normal: " + h.normalCal());
        System.out.println("Special: " + h.specialCal());

        int[] fmsa_A = {10,-5,-5,10,3,-3,15,-12};
        int[] fmsa_B = {0,1,-5,6};
        FindMaximumSubArray.SubSeq recursion = FindMaximumSubArray.recursiveFind(fmsa_B);
        FindMaximumSubArray.SubSeq violentFind = FindMaximumSubArray.violentFind(fmsa_B);
        FindMaximumSubArray.SubSeq lineFind = FindMaximumSubArray.LinearFind(fmsa_B);
        System.out.println("FindMaximumSubArray: ");
        System.out.println(Arrays.toString(fmsa_A));
        System.out.println("recursion: [low: " + recursion.low + ", high: " + recursion.high + ", sum: " + recursion.sum + "]");
        System.out.println("violentFind: [low: " + violentFind.low + ", high: " + violentFind.high + ", sum: " + violentFind.sum + "]") ;
        System.out.println("lineFind: [low: " + lineFind.low + ", high: " + lineFind.high + ", sum: " + lineFind.sum + "]");

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
        System.out.println("SquareMatrixMultiply: ");
        int[][] result = SquareMatrixMultiply.multi(mA,mB);
        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }

        HireAssistant hire = new HireAssistant();
        System.out.println("HireAssistant: ");
        System.out.println("Directly: ");
        hire.hireDirectly(1,2,3,4,5);
        System.out.println("Randomly: ");
        hire.hireRandomly(1,2,3,4,5);

        int[] hps_A = {6,1,5,3,2,4};
        System.out.println("HeapSort: ");
        System.out.println(Arrays.toString(hps_A));
        HeapSort.sort(hps_A);
        System.out.println(Arrays.toString(hps_A));


        int[] pq_A = {1,3,2,5,4};
        PriorityQueue pq = new PriorityQueue(pq_A);
        System.out.println("PriorityQueue:");
        System.out.print("Raws:"); pq.printRaw();
        System.out.print("Heap:"); pq.printHeap();
        System.out.println("Maximum:" + pq.maximum());
        pq.extractMax();
        System.out.print("ExtractMax:");pq.printHeap();
        pq.insert(10);
        System.out.print("Insert:");pq.printHeap();
        pq.increaseKey(1,15);
        System.out.print("IncreaseKey:");pq.printHeap();

        int[] qs_A = {3,7,6,5,4,4};
        System.out.println("QuickSort:");
        System.out.println(Arrays.toString(qs_A));
        QuickSort.isAscending = false;
        QuickSort.isRandom = true;
        QuickSort.sort(qs_A);
        System.out.println(Arrays.toString(qs_A));

        int[] cs_A = {'a','c','d','b','w'};
        int[] cs_B = CountingSort.sort(cs_A);
        System.out.println("CountingSort:");
        System.out.println(Arrays.toString(cs_A));
        System.out.println(Arrays.toString(cs_B));

        String[] rs_A = {"Irelia","Trundle","Ezreal","Alistar",
                "Garen","Graves","Jayce","Katarina",
                "LeBlanc","lulu","Lux"};
        String[] rs_B = RadixSort.sort(rs_A);
        for (String str : rs_B) {
            System.out.println("[" + str + "]");
        }

    }
}
