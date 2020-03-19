public class ReverseStrInK {
    public static void main(String[] args) {
        System.out.println(reverseStr("abcde", 2));
    }

    public static String reverseStr(String s, int k) {
        StringBuffer stringBuffer = new StringBuffer();
        int flag = 1;
        for (int i = 0; i < s.length(); i += (2 * k)) {
            if (flag == 1) {
               if (i+k-1<s.length())
                {
                    for (int j = i + k - 1; j >= i; j--) {
                        stringBuffer.append(s.charAt(j));
                    }

                }
                else {
                    for (int j=s.length()-1;j >= i; j--) {
                        stringBuffer.append(s.charAt(j));
                    }

               }

                flag = 0;
                //System.out.println(stringBuffer.toString());
            }


            if (flag == 0) {
                if (i+k<s.length())
                {
                    for (int j = i + k; j < i+2*k&&j<s.length(); j++) {
                        stringBuffer.append(s.charAt(j));
                    }

                }
                flag = 1;

                //System.out.println(stringBuffer.toString());
            }

        }


        return stringBuffer.toString();

    }



}
