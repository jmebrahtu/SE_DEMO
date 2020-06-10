package edu.mum.cs.cs425.lab11solutions.arrayutilstests.Question2;

import edu.mum.cs.cs425.lab11solutions.arrayutils.Question2.ArrayReversor;
import edu.mum.cs.cs425.lab11solutions.arrayutils.Question2.service.ArrayFlattenerService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ArrayReversorNullTest {
    private ArrayReversor arrayReversor;

    private ArrayFlattenerService arrayFlattenerService = mock(ArrayFlattenerService.class);

    @Before
    public void setUp() throws Exception {
        this.arrayReversor = new ArrayReversor(arrayFlattenerService);
    }

    @After
    public void tearDown() throws Exception {
        this.arrayReversor = null;
    }

    @Test
    public void testReverseArrayNull() {
        int[][] embedArr = null;
        when(arrayFlattenerService.flattenArray(embedArr)).thenReturn(null);
        int[] actual = arrayReversor.reverseArray(embedArr);
        int[] expected = null;
        Arrays.equals(expected,actual);
        assertTrue( Arrays.equals(expected,actual));
    //assertArrayEquals(expected,actual);
        verify(arrayFlattenerService).flattenArray(embedArr);
    }
}