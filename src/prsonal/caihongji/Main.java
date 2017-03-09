package prsonal.caihongji;


import Algorithims.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] seq = {10,4,5};
        InsertionSort is = new InsertionSort(seq,InsertionSort.InsertionSortType.ascending);
        System.out.println(Arrays.toString(is.sort()));

        int[] A = {1,4,6,13};
        int v = 6;
        LineQuery lq = new LineQuery(A,v);
        System.out.println(lq.query());
    }
}
