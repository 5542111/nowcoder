import java.util.HashSet;
import java.util.Set;

public class a1805numDifferentIntegers {
    public static void main(String[] args) {
        System.out.println(new a1805numDifferentIntegers().numDifferentIntegers("a1b01c001"));
    }

    public int numDifferentIntegers(String word) {
        Set<String> set = new HashSet<>();
        String[] split = word.split("[a-z]+");
        for (String s : split) {
            if (s == null || s.trim().length() == 0) {
                continue;
            }

            int p = 0;
            while (p < s.length() && s.charAt(p) == '0') {
                p++;
            }
            if (p == s.length()) {
                s = "0";
            }else{
                s = s.substring(p);
            }
            set.add(s);

        }
        System.out.println(set);
        return set.size();
    }
}
