package prsonal.caihongji;


import Algorithims.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
	// write your code here
        int[] seq = {10,4,5,7,13,15,12,11};
        InsertionSort is = new InsertionSort(seq,InsertionSort.InsertionSortType.ascending);
        System.out.println("InsertionSort: " + Arrays.toString(is.sort()));
        System.out.println("InsertionSortWithRecursion: " + Arrays.toString(is.sortWithRecursion()));

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
    }
}
