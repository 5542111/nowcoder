import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class findRestaurant599 {

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<Integer, ArrayList<String>> hs=new HashMap<>();
        for (int i=0;i<list1.length;i++)
        {
            for (int j=0;j<list2.length;j++)
            {
                if (list1[i].equals(list2[j]))
                {
                    if (!hs.containsKey(i+j))
                    {
                        hs.put(i+j, new ArrayList<>());
                    }
                    hs.get(i+j).add(list1[i]);
                }
            }
        }

        int min=Integer.MAX_VALUE;

        for (Integer i:hs.keySet())
        {
            if (i<min)
            {
                min=i;
            }
        }

        return hs.get(min).toArray(new String[hs.get(min).size()]);

    }
}
