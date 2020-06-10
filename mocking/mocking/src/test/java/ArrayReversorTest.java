import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import service.ArrayFlatternerService;
import  static org.junit.Assert.*;
import  static org.mockito.Mockito.*;

public class ArrayReversorTest  {

    private ArrayFlatternerService arrayFlatternerService= mock(ArrayFlatternerService.class);
      private  ArrayReversor arrayReversor;

   // public ArrayReversorTest(ArrayFlatternerService arrayFlatternerService) {

   // }

    @Before
    public void setUp() throws Exception {
        this.arrayReversor = new ArrayReversor(arrayFlatternerService);

    }
@After
    public void tearDown() throws Exception {
        this.arrayReversor= null;
    }
    @Test
    public  void reverseArray(){
        int[][]a_in= new int[][]{{1,3},{0},{4,5,9}};
        when(arrayFlatternerService.flattenArray(a_in)).thenReturn(new int[]{1,3,0,4,5,9});
        int[] output=arrayReversor.reveresArray(a_in);
        int[] expected={9,5,4,0,3,1};
        asserArrayEquals(expected,output);
        verify(arrayFlatternerService.flattenArray(a_in));
        }

    private void asserArrayEquals(int[] expected, int[] output) {
    }


}