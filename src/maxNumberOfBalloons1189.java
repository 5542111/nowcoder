import java.util.HashMap;
import java.util.Map;

public class maxNumberOfBalloons1189 {
    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> hashMap = new HashMap<>();
        char[] chars = text.toCharArray();
        for (char c = 'a'; c <= 'z'; c++) {
            hashMap.put(c, 0);
        }
        for (int i = 0; i < chars.length; i++) {
            hashMap.put(chars[i], hashMap.get(chars[i]) + 1);
        }

        int[] ans = new int[5];
        ans[0] = hashMap.get('a');
        ans[1] = hashMap.get('b');
        ans[2] = hashMap.get('l') / 2;
        ans[3] = hashMap.get('o') / 2;
        ans[4] = hashMap.get('n');
        int count = ans[0];
        for (int i = 1; i < 5; i++) {
            if (ans[i] < count) {
                count = ans[i];
            }
        }


        return count;
    }

    public int maxNumberOfBalloons1(String text) {
        int[] ans = new int[5];
        for (int i = 0; i < text.length(); i++) {
            switch (text.charAt(i)) {
                case 'a':
                    ans[0]++;
                    break;
                case 'b':
                    ans[1]++;
                    break;
                case 'l':
                    ans[2]++;
                    break;
                case 'o':
                    ans[3]++;
                    break;
                case 'n':
                    ans[4]++;
                    break;
                default:
                    break;
            }
        }
        ans[2] /= 2;
        ans[3] /= 2;
        int count = ans[0];
        for (int i = 1; i < 5; i++) {
            if (ans[i] < count) {
                count = ans[i];
            }
        }


        return count;
    }

}
