public class a1769minOperations {

    public int[] minOperations(String boxes) {
        int[] ans = new int[boxes.length()];
        for (int i = 0; i < boxes.length(); i++) {
            for (int j = 0; j < boxes.length(); j++) {
                ans[i] += boxes.charAt(j) == '1' ? Math.abs(j - i) : 0;
            }
        }
        return ans;
    }

    public int[] minOperations2(String boxes) {
        int[] ans = new int[boxes.length()];
        int left = boxes.charAt(0) == '1' ? 1 : 0;
        int right = 0;
        //先计算到第一个盒子的op
        for (int i = 1; i < boxes.length(); i++) {
            if (boxes.charAt(i) == '1') {
                ans[0] += i;
                right++;
            }
        }
        int ops = ans[0];
        //再计算其他盒子的op
        for (int i = 1; i < boxes.length(); i++) {
            ops += left;
            ops -= right;
            if (boxes.charAt(i) == '1') {
                left++;
                right--;
            }
            ans[i] = ops;
        }
        return ans;
    }
}
