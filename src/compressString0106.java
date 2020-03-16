public class compressString0106 {
    public static void main(String[] args) {
        System.out.println(compressString(""));
    }

    public static String compressString(String S) {

        if (S==null||S.length()<=1)
            return S;

        StringBuffer stringBuffer = new StringBuffer();
        Integer len = new Integer(1);
        for (int i = 0; i < S.length() - 1; i++) {

            //System.out.println( S.charAt(i)+" "+i);
            if (S.charAt(i) != S.charAt(i+1)) {
                stringBuffer.append(S.charAt(i));
               // System.out.println(S.charAt(i));
                stringBuffer.append(len);
                len=1;
            }
            else {

                len++;

            }


        }
        stringBuffer.append(S.charAt(S.length()-1));
        stringBuffer.append(len);


        if (stringBuffer.length()>=S.length())
        {
            return S;
        }

        return stringBuffer.toString();
    }
}

