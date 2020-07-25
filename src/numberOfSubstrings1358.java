import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class numberOfSubstrings1358 {
    public static void main(String[] args) {
        System.out.println(new numberOfSubstrings1358().numberOfSubstrings2("abcabc"));
    }

    public int numberOfSubstrings(String s) {
        if (s.length() <= 2) return 0;
        List<String> ls = new ArrayList<>();

        for (int i = 0; i < s.length() - 2; i++) {
            for (int j = i + 2; j <= s.length(); j++) {
                ls.add(s.substring(i, j));
            }
        }
        int num = 0;
        for (String s1 : ls) {
            num += isIncludingAbc(s1) ? 1 : 0;
        }

        return num;
    }

    private boolean isIncludingAbc(String s) {
        Set<Character> hs = new HashSet<>();
        for (Character character : s.toCharArray()) {
            hs.add(character);
        }
        return hs.size() == 3;
    }

    public int numberOfSubstrings2(String s) {
        int left = 0;
        int right = 0;
        // 存储窗口内 a、b、c 的数量
        int[] temp = new int[3];
        // 记录符合要求的数量
        int sum = 0;
        temp[s.charAt(right) - 'a']++;
        while(right < s.length()){
            if(temp[0] < 1 || temp[1] < 1 || temp[2] < 1){
                right++;
                if(right == s.length()) break;
                temp[s.charAt(right) - 'a']++;
            }
            else{
                sum = sum + s.length() - right;
                temp[s.charAt(left) - 'a']--;
                left++;
            }
        }
        return sum;
    }

}
