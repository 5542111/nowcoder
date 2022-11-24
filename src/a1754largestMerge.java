public class a1754largestMerge {



    public String largestMerge(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int left = 0;
        int right = 0;
        while (left < word1.length() && right < word2.length()) {
            char leftChar = word1.charAt(left);
            char rightChar = word2.charAt(right);
            int compare = word1.substring(left).compareTo(word2.substring(right));
            if(compare<0){
                sb.append(rightChar);
                right++;
            }else{
                sb.append(leftChar);
                left++;
            }

        }
        if (left != word1.length()){
            sb.append(word1.substring(left));
        }
        if (right!= word2.length()){
            sb.append(word2.substring(right));
        }

        return sb.toString();
    }
}
