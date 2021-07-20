import java.util.ArrayList;
import java.util.List;

public class a0046permute {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }

        dfs(0,list);
        return res;
    }

    private void dfs(int k, List<Integer> list) {
        if (k == list.size()) {
            List<Integer> temp = new ArrayList<>(list);
            res.add(temp);
            return;
        }
        for (int i = k; i < list.size(); i++) {
            swap(list,k,i);
            dfs(k+1,list);
            swap(list,k,i);
        }
    }

    private void swap(List<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
