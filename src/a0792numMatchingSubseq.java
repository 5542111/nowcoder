import java.util.HashMap;
import java.util.Map;

public class a0792numMatchingSubseq {


    public int numMatchingSubseq(String s, String[] words) {
        int count =0;
        Map<String,Boolean> map =new HashMap<>();
        for (String word : words) {
            Boolean orDefault = map.get(word);
            if (orDefault == null){
                if (isSubSeq(word,s)){
                    map.put(word,true);
                    count++;
                }else{
                    map.put(word,false);
                }
            }else if (orDefault){
                count++;
            }
        }
        return count;
    }


    private  boolean isSubSeq(String s, String word) {
        int i = 0, j = 0;
        while (i < s.length() && j < word.length()) {
            if (s.charAt(i) == word.charAt(j)){
                i++;
            }
            j++;
        }
        return  i == s.length();
    }
}
