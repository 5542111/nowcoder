import java.util.Arrays;

public class merge1001 {
    public void merge(int[] A, int m, int[] B, int n) {

        for (int i=m;i<m+n;i++)
        {
            A[i]=B[i-m];
        }
        Arrays.sort(A);
    }
}
