import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class minWindow76 {
    public static void main(String[] args) {
        Map<Integer,String> hs=new HashMap<>();
        for (Integer i = 0; i <15 ; i++) {
            hs.put(i,i.toString());
        }
        Iterator<Map.Entry<Integer,String>> iterator=hs.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer,String> set=iterator.next();
            System.out.println(set.getKey()+"+"+set.getValue());
        }
        System.out.println(hs.size());


    }
    public static String minWindow(String s, String t) {
        if (s == null || s == "" || t == null || t == "" || s.length() < t.length()) {
            return "";
        }
        //用来统计t中每个字符出现次数
        int[] needs = new int[128];
        //用来统计滑动窗口中每个字符出现次数
        int[] window = new int[128];

        for (int i = 0; i < t.length(); i++) {
            needs[t.charAt(i)]++;
        }

        int left = 0;
        int right = 0;

        String res = "";

        //目前有多少个字符
        int count = 0;

        //用来记录最短需要多少个字符。
        int minLength = s.length() + 1;

        while (right < s.length()) {
            char ch = s.charAt(right);
            window[ch]++;
            if (needs[ch] > 0 && needs[ch] >= window[ch]) {
                count++;
            }

            //移动到不满足条件为止
            while (count == t.length()) {
                ch = s.charAt(left);
                if (needs[ch] > 0 && needs[ch] >= window[ch]) {
                    count--;
                }
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    res = s.substring(left, right + 1);

                }
                window[ch]--;
                left++;

            }
            right++;

        }
        return res;
    }
}
