package edu.mum.cs.cs425.lab11solutions.arrayutils.question1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayFlattener {
	
	public Integer[] flattenArray(int[][] embedArr) {
		if (embedArr == null)
			return null;
        List<Integer> list = new ArrayList<>();
        for (int[] arr : embedArr) {
            for (int i : arr) {
                list.add(i);
            }
        }
        return (Integer[]) list.toArray(new Integer[list.size()]);
    }		
	
	public int[] flattenArray2(int[][] embedArr) {
		if (embedArr == null)
			return null;
		return Arrays.stream(embedArr)
				.flatMapToInt(arr -> Arrays.stream(arr))
				.toArray();
	}
}
