public class a0565arrayNesting {
    public int arrayNesting(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int cnt = 0;
            while (!visited[i]) {
                visited[i] = true;
                i = nums[i];
                cnt++;
            }
            res = Math.max(res, cnt);
        }

        return res;
    }
}
