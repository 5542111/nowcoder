import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

public class onlineNum {
    public static void main(String[] args) {
        Log log1 = new Log(1, 1000);
        Log log2 = new Log(3000, 4000);
        Log log3 = new Log(2, 40000);
        Log log4 = new Log(2000, 50000);
        ArrayList<Log> ls = new ArrayList<>();
        ls.add(log1);
        ls.add(log2);
        ls.add(log3);
        ls.add(log4);
        new onlineNum().sovle(ls);

    }

    private void sovle1(ArrayList<Log> ls) {
        int[] onlineNums = new int[24 * 60 * 60];
        int maxOnlineNum = 0;
        int maxOnlineStart = 0, maxOnlineEnd = 0;
        int maxOnlineNumLast = 0;

        for (Log rangeTime : ls) {
            for (int i = rangeTime.startTime; i <= rangeTime.endTime; i++) {
                onlineNums[i]++;
                if (onlineNums[i] > maxOnlineNum) {
                    maxOnlineNum = onlineNums[i];
                }
            }
        }

        for (int i = 0; i < 24 * 60 * 60; i++) {

            if (onlineNums[i] == maxOnlineNum) {
                int lastTime = 1;
                int startTime = i;

                while (onlineNums[i] == onlineNums[i + 1]) {
                    i++;
                    lastTime++;
                }
                int endTime = i;


                if (lastTime > maxOnlineNumLast) {
                    maxOnlineStart = startTime;
                    maxOnlineEnd = endTime;
                }
            }


        }
        System.out.println(maxOnlineNum);
        System.out.println(maxOnlineStart+" "+ maxOnlineEnd);
       // System.out.println(maxOnlineNumLast);
    }


    public int[] sovle(ArrayList<Log> logs) {
        int[] Time = new int[24 * 60 * 60];
        int maxOnlineNum = 0;
        int maxOnlineStart = 0, maxOnlineEnd = 0;
        int maxOnlineNumLast = 0;

        int time = 0;
        while (time < 24 * 60 * 60) {
            for (Log log : logs) {
                if (time >= log.startTime && time < log.endTime) {
                    Time[time]++;
                }
            }
            time++;
        }

        //获取最大在线人数
        int max = 0;


        for (int i = 1; i < Time.length; i++) {
            if (max < Time[i]) {
                max = Time[i];

            }
        }



        for (Log log : logs) {
            if (Time[log.startTime]==max){
                System.out.println(log.startTime +" "+ max);
            }
            
        }


        return new int[2];
    }


}
    class Log {
        int startTime;
        int endTime;
        //int userId;

        public Log(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }