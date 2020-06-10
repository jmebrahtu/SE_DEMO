import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import service.ArrayFlatternerService;

import static org.mockito.Mockito.*;

public class ArrayReversorNullTest {

    private ArrayFlatternerService arrayFlatternerService = mock(ArrayFlatternerService.class);
    private ArrayReversor arrayReversor;

   // public ArrayReversorNullTest(ArrayFlatternerService arrayFlatternerService) {

    //}

    @Before
    public void setUp() throws Exception {
        this.arrayReversor = new ArrayReversor(arrayFlatternerService);

    }

    @After
    public void tearDown() throws Exception {
        this.arrayReversor = null;
    }

    @Test
    public void reverseArray() {
        int[][] a_in = null;
        when(arrayFlatternerService.flattenArray(a_in)).thenReturn(null);
        int[] output = arrayReversor.reveresArray(a_in);
        int[] expected = null;
        asserArrayEquals(expected, output);
        verify(arrayFlatternerService.flattenArray(a_in));
    }

    private void asserArrayEquals(int[] expected, int[] output) {
    }
}
