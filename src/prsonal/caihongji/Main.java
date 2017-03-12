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

        int[] A = {1,4,6,13};
        int v = 6;
        LineQuery lq = new LineQuery(A,v);
        System.out.println("lineQuery: " + lq.query());

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


        int[] ms_A = {1,4,3,2,7,9,5,10,20,15};
        MergeSort ms = new MergeSort(ms_A);
        System.out.println("MergeSort: ");
        System.out.println(Arrays.toString(ms_A));
        System.out.println(Arrays.toString(ms.sort(false)));
    }
}
