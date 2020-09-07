import java.util.ArrayList;
import java.util.List;

public class fullsort26 {
    public static void main(String[] args) {
        dfs("abcd".toCharArray(), new boolean[4], 0, new ArrayList<>());
        dfs("abc".toCharArray(), new ArrayList<>());
    }

    private final List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        fullsort(nums, 0, nums.length - 1);
        return list;
    }

    public void fullsort(int[] nums, int start, int end) {

        if (start == end) {
            List<Integer> list1 = new ArrayList<>();
            for (int i : nums) {

                list1.add(i);
            }
            list.add(list1);

        }
        for (int i = start; i <= end; i++) {
            swap(nums, i, start);
            fullsort(nums, start + 1, end);
            swap(nums, i, start);
        }


    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public List<List<Integer>> permute2(int[] nums) {
        if (nums.length == 0) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, new boolean[nums.length], 0, new ArrayList<>(), res);
        return res;
    }

    public void dfs(int[] nums, boolean[] numsUsed, int level, List<Integer> list, List<List<Integer>> res) {
        //截止条件
        if (level == nums.length) {
            list = new ArrayList<>(list);
            res.add(list);
            return;
        }
        //筛选节点
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            //筛选
            if (!numsUsed[i]) {
                list.add(temp);
                numsUsed[i] = true;
                dfs(nums, numsUsed, level + 1, list, res);
                numsUsed[i] = false;
                list.remove(list.size() - 1);
                numsUsed[i] = false;
            }

        }
    }

    public static void dfs(char[] chars, boolean[] charsUsed, int level, List<Character> list) {
        //截止条件
        if (level == chars.length) {
            System.out.println(list);
            return;
        }
        //筛选节点
        for (int i = 0; i < chars.length; i++) {
            char temp = chars[i];
            //筛选
            if (!charsUsed[i]) {
                list.add(temp);
                charsUsed[i] = true;
                dfs(chars, charsUsed, level + 1, list);
                charsUsed[i] = false;
                list.remove(list.size() - 1);
            }

        }
    }

    public static void dfs(char[] chars, List<Character> list) {
        //截止条件
        if (list.size() == chars.length) {
            System.out.println(list);
            return;
        }
        //筛选节点
        for (int i = 0; i < chars.length; i++) {
            char temp = chars[i];
            //筛选
            if (temp != ' ') {
                list.add(temp);
                chars[i] = ' ';
                dfs(chars, list);
                chars[i] = temp;
                list.remove(list.size() - 1);
            }

        }
    }
}
