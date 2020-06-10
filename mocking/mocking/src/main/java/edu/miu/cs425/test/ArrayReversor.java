import service.ArrayFlatternerService;

public class ArrayReversor {

    private ArrayFlatternerService arrayFlatternerService;

   public ArrayReversor(ArrayFlatternerService arrayFlatternerService) {
       this.arrayFlatternerService = arrayFlatternerService;
   }

    public int[] reveresArray(int[][] a_in) {
        int[] a_flat = arrayFlatternerService.flattenArray(a_in);
        if (a_flat == null)
            return null;
        int i = 0;
        int j = a_flat.length - 1;
        while (i < j) {
            int temp = a_flat[i];
            a_flat[i] = a_flat[j];
            a_flat[j] = temp;
            i++;
            j++;
        }
        return a_flat;
    }

}


