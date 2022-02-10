public class a0011maxArea {

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max=Integer.MIN_VALUE;
        while (left < right) {
            max=Math.max(max,Math.min(height[left],height[right])*(right-left));
            if (height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return max;
    }
}
