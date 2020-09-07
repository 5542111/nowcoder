import java.util.*;

public class permuteUnique47 {
    public static void main(String[] args) {
        System.out.println(new permuteUnique47().permuteUnique(new int[]{1, 1, 2}));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer integer : nums) {
            if (map.containsKey(integer)) {
                int temp = map.get(integer);
                map.put(integer, temp + 1);
            } else {
                map.put(integer, 1);
            }
        }
        int[] num = new int[map.size()];
        int[] numCount = new int[map.size()];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            num[index] = entry.getKey();
            numCount[index] = entry.getValue();
            index++;
        }

        List<List<Integer>> res = new ArrayList<>();
        dfs(nums.length, num, numCount, new ArrayList<>(), res);
        return res;

    }

    public void dfs(int size, int[] nums, int[] numsCount, List<Integer> temp, List<List<Integer>> res) {
        if (temp.size() == size) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (numsCount[i] > 0) {
                temp.add(nums[i]);
                numsCount[i]--;
                dfs(size, nums, numsCount, temp, res);
                numsCount[i]++;
                temp.remove(temp.size() - 1);
            }
        }
    }


}
