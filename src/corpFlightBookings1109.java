public class corpFlightBookings1109 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
         int[] ans=new int[5];
         for (int i=0;i<bookings.length;i++)
         {
            for (int j=bookings[i][0];j<bookings[i][1];j++)
            {
                ans[j]+=bookings[i][2];
            }
         }
         return ans;
    }
}
