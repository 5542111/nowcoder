import java.util.LinkedList;
import java.util.Queue;

public class subtractProductAndSum1281 {
    public int subtractProductAndSum(int n) {

        int add=0;
        int multi=1;
        while (n>0)
        {
            int div=n%10;
            n/=10;
            add+=div;
            multi*=div;

        }

        return multi-add;

    }
}
