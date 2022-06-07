import java.util.Arrays;

public class a0875minEatingSpeed {
    public int minEatingSpeed(int[] piles, int h) {
        int kMin = 1;
        int kMax = 0;
        for (int pile : piles) {
            kMax = Math.max(pile, kMax);
        }
        int k = kMax;
        while (kMin < kMax) {
            int speed = (kMax - kMin) / 2 + kMin;
            long time = 0;
            for (int pile : piles) {
                int curTime = 0;
                if (pile % speed == 0) {
                    curTime = pile / speed;
                } else {
                    curTime = pile / speed + 1;
                }
                //向上取整 【pile/speed】 可以写成 【(pile + speed -1) / speed】这样的向下取整
                time += curTime;
            }

            if (time <= h) {
                k = speed;
                kMax = speed;
            } else {
                kMin = speed + 1;
            }
        }

        return k;

    }
}
