import java.util.ArrayList;
import java.util.List;

public class a0077combine {
    public static void main(String[] args) {
        new a0077combine().combine(7, 2);
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();

        dfs(1, n, k, new ArrayList<>(), res);
        System.out.println(res);
        return res;
    }

    private void dfs(int index, int n, int k, List<Integer> temp, List<List<Integer>> res) {

        if (temp.size() == k) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i <= n; i++) {
            temp.add(i);
            dfs(i + 1, n, k, temp, res);
            temp.remove(temp.size() - 1);
        }
    }
}
