public class ReverseStrInK {
    public static void main(String[] args) {
        System.out.println(reverseStr1("abcde", 2));
    }

    public static String reverseStr(String s, int k) {
        StringBuffer stringBuffer = new StringBuffer();
        int flag = 1;
        for (int i = 0; i < s.length(); i += (2 * k)) {
            if (flag == 1) {
                if (i + k - 1 < s.length()) {
                    for (int j = i + k - 1; j >= i; j--) {
                        stringBuffer.append(s.charAt(j));
                    }

                } else {
                    for (int j = s.length() - 1; j >= i; j--) {
                        stringBuffer.append(s.charAt(j));
                    }

                }

                flag = 0;
                //System.out.println(stringBuffer.toString());
            }


            if (flag == 0) {
                if (i + k < s.length()) {
                    for (int j = i + k; j < i + 2 * k && j < s.length(); j++) {
                        stringBuffer.append(s.charAt(j));
                    }

                }
                flag = 1;

                //System.out.println(stringBuffer.toString());
            }

        }


        return stringBuffer.toString();

    }

    public static String reverseStr1(String s, int k) {

        if (s == null || s.length() == 0) return "";
        if (k > s.length()) return s;

        int len = s.length();
        char[] chars=s.toCharArray();
        for (int i = 0; i < len/k ; i++) {
            int start=i*k;
            int end=(i+1)*k-1;
            while(start<end){
                char temp=chars[start];
                chars[start]=chars[end];
                chars[end]=temp;
                start++;
                end--;
            }
        }

        return new String(chars);
    }

}
