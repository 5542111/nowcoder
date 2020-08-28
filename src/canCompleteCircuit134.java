import java.lang.reflect.GenericArrayType;

public class canCompleteCircuit134 {
    public static void main(String[] args) {
        int[] gas = new int[]{1, 2, 3, 4, 5};
        int[] cost = new int[]{3, 4, 5, 1, 2};
        System.out.println(canCompleteCircuit2(gas, cost));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        //暴力
        for (int i = 0; i < gas.length; i++) {
            int sum = 0;
            for (int j = i; j < i + gas.length; j++) {
                sum = sum + gas[j % gas.length];
                sum -= cost[j % gas.length];

                if (sum < 0) break;
            }
            if (sum >= 0) return i;
        }
        return -1;

    }

    public static int canCompleteCircuit2(int[] gas, int[] cost) {

        int sum = 0;

        int num = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            num += gas[i] - cost[i];
            if (num < 0) {
                start++;
                num = 0;
            }

        }
        return sum >= 0 ? start : 1;

    }
}
