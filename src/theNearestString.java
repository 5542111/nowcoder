import java.util.Arrays;

public class theNearestString {
        public static void main(String[] args) {

            System.out.println(NearestString("98199"));
        }

        private static String NearestString(String str) {
            StringBuffer sb = new StringBuffer();
            int len = str.length();
            if (len == 2) {
                new StringBuffer(str).reverse().toString();
            }
            int i = len - 2;
            for (; i > 0; i--) {
                if (str.charAt(i) >= str.charAt(i + 1)) {
                    continue;
                }
                break;
            }
            if (i==0)
            {
                sb.append(str.charAt(len-1));
                char[] ss=str.substring(0,len-1).toCharArray();
                Arrays.sort(ss);
                sb.append(ss);
            }
            else{
                sb.append(str.substring(0, i));
                sb.append(str.charAt(i + 1));
                StringBuffer res = new StringBuffer();
                for (int j = i; j < len; j++) {
                    if (j == i + 1) {
                        continue;
                    }
                    res.append(str.charAt(j));
                }
                char[] ss = res.toString().toCharArray();
                Arrays.sort(ss);
                for (char c:ss)
                {
                    sb.append(c);
                }

            }
            return sb.toString();
        }
}
