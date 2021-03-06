package edu.mum.cs.cs425.lab11solutions.arrayutils.Question2;

import edu.mum.cs.cs425.lab11solutions.arrayutils.Question2.service.ArrayFlattenerService;

public class ArrayReversor {
    private ArrayFlattenerService arrayFlattenerService;

    public ArrayReversor(ArrayFlattenerService arrayFlattenerService) {
        this.arrayFlattenerService = arrayFlattenerService;
    }

    public int[] reverseArray(int[][] embedArr) {
       int[] a_flat = arrayFlattenerService.flattenArray(embedArr);
       // int[] a_flat = new int[]{1,3,0,4,5,9};
        if(a_flat == null)
            return null;
        int i = 0;
        int j = a_flat.length - 1;
        while(i < j) {
            int temp = a_flat[i];
            a_flat[i] = a_flat[j];
            a_flat[j] = temp;
            i++;
            j--;
        }
        return a_flat;
    }










//    public static void main(String[] args) {
//        int[][] a_in = new int[][]{{1,3}, {0}, {4,5,9}};
//        int[] a_out = new ArrayReversor().reverseArray(a_in);
//        System.out.println(Arrays.toString(a_out));
//    }
}
