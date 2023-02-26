
public class a1255maxScoreWords {
    private int ans;
    private String[] words;
    private int[] score;

    private int[] left;

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        this.score = score;
        this.words = words;
        this.left = new int[26];
        for (char letter : letters) {
            this.left[letter - 'a']++;
        }
        dfs(words.length-1,0);
        return ans;
    }

    private void dfs(int index, int count) {
        if (index < 0) {
            ans = Math.max(ans, count);
            return;
        }
        dfs(index - 1, count);

        char[] chars = words[index].toCharArray();
        boolean isSelected = true;
        for (char c : chars) {
            if (left[c - 'a']-- == 0) {
                isSelected = false;
            }
            count += score[c - 'a'];
        }
        if (isSelected) {
            dfs(index - 1, count);
        }

        for (char c : chars) {
            left[c - 'a']++;
        }

    }
}
