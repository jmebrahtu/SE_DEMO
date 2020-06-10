package edu.mum.cs.cs425.lab11solutions.arrayutilstests.question1;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.mum.cs.cs425.lab11solutions.arrayutils.question1.ArrayFlattener;

public class ArrayFlattenerTest {
	
	private ArrayFlattener arrayFlattener = null;

	@Before
	public void setUp() throws Exception {
		this.arrayFlattener = new ArrayFlattener();
	}

	@After
	public void tearDown() throws Exception {
		this.arrayFlattener = null;
	}

	@Test
	public void testFlattenArray() {
		int[][] embedArr= { {1,3}, {0}, {4,5,9} };
		Integer[] a_out = arrayFlattener.flattenArray(embedArr);
		Integer[] expected_a_out = { 1, 3, 0, 4, 5, 9 };
		boolean areArraysEqual = Arrays.equals(a_out, expected_a_out);
		assertTrue(areArraysEqual);
	}
	
	@Test
	public void testFlattenArray2() {
		int[][] embedArr = { {1,3}, {0}, {4,5,9} };
		int[] a_out = arrayFlattener.flattenArray2(embedArr);
		int[] expected_a_out = { 1, 3, 0, 4, 5, 9 };
		boolean areArraysEqual = Arrays.equals(a_out, expected_a_out);
		assertTrue(areArraysEqual);
	}

}
