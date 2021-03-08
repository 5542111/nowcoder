import java.util.HashMap;

public class isPossibleDivide1296 {
    public static void main(String[] args) {
        System.out.println(new isPossibleDivide1296().isPossibleDivide(new int[]{1,3,4,5}, 4));
    }
    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0) return false;

        HashMap<Integer, Integer> hm = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            int count = hm.getOrDefault(num, 0);
            hm.put(num, count + 1);
            min=Math.min(num,min);
        }
        int num=k;
        int now=min;
        int count = nums.length;
        while (count > 0) {
            now = min;
            num=k;

            while (num >0) {
                if(hm.containsKey(now)){
                    int cnt =hm.get(now);
                    if(cnt>0){
                        hm.put(now,cnt-1);
                    }else{
                        return false;
                    }
                    now++;
                    num--;
                }else{
                    return false;
                }

            }

            count -= k;
            if (count>0){
                now=min;
                while(true){
                    if(hm.containsKey(now)&&hm.get(now)>0)
                    {
                        break;
                    }
                    now++;
                }
                min=now;
            }





        }
        return true;
    }
}
