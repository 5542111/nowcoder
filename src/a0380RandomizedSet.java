import java.util.*;

public class a0380RandomizedSet {

    private List<Integer> list;
    private Map<Integer, Integer> indexMap;
    private Random random;

    public a0380RandomizedSet() {
        list = new ArrayList<>();
        random = new Random();
        indexMap = new HashMap<>();
    }

    public boolean insert(int val) {
        if (list.contains(val)) {
            return false;
        }
        indexMap.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (list.contains(val)) {
            int index = indexMap.get(val);
            int right = list.get(list.size() - 1);
            list.set(index, right);
            indexMap.put(right, index);
            indexMap.remove(val);
            list.remove(list.size() - 1);
            return true;
        }
        return false;
    }

    public int getRandom() {
        int randomIndex = random.nextInt(list.size());
        return list.get(randomIndex);
    }
}
