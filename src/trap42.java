public class trap42 {
    public int trap(int[] height) {
        if (height==null||height.length==1||height.length==2)
            return 0;


        int ans=0;
        int size=height.length;


        for (int i = 1; i <size-1 ; i++) {
            int maxLeft=0;
            int maxRight=0;
            for (int j=i-1;j>=0;j--)
            {
                maxLeft=Math.max(maxLeft,height[j]);
            }
            for (int j=i+1;j<size;j++)
            {
                maxRight=Math.max(maxRight,height[j]);
            }
            ans+=Math.min(maxLeft,maxRight)-height[i];

        }

        return ans;

    }

    public int trap2(int[] height){
        int sum = 0;
        //最两端的列不用考虑，因为一定不会有水。所以下标从 1 到 length - 2
        for (int i = 1; i < height.length - 1; i++) {
            int max_left = 0;
            //找出左边最高
            for (int j = i - 1; j >= 0; j--) {
                if (height[j] > max_left) {
                    max_left = height[j];
                }
            }
            int max_right = 0;
            //找出右边最高
            for (int j = i + 1; j < height.length; j++) {
                if (height[j] > max_right) {
                    max_right = height[j];
                }
            }
            //找出两端较小的
            int min = Math.min(max_left, max_right);
            //只有较小的一段大于当前列的高度才会有水，其他情况不会有水
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;

    }
}
