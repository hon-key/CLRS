package prsonal.caihongji;


import Algorithims.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] seq = {10,4,5};
        InsertionSort is = new InsertionSort(seq,InsertionSort.InsertionSortType.ascending);
        System.out.println(Arrays.toString(is.sort()));
    }
}
