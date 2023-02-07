import java.util.*;

public class a1604alertNames {

    public List<String> alertNames(String[] keyName, String[] keyTime) {
        List<String> ans = new ArrayList<>();
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < keyName.length; i++) {
            String name = keyName[i];
            int hours = Integer.parseInt(keyTime[i].substring(0, 2));
            int minutes = Integer.parseInt(keyTime[i].substring(3));
            List<Integer> times = map.getOrDefault(name, new ArrayList<>());
            times.add(hours * 60 + minutes);
            map.put(name, times);
        }

        for (String name : map.keySet()) {
            List<Integer> times = map.get(name);
            Collections.sort(times);
            for (int i = 2; i < times.size(); i++) {
                int after = times.get(i);
                int before = times.get(i - 2);
                if (after - before <= 60) {
                    ans.add(name);
                    break;
                }
            }
        }
        Collections.sort(ans);

        return ans;
    }
}
