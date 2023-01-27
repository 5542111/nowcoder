import java.lang.reflect.Array;
import java.util.Arrays;

public class a1405longestDiverseString {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();

        Pair[] arr = {new Pair(a, 'a'), new Pair(b, 'b'), new Pair(c, 'c')};

        while (true) {
            Arrays.sort(arr, (o1, o2) -> o2.freq - o1.freq);
            boolean isEnd = false;
            for (Pair pair : arr) {
                if (pair.freq < 1) {
                    break;
                }
                int len = sb.length();
                if (len >= 2 && pair.letter == sb.charAt(len - 2) && pair.letter == sb.charAt(len - 1)) {
                    continue;
                }
                isEnd = true;
                sb.append(pair.letter);
                pair.freq--;
                break;
            }
            if (!isEnd) {
                break;
            }
        }
        return sb.toString();
    }

    class Pair {
        private int freq;
        private char letter;

        public Pair(int freq, char letter) {
            this.freq = freq;
            this.letter = letter;
        }

        public int getFreq() {
            return freq;
        }

        public void setFreq(int freq) {
            this.freq = freq;
        }

        public char getLetter() {
            return letter;
        }

        public void setLetter(char letter) {
            this.letter = letter;
        }
    }
}
