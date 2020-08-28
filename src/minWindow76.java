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
    public String minWindow(String s, String t) {
        int[] need=new int[26];
        int left = 0;
        int right = 0;
        int minLen = Integer.MAX_VALUE;
        String res;
        while (right < s.length()) {

        }


        return s.substring(left, left);
    }
}
