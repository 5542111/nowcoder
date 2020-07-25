
public class maxProfitAssignment826 {
    public static void main(String[] args) {
        int[] diff = {68, 35, 52, 47, 86};
        int[] pro = {67,17,1,81,3};
        int[] worker={92,10,85,84,82};
        maxProfitAssignment826 maxProfitAssignme=new maxProfitAssignment826();
        maxProfitAssignme.maxProfitAssignment(diff,pro,worker);
        /**
         * [68,35,52,47,86]
         * [67,17,1,81,3]
         * [92,10,85,84,82]
         */
    }

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        double[] ratio = new double[difficulty.length];
        for (int i = 0; i < difficulty.length; i++) {
            double x = difficulty[i], y = profit[i];
            ratio[i] = y / x;
        }
        //以性价比为尺度
//        for (int i = 1; i < ratio.length; i++) {
//            for (int j = i; j >0; j--) {
//                if (ratio[j] < ratio[j - 1]) {
//                    swap(difficulty[j-1], difficulty[j]);
//                    swap(profit[j-1], profit[j]);
//                    swap(ratio[j-1], ratio[j]);
//                }
//                else break;
//            }
//        }
        insertSort(difficulty);
        for (int i = 0; i < ratio.length; i++) {
            System.out.println( difficulty[i]);
        }
        int sum = 0;
        for (int i = 0; i < worker.length; i++) {
            for (int j = difficulty.length - 1; j >=0; j--) {
                if (worker[i] > difficulty[j]) {
                    //System.out.println(j);
                    sum += profit[j];
                    break;
                }
            }
        }
        return sum;
    }

    public void swap(double a, double b) {
        double temp = a;
        a = b;
        b = temp;
    }
    public void insertSort(int[] arr) {
        //插入排序
        for (int i = 1; i < arr.length; i++) {
            //外层循环，从第二个开始比较
            for (int j = i; j > 0; j--) {
                //内存循环，与前面排好序的数据比较，如果后面的数据小于前面的则交换
                if (arr[j] < arr[j - 1]) {
                    swap(arr[j], arr[j - 1]);
                } else {
                    //如果不小于，说明插入完毕，退出内层循环
                    break;
                }
            }
        }
    }


}
