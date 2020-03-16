import java.awt.*;
import java.security.PrivateKey;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class distinctSubseqII940 {
    private static Set<String> hashset=new HashSet<>();

    public static void main(String[] args) {
        System.out.println(distinctSubseqII("pcre"));
    }
    public static int distinctSubseqII(String S) {
            printAllSub(S.toCharArray(),0,"");
        for (String s:
             hashset) {
            System.out.println(s);
        }
            return hashset.size()-1;
    }
    public static void printAllSub(char[] str, int i, String res) {
        if (i == str.length) {
            hashset.add(res);
            System.out.println(res);
            return ;
        } else {
            printAllSub(str, i + 1, res); // 不要下标为i+1的字符
            printAllSub(str, i + 1, res+str[i]); // 要第i+1个字符
        }
    }




}





