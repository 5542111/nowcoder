import java.util.*;

public class combinationSum39 {
    public static void main(String[] args) {
        //[]
        //8
        System.out.println(new combinationSum39().combinationSum(new int[]{1,2}, 4));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) {
            return new ArrayList<>();
        }
        Set<List<Integer>> res = new HashSet<>();
        dfs(candidates, target, new ArrayList<>(), res);
        List<List<Integer>> ans = new ArrayList<>();
        for (List<Integer> list : res) {
            ans.add(list);
        }
        return ans;
    }

    public void dfs(int[] candidates, int target, List<Integer> temp, Set<List<Integer>> res) {
        int sum = sum(temp);
        if (sum >= target) {
            if (sum == target) {
                temp=new ArrayList<>(temp);
                Collections.sort(temp);
                res.add(temp);
            }
            return;
        }


        for (int i = 0; i < candidates.length; i++) {
            temp.add(candidates[i]);
            dfs(candidates, target, temp, res);
            temp.remove(temp.size() - 1);
        }

    }

    public int sum(List<Integer> temp) {
        int sum = 0;
        for (Integer i : temp) {
            sum += i;
        }
        return sum;
    }

}
