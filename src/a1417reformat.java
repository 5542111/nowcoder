import java.util.ArrayList;
import java.util.List;

public class a1417reformat {
    public String reformat(String s) {
        List<Character> letters = new ArrayList<>();
        List<Character> digits = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                digits.add(c);
            } else {
                letters.add(c);
            }
        }
        if (Math.abs(letters.size() - digits.size()) > 1) return "";
        boolean flag = letters.size() >= digits.size();
        int letterIndex = 0;
        int digitsIndex = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (flag) {
                sb.append(letters.get(letterIndex++));
                flag = false;
            } else {
                sb.append(digits.get(digitsIndex++));
                flag = true;
            }
        }
        return sb.toString();
    }
}
