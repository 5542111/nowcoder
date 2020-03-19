public class maxWidthRamp962 {


    public int maxWidthRamp(int[] A) {
        int max=0;


        for (int i = 0; i < A.length; i++) {

            for (int j = i + 1; j < A.length; j++) {
                if (A[i]<=A[j])
                {
                    if (max<j-i)
                    {
                        max=j-i;
                    }
                }
            }
        }

        return max;
    }
}
