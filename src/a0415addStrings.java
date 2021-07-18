public class a0415addStrings {
    public String addStrings(String num1, String num2) {
        int len1=num1.length();
        int len2=num2.length();
        StringBuilder sb=new StringBuilder();

        int carry=0;
        int sum=0;
        while (len1>0 || len2>0){
            int a= len1>0? num1.charAt(len1-1)-'0':0;
            int b= len2>0? num2.charAt(len2-1)-'0':0;

            sum=a+b+carry;

            carry=sum/10;
            int now=sum%10;

            sb.append(now);

            len1--;
            len2--;

        }
        if (carry!=0){
            sb.append(carry);
        }

        return sb.reverse().toString();
    }
}
