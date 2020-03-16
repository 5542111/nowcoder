public class canThreePartsEqualsSum1013 {

    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (Integer a : A) {
            sum += a;
        }
        if (sum % 3 != 0) {
            return false;
        }

        int left = 0;
        int right = A.length - 1;
        int leftSum = A[left];
        int rightSum = A[right];
        while ( left+1 < right) {
            if (leftSum == sum / 3 && rightSum == sum / 3) {
                return true;
            }
            if (leftSum != sum / 3) {
                leftSum += A[++left];

            }
            if (rightSum != sum / 3) {
                rightSum += A[--right];

            }


        }


        return false;
    }
}
