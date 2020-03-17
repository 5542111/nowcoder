import java.util.HashMap;
import java.util.Map;

public class countCharacters1160 {
    public int countCharacters(String[] words, String chars) {
        int[] counter = new int[26];
        for (char c : chars.toCharArray()) {
            counter[c - 'a']++;
        }
        int len=0;
        for(String word:words)
        {
            len+=word.length();
            int[] wordCounter=new int[26];
            for (char c : word.toCharArray()) {
                wordCounter[c - 'a']++;
            }
            for (int i=0;i<26;i++)
            {
                if (wordCounter[i]>counter[i])
                {
                    len-=word.length();
                    break;
                }
            }


        }

        return len;
    }
}
