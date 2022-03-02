public class test {
    public static void main(String[] args) {
        System.out.println(longestAddedSubstring1("abb"));
    }

    public static String longestAddedSubstring(String str) {
        if (str.length() <= 1) return str;
        int left = 0;
        int right = 1;
        int max = 0;
        String substring =str.substring(left,right);
        while (right < str.length()) {
            if (str.charAt(right) - str.charAt(right-1) == 1) {
                max=Math.max(max,right-left);
                if (max<=right-left){
                    substring = str.substring(left,right+1);
                }
            }else{
                left=right;
            }
            right++;
        }
        return substring;
    }
    public static String longestAddedSubstring1(String str) {
        if (str.length() <= 1) return str;
        char[] ch = str.toCharArray();
        int l = 0, r= 0;
        String max = "";
        while (r < str.length()) {
            if (r+1 < str.length() && ch[r]+1 == ch[r+1]) {
                r++;
            } else {
                String temp = str.substring(l, r+1);
                l = r+1;
                r = r+1;
                if (temp.length() >= max.length()) {
                    max = temp;
                }
            }
        }
        return max;
    }

}
