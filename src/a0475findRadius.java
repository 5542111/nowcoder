import java.util.Arrays;

public class a0475findRadius {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int left = 0, right = (int) 1e9;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (check(houses, heaters, mid)) right = mid;
            else left = mid + 1;
        }
        return right;
    }

    private boolean check(int[] houses, int[] heaters, int x) {
        for (int i = 0, j = 0; i < houses.length; i++) {
            while (j < heaters.length && houses[i] - x > heaters[j]) j++;
            if (j < heaters.length && heaters[j] - x <= houses[i] && houses[i] <= heaters[j] + x) continue;
            return false;
        }
        return true;
    }

    public int findRadius2(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int right = 0;
        int radius = 0;
        for (int house : houses) {
            while (right < heaters.length && house > heaters[right]) right++;
            if (right == 0) radius = Math.max(radius, heaters[right] - house);
            else if (right == heaters.length)
                return Math.max(radius, houses[houses.length - 1] - heaters[right-1]);
            else radius = Math.max(radius, Math.min(heaters[right] - house, house - heaters[right - 1]));
        }
        return radius;
    }
}
