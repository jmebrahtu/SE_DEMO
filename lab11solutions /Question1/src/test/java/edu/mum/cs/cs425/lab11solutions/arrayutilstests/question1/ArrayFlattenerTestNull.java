package edu.mum.cs.cs425.lab11solutions.arrayutilstests.question1;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.mum.cs.cs425.lab11solutions.arrayutils.question1.ArrayFlattener;

public class ArrayFlattenerTestNull {
	
	private ArrayFlattener arrayFlattener;

	@Before
	public void setUp() throws Exception {
		this.arrayFlattener = new ArrayFlattener();
	}

	@After
	public void tearDown() throws Exception {
		this.arrayFlattener = null;
	}

	@Test
	public final void testFlattenArray() {
		int[][] embedArr = null;
		Integer[] a_out = arrayFlattener.flattenArray(embedArr);
		Integer[] expected_a_out = null;
		boolean areArraysEqual = Arrays.equals(a_out, expected_a_out);
		assertTrue(areArraysEqual);
	}
	
	@Test
	public final void testFlattenArray2() {
		int[][] embedArr = null;
		int[] a_out = arrayFlattener.flattenArray2(embedArr);
		int[] expected_a_out = null;
		boolean areArraysEqual = Arrays.equals(a_out, expected_a_out);
		assertTrue(areArraysEqual);
	}
}
