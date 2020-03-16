public class bitOperation {

    public static void main(String[] args) {
        System.out.println(add(10, -5));
        System.out.println(minus(10, -5));
        System.out.println(multiple(10, -5));
        System.out.println(div(-10, 3));
    }
    public static int add(int a,int b)
    {
        while (b!=0)
        {
            int sum=a^b;
            int carry=(a&b)<<1;
            a=sum;
            b=carry;
        }
        return a;
    }
    public static int minus(int a,int b)
    {
        int B=~(b-1);
        return add(a,B);
    }
    public static  int multiple(int a,int b){
        if (a>=0&&b>=0)
        {
            return multipleHelper(a,b);
        }
       else if (a>=0&&b<0)
        {
            return -multipleHelper(a,-b);
        }
       else if (a<0&&b>=0)
        {
            return -multipleHelper(-a,b);
        }
        else
        {
            return multipleHelper(-a, -b);
        }

    }
    private  static int multipleHelper(int a,int b){
        int i=0;
        int res=0;
        while(b!=0){//乘数为0则结束
            //处理乘数当前位
            if((b&1)==1){
                res+=(a<<i);
                b=b>>1;
                ++i;//i记录当前位是第几位
            }else{
                b=b>>1;
                ++i;
            }
        }
        return res;
    }
    public static int div(int dividend,int divisor)
    {
        boolean sign = (dividend > 0) ^ (divisor > 0);
        int result = 0;
        if(dividend>0) {
            dividend = -dividend;
        }
        if(divisor>0) divisor = -divisor;
        while(dividend <= divisor) {
            int temp_result = -1;
            int temp_divisor = divisor;
            while(dividend <= (temp_divisor << 1)) {
                if(temp_divisor <= (Integer.MIN_VALUE >> 1))break;
                temp_result = temp_result << 1;
                temp_divisor = temp_divisor << 1;
            }
            dividend = dividend - temp_divisor;
            result += temp_result;
        }
        if(!sign) {
            if(result <= Integer.MIN_VALUE) return Integer.MAX_VALUE;
            result = - result;
        }
        return result;

    }





}
