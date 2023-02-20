import java.util.HashMap;
import java.util.Map;

public class a2347bestHand {

    public String bestHand(int[] ranks, char[] suits) {

        Map<Integer, Integer> countMap = new HashMap<>();
        Map<Character, Integer> flowerMap = new HashMap<>();

        for (int i = 0; i < ranks.length; i++) {
            int count = countMap.getOrDefault(ranks[i], 0);
            if (count == 2){
                return "Three of a Kind";
            }
            countMap.put(ranks[i], count + 1);

            int flowerCount = flowerMap.getOrDefault(suits[i], 0);
            flowerMap.put(suits[i], flowerCount + 1);
        }
        if (flowerMap.size() == 1) {
            return "Flush";
        }
        if (countMap.size() == 5){
            return "High Card";
        }


        return "Pair";
    }
}
