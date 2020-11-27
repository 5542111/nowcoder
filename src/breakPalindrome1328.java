public class breakPalindrome1328 {
    public String breakPalindrome(String palindrome) {
        int len = palindrome.length(), half = (len - 2) >> 1;
        if (len < 2) return "";
        char[] charArr = palindrome.toCharArray();
        for (int i = 0; i <= half; ++i)
            if (charArr[i] > 'a') {
                charArr[i] = 'a';
                return String.valueOf(charArr);
            }
        charArr[len - 1] = 'b';
        return String.valueOf(charArr);

    }
}
