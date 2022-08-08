import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class a0761makeLargestSpecial {
    public static void main(String[] args) {
        new a0761makeLargestSpecial().makeLargestSpecial("11011000");
    }

    /**
     * https://leetcode.cn/problems/special-binary-string/solution/te-shu-de-er-jin-zhi-xu-lie-by-capital-w-81ht/
     * @param s
     * @return
     */
    public String makeLargestSpecial(String s) {
        if (s.length() == 0) return "";
        List<String> list = new ArrayList<>();
        int count = 0, last = 0;

        for (int i = 0, cur = 0; i < s.length(); i++, cur++) {
            if (s.charAt(i) == '1') {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                String str = "1" + makeLargestSpecial(s.substring(last + 1, cur)) + "0";
                list.add(str);
                last = cur + 1;
            }
        }
        list.sort(Comparator.reverseOrder());
        StringBuilder sb=new StringBuilder();
        list.forEach(sb::append);
        return sb.toString();
    }
}
