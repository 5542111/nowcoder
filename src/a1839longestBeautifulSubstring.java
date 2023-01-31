public class a1839longestBeautifulSubstring {
    public static void main(String[] args) {
        System.out.println(new a1839longestBeautifulSubstring().longestBeautifulSubstring("aeiaaioaaaaeiiiiouuuooaauuaeiu"));
    }

    public int longestBeautifulSubstring(String word) {
        if (word.length() < 5) return 0;

        int ans = 0;
        int right = 1;
        int cnt = 1;
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) >= word.charAt(i - 1)) right++;
            if (word.charAt(i) > word.charAt(i - 1)) cnt++;
            if (word.charAt(i) < word.charAt(i - 1)) {
                right = 1;
                cnt = 1;
            }
            if (cnt == 5) ans = Math.max(right, ans);
        }
        return ans;

    }
}
