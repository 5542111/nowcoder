public class characterReplacement424 {
    public int characterReplacement(String s, int k) {
        int[] map = new int[26];
        int left = 0, right = 0;
        int maxCount = 0;
        int res = 0;

        for (; right < s.length(); res++) {
            map[s.charAt(right) - 'A']++;
          //  maxCount = Math.max(maxCount, map[s.charAt(right) - 'A']);
            if (right - left + 1 - k <= 0) {
                res=Math.max(res,right-left+1);
            }else {
                map[s.charAt(left)-'A']--;
                left++;

            }
        }
        return res;
    }

}
