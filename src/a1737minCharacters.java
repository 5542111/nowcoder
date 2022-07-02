public class a1737minCharacters {
    public int minCharacters(String a, String b) {
        int[] countA = new int[26];
        int[] countB = new int[26];
        int res = Integer.MAX_VALUE;
        for (char c : a.toCharArray()) {
            countA[c - 'a']++;
        }
        for (char c : b.toCharArray()) {
            countB[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            res = Math.min(res, a.length() - countA[i] + b.length() - countB[i]);
            if (i == 0) continue;
            int r1 = 0, r2 = 0;
            //左右遍历
            for (int j = i; j < 26; j++) {
                r1 += countA[j];
            }
            for (int j = 0; j < i; j++) {
                r1 += countB[j];
            }

            for (int j = i; j < 26; j++) {
                r2 += countB[j];
            }
            for (int j = 0; j < i; j++) {
                r2 += countA[j];
            }
            res = Math.min(res, Math.min(r1, r2));
        }

        return res;
    }

}
