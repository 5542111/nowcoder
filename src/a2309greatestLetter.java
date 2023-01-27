public class a2309greatestLetter {
    public static void main(String[] args) {
        System.out.println(new a2309greatestLetter().greatestLetter("lEeTcOdE"));
    }
    public String greatestLetter(String s) {
        StringBuilder ans = new StringBuilder();
        int[] letters = new int[26];
        int[] letters2 = new int[26];
        for (char c : s.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                letters2[c - 'A']++;
            } else {
                letters[c - 'a']++;
            }
        }
        for (int i = letters.length - 1; i >= 0; i--) {
            if (letters2[i] > 0 && letters[i] > 0) {
                ans.append((char) (i + 'A'));
                return ans.toString();
            }
        }

        return ans.toString();
    }
}
