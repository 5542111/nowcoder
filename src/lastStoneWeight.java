
import java.util.*;

public class lastStoneWeight {
    public static void main(String[] args) {
        int[] stones={1,2,3,4,5,6,2,1,3,4,1,2,3};

        System.out.println(theLastStoneWeight(stones));
    }
    public static int theLastStoneWeight(int[] stones) {

        List<Integer> list = new ArrayList<>();
        for (int stone : stones) {
            list.add(stone);
        }
        while (list.size() > 1) {
            Collections.sort(list);
            System.out.println(list);
            int x=list.remove(list.size()-2);
            int y=list.remove(list.size()-1);

            if (x<y)
            {
                list.add(y-x);
            }
            System.out.println(list);

        }

        if (list.size()==0)
        {
            return 0;
        }
        return list.get(0);
    }

}
