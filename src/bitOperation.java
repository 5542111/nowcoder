public class bitOperation {

    public int add(int a,int b)
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
    public int minus(int a,int b)
    {
        int B=~(b-1);
        return add(a,B);
    }

    public int multiple(int a,int b)
    {
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
    public  int div(int a,int b)
    {
        int res=-1;
        if (a<b){
            return 0;
        }
        else {
            res=div(minus(a,b),b)+1;
        }
        return res;
    }


}
