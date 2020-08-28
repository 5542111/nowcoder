import java.util.HashMap;

public class lengthOfLongestSubstring02 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("asdedf"));
    }
    public static int lengthOfLongestSubstring(String s) {
        int  size,i=0,j,k,max=0;
        size = s.length();
        for(j = 0;j<size;j++){
            for(k = i;k<j;k++)
                if(s.charAt(j)==s.charAt(k)){
                    i = k+1;
                    break;
                }
            if(j-i+1 > max)
                max = j-i+1;
        }
        return max;
    }
    public static int lengthOfLongestSubstring1(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.getOrDefault(s.charAt(i),0) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;
    }
}
