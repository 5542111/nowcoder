import java.util.*;

public class a2349NumberContainers {
    Map<Integer, TreeSet<Integer>> map;
    Map<Integer, Integer> indexMap;

    public a2349NumberContainers() {
        map = new HashMap<>();
        indexMap = new HashMap<>();
    }

    public void change(int index, int number) {
        Integer old = indexMap.get(index);
        if (Objects.nonNull(old)) {
            map.get(old).remove(index);
        }
        indexMap.put(index, number);
        TreeSet<Integer> orDefault = map.getOrDefault(number, new TreeSet<>());
        orDefault.add(index);
        map.put(number, orDefault);
    }

    public int find(int number) {
        TreeSet<Integer> orDefault = map.getOrDefault(number, null);
        if (Objects.isNull(orDefault) || orDefault.isEmpty()) return -1;
        return orDefault.first();
    }
}
