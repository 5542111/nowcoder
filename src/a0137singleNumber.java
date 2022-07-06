import java.util.HashMap;
import java.util.Map;

public class a0137singleNumber {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        for (int num : nums) {
            if (countMap.get(num) == 1) return num;
        }
        return -1;
    }

    public int singleNumber2(int[] nums) {
        int[] bitmap = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                if (((num >> i) & 1) == 1) {
                    bitmap[i]++;
                }
            }
        }
//        int res = 0;
//        for (int i = 0; i < 32; i++) {
//            if ((bitmap[i] % 3 & 1) == 1) {
//                res += (1 << i);
//            }
//        }
//        return res;
        StringBuilder sb = new StringBuilder();
        for (int i = 31; i >= 0; i--) {
            sb.append(bitmap[i] % 3);
        }
        return Integer.parseUnsignedInt(sb.toString(), 2);
    }
}
