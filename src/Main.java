import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        thirdOne();
    }

    public static int firstOne() {
        int max = 0;
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int[] first = new int[n];
        int[] Second = new int[n];
        for (int i = 0; i < n; i++) {
            int x = scan.nextInt();
            first[i] = x;

        }
        for (int i = 0; i < n; i++) {
            int x = scan.nextInt();
            Second[i] = x;

        }
        Arrays.sort(first);
        Arrays.sort(Second);
        for (int i = 0; i < n; i++) {
            int tmp = first[i] + Second[n - i - 1];
            if (max < tmp) {
                max = tmp;
            }
        }
        System.out.println(max);
        return 0;

    }

    public static int secondOne() {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int sum = 0;
//        if (s.length() <= 1) {
//            System.out.println(0);
//            return 0;
//        }

        char[] chars = s.toCharArray();
        char temp = chars[0];

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (chars[j] != chars[i]) {
                    sum++;
                    i = j;
                    break;
                }
            }
        }
        System.out.println(sum);

        return sum;
    }

    public static int thirdOne() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int k = scan.nextInt();

        int[][] box = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0;  j< m; j++) {
                int x = scan.nextInt();
                box[i][j] = x;
            }

        }
        int[] ans=new int[n*m];
        int num=0;
        Map<Integer, Integer> map = new TreeMap<>();


        for (int i = 0; i < n; i++) {
            int sum = 0;
            int[][] temp=box.clone();
            for (int j = 0; j < m; j++) {
                sum += temp[i][j];
                temp[i][j]=0;
            }


        }
        for (int i = 0; i < n; i++) {
            int sum = 0;
            int[][] temp=box;
            for (int j = 0; j < m; j++) {
                sum += temp[i][j];
                temp[i][j]=0;
            }
            ans[num]=sum;
            num++;
            map.put(sum, i);
        }
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += box[j][i];
            }
            ans[num]=sum;
            num++;
            map.put(sum, i);
        }
        System.out.println(num);
        for (Map.Entry<Integer, Integer> o : map.entrySet()) {
            System.out.println(o.getKey() + "," + o.getValue());
        }

        return 0;
    }
}

