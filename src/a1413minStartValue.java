public class a1413minStartValue {
    public int minStartValue(int[] nums) {
        int sum = 0;
        int res = 1;
        for (int num : nums) {
            sum = sum + num;
            if (sum < 1){
                res =Math.max(1-sum,res);
            }

        }
        return res;
    }
}
