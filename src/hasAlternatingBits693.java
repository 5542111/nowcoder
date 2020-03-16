public class hasAlternatingBits693 {
    public boolean hasAlternatingBits(int n) {


        int  turn=1;
        while (n!=0)
        {
            if ((n&1)==1&&turn==1)
            {
                n=(n>>1);
                turn=0;
            }
            if ((n&1)==0&&turn==0)
            {
                n=(n>>1);
                turn=1;
            }
        }
        return turn==1;
    }
}
